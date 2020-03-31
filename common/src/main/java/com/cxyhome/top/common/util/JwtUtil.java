package com.cxyhome.top.common.util;

import com.alibaba.fastjson.JSON;
import com.cxyhome.top.common.result.LoginInfo;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    //jwt私钥
    private static  String   Constant_JWT_SECRET = "yookey";
    /**
     * 创建jwt
     * @param id  jwtid
     * @param subject 返回给用户的信息
     * @param ttlMillis 过期的时间长度
     * @return
     * @throws Exception
     */
    public static final String createJWT(String id, String subject, long ttlMillis){
        //指定算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS384;
        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        Map<String,Object> claims = new HashMap<String,Object>();
        claims.put("application", "jszy-basic");
        //获取私钥
        SecretKey key = generalKey();
        //sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
        JwtBuilder builder = Jwts.builder()
                //这里设置的claims是私有的
                .setClaims(claims)
                .setId(id)
                .setIssuedAt(now)
                //主体 也是私有的
                .setSubject(subject)
                .signWith(signatureAlgorithm, key);
        //设置JWT的过期时间
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }


    /**
     * 解密jwt
     * @param jwt
     * @return
     * @throws Exception
     */
    public static final Claims parseJWT(String jwt){
        SecretKey key = generalKey();  //签名秘钥，和生成的签名的秘钥一模一样
        Claims claims = Jwts.parser()  //得到DefaultJwtParser
                .setSigningKey(key)         //设置签名的秘钥
                .parseClaimsJws(jwt).getBody();//设置需要解析的jwt
        return claims;
    }


    /**
     * 解密jwt为LoginInfo
     * @param jwt
     * @return
     * @throws Exception
     */
    public static final LoginInfo parseJWTToLogininfo(String jwt){
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(jwt);
        }catch (ExpiredJwtException e){
//            TODO:异常记录
            e.printStackTrace();
            return null;
        }catch (SignatureException e){
            e.printStackTrace();
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        LoginInfo loginInfo = JSON.parseObject(claims.getSubject(), LoginInfo.class);
        return loginInfo;
    }


    /**
     * JWTToken刷新生命周期
     * 1、登录成功后将用户的JWT生成的Token作为k、v存储到cache缓存里面(这时候k、v值一样)
     * 2、当该用户在次请求时，通过JWTFilter层层校验之后会进入到doGetAuthenticationInfo进行身份验证
     * 3、当该用户这次请求JWTToken值还在生命周期内，则会通过重新PUT的方式k、v都为Token值，缓存中的token值生命周期时间重新计算(这时候k、v值一样)
     * 4、当该用户这次请求jwt生成的token值已经超时，但该token对应cache中的k还是存在，则表示该用户一直在操作只是JWT的token失效了，程序会给token对应的k映射的v值重新生成JWTToken并覆盖v值，该缓存生命周期重新计算
     * 5、当该用户这次请求jwt在生成的token值已经超时，并在cache中不存在对应的k，则表示该用户账户空闲超时，返回用户信息已失效，请重新登录。
     * 6、每次当返回为true情况下，都会给Response的Header中设置Authorization，该Authorization映射的v为cache对应的v值。
     * 7、注：当前端接收到Response的Header中的Authorization值会存储起来，作为以后请求token使用
     * @param userName
     * @param passWord
     * @return
     */
//    public boolean jwtTokenRefresh(String userName,String passWord){
//        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
//        String token = httpServletRequest.getHeader(Constants.TOKEN);
//        String cacheTokenKey = String.valueOf(EhcacheUtils.getInstance().get("matedataManagement", token));
//        System.out.println(cacheTokenKey == null);
//        if(!StringUtils.isEmpty(cacheTokenKey) && !cacheTokenKey.equals("null")){
//            if (!JWTUtil.verify(token, userName, passWord)) {
//                String newAuthorization=JWTUtil.sign(userName, passWord);
//                EhcacheUtils.getInstance().put("matedataManagement", cacheTokenKey, newAuthorization, JWTUtil.getExpireTime()/1000);
//            }else {
//                EhcacheUtils.getInstance().put("matedataManagement", cacheTokenKey, cacheTokenKey,JWTUtil.getExpireTime()/1000);
//            }
//            response.setHeader("Authorization", String.valueOf(EhcacheUtils.getInstance().get("matedataManagement", cacheTokenKey)));
//            return true;
//        }
//        return false;
//    }

    /**
     * 由字符串生成加密key
     * @return
     */
    public static final SecretKey generalKey(){
        String stringKey = Constant_JWT_SECRET;//本地配置文件中加密的密文7786df7fc3a34e26a61c034d5ec8245d
        byte[] encodedKey = Base64.getDecoder().decode(stringKey);//本地的密码解码[B@152f6e2
        // 根据给定的字节数组使用AES加密算法构造一个密钥，使用 encodedKey中的始于且包含 0 到前 leng 个字节这是当然是所有。（后面的文章中马上回推出讲解Java加密和解密的一些算法）
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "HS256");
        return key;
    }
}
