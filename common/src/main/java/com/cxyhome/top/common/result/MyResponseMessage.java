package com.cxyhome.top.common.result;


import com.cxyhome.top.common.constant.ConstantEnum;

public class MyResponseMessage
{

	/**
	 * 消息
	 */
	private String message;

	/**
	 * 号码
	 */
	private int code;

    /**
     * 状态
     */
    private Integer status;

	public static MyResponseMessage OK ()
	{
		return new MyResponseMessage(ConstantEnum.ResponseMsg.OK.getValue(), ConstantEnum.HttpStatusCode.OK.getStatus(),MyStatus.ReTure());
	}

	/**
	 * 插入数据失败时候的调用
	 * private String message;
	 * private int code;
	 */
	public static MyResponseMessage INSERTFAIL ()
	{
		return new MyResponseMessage(ConstantEnum.ResponseMsg.INSERT_FAILURE.getValue(), ConstantEnum.HttpStatusCode.CONTINUE.getStatus(),MyStatus.ReFalse());
	}

	/**
	 * 更新失败时候的调用
	 * private String message;
	 * private int code;
	 */
	public static MyResponseMessage UPDATEFAIL ()
	{
		return new MyResponseMessage(ConstantEnum.ResponseMsg.UPDATE_FAILURE.getValue(), ConstantEnum.HttpStatusCode.CONTINUE.getStatus(),MyStatus.ReFalse());
	}

	/**
	 * 删除失败时候的调用
	 * private String message;
	 * private int code;
	 */
	public static MyResponseMessage DELETEFAIL ()
	{
		return new MyResponseMessage(ConstantEnum.ResponseMsg.DELETE_FAILURE.getValue(), ConstantEnum.HttpStatusCode.CONTINUE.getStatus(),MyStatus.ReFalse());
	}

	/**
	 * 失败时候的调用
	 * private String message;
	 * private int code;
	 */
	public static MyResponseMessage FAIL (String message)
	{
		return new MyResponseMessage(message, ConstantEnum.HttpStatusCode.CONTINUE.getStatus(),MyStatus.ReFalse());
	}

	/**
	 * 已存在
	 *
	 * @param message
	 * @return
	 */
	public static MyResponseMessage EXISTS (String message)
	{
		return new MyResponseMessage(message, ConstantEnum.HttpStatusCode.CONTINUE.getStatus(),MyStatus.ReFalse());
	}

	/**
	 * SYSTEMERROR(500, "服务器错误")
	 *
	 * @return
	 */
	public static MyResponseMessage SYSTEMERROR ()
	{
		return new MyResponseMessage(ConstantEnum.ResponseMsg.SYSTEM_ERROR.getValue(), ConstantEnum.HttpStatusCode.INTERNALSERVERERROR.getStatus(),MyStatus.ReFalse());
	}

	/**
	 * ,NODATA(100,"无数据")
	 *
	 * @return
	 */
	public static MyResponseMessage NODATA ()
	{
		return new MyResponseMessage(ConstantEnum.ResponseMsg.NO_DATA.getValue(), ConstantEnum.HttpStatusCode.CONTINUE.getStatus(),MyStatus.ReTure());
	}

	/**
	 * ,NORULE(100,"无权限");
	 *
	 * @return
	 */
	public static MyResponseMessage NORULE ()
	{
		return new MyResponseMessage(ConstantEnum.ResponseMsg.NO_AUTHORITY.getValue(), ConstantEnum.HttpStatusCode.CONTINUE.getStatus(),MyStatus.ReFalse());
	}

	/**
	 * ,NORULE(100,"无权限");
	 *
	 * @return
	 */
	public static MyResponseMessage QRCODEXIPRE ()
	{
		return new MyResponseMessage(ConstantEnum.ResponseMsg.QRCOD_EXIPRE.getValue(), ConstantEnum.HttpStatusCode.CONTINUE.getStatus(),MyStatus.ReFalse());
	}

	/**
	 * ,NORULE(100,"无权限");
	 *
	 * @return
	 */
	public static MyResponseMessage NOTOKEN ()
	{
		return new MyResponseMessage(ConstantEnum.ResponseMsg.NO_TOKEN.getValue(), ConstantEnum.HttpStatusCode.CONTINUE.getStatus(),MyStatus.ReFalse());
	}


	public static MyResponseMessage QRCODEERROR ()
	{
		return new MyResponseMessage(ConstantEnum.ResponseMsg.QRCODE_ERROR.getValue(), ConstantEnum.HttpStatusCode.CONTINUE.getStatus(),MyStatus.ReFalse());
	}

	/**
	 * 必传参数为空
	 * @param message
	 * @return
	 */
	public static MyResponseMessage PARAMETSISEMPTY (String message)
	{
		return new MyResponseMessage(message, ConstantEnum.HttpStatusCode.BADREQUEST.getStatus(),MyStatus.ReFalse());
	}

    /**
     * ,PARAMETERERROR(103,"无权限");
     *
     * @return
     */
    public static MyResponseMessage PARAMETERERROR ()
    {
        return new MyResponseMessage("参数错误", 105,MyStatus.ReFalse());
    }

    /**
     * ,NORULE(103,"无权限");
     *
     * @return
     */
    public static MyResponseMessage captchaError()
    {
        return new MyResponseMessage("验证码错误", 105,MyStatus.ReFalse());
    }

    /**
     * ,NORULE(103,"无权限");
     *
     * @return
     */
    public static MyResponseMessage captchaExipred()
    {
        return new MyResponseMessage("验证码过期", 105,MyStatus.ReFalse());
    }


	public MyResponseMessage (String message, int code)
	{
		this.message = message;
		this.code = code;
	}

	public String getMessage ()
	{
		return message;
	}

	public void setMessage (String message)
	{
		this.message = message;
	}

	public int getCode ()
	{
		return code;
	}

	public void setCode (int code)
	{
		this.code = code;
	}

    public MyResponseMessage(String message, int code, Integer status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
