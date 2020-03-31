package com.cxyhome.top.itemservicecompose.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@Configuration
public class DruidConfig {
    @Autowired
    private JdbcConfigBean jdbcConfigBean;

//    @Bean
//    public ServletRegistrationBean druidServlet() {
//        log.info("初始化druid servlet配置 ");
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        // IP白名单
//        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
//        // IP黑名单(共同存在时，deny优先于allow)
//        servletRegistrationBean.addInitParameter("deny", "192.168.1.100");
//        //控制台管理用户
//        servletRegistrationBean.addInitParameter("loginUsername", "admin");
//        servletRegistrationBean.addInitParameter("loginPassword", "123456");
//        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
//        servletRegistrationBean.addInitParameter("resetEnable", "false");
//        return servletRegistrationBean;
//    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }


        @Bean     //声明其为Bean实例
        @Primary  //在同样的DataSource中，首先使用被标注的DataSource
        public DataSource dataSource() {
            DruidDataSource datasource = new DruidDataSource();
            datasource.setUrl(jdbcConfigBean.getUrl());
            datasource.setUsername(jdbcConfigBean.getUsername());
            datasource.setPassword(jdbcConfigBean.getPassword());
            datasource.setDriverClassName(jdbcConfigBean.getDriverClassName());

            //configuration
            datasource.setInitialSize(jdbcConfigBean.getInitialSize());
            datasource.setMinIdle(jdbcConfigBean.getMinIdle());
            datasource.setMaxActive(jdbcConfigBean.getMaxActive());
            datasource.setMaxWait(jdbcConfigBean.getMaxWait());
            datasource.setTimeBetweenEvictionRunsMillis(jdbcConfigBean.getTimeBetweenEvictionRunsMillis());
            datasource.setMinEvictableIdleTimeMillis(jdbcConfigBean.getMinEvictableIdleTimeMillis());
            datasource.setValidationQuery(jdbcConfigBean.getValidationQuery());
            datasource.setTestWhileIdle(jdbcConfigBean.getTestWhileIdle());
            datasource.setTestOnBorrow(jdbcConfigBean.getTestOnBorrow());
            datasource.setTestOnReturn(jdbcConfigBean.getTestOnReturn());
            datasource.setPoolPreparedStatements(jdbcConfigBean.getPoolPreparedStatements());
            datasource.setMaxPoolPreparedStatementPerConnectionSize(jdbcConfigBean.getMaxPoolPreparedStatementPerConnectionSize());
            try {
                datasource.setFilters(jdbcConfigBean.getFilters());
            } catch (SQLException e) {
                System.err.println("ruid配置初始化filter: " + e);
            }
            datasource.setConnectionProperties(jdbcConfigBean.getConnectionProperties());
            return datasource;
        }

}
