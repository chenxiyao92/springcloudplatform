package com.cxyhome.top.common.result;


public class Result<T>
{
	//
	private int code;
	//数据
	private T data;
	//错误显示消息
	private String msg;
	// 0 false 1 true
	private Integer status;

	public int getCode ()
	{
		return code;
	}

	public T getData ()
	{
		return data;
	}

	public Result<T> setMsg (String msg)
	{
		this.msg = msg;
		return this;
	}

	public Result<T> setData (T data)
	{
		this.data = data;
		return this;
	}

	public void setCode (int code)
	{
		this.code = code;
	}

	public String getMsg ()
	{
		return msg;
	}

	public Integer isStatus ()
	{
		return status;
	}

	public Result<T> setMessage (MyResponseMessage message)
	{
		this.msg = message.getMessage();
		this.code = message.getCode();
		return this;
	}

	public Result<T> setStatus (Integer status)
	{
		this.status = status;
		return this;
	}

	public Integer getStatus ()
	{
		
		return status;
	}

    public Result() {
    }
    public Result(T data, String msg, Integer status) {
        this.data = data;
        this.msg = msg;
        this.status = status;
    }

    public Result(T data,MyResponseMessage myResponseMessage) {
        this.data = data;
        this.msg = myResponseMessage.getMessage();
        this.status = myResponseMessage.getStatus();
        this.code = myResponseMessage.getCode();
    }

    /**
     * 成功时候的调用
     * */
    public static <T> Result<T> success(T data,MyResponseMessage myResponseMessage){
        return new Result<T>(data,myResponseMessage);
    }

    /**
     * 失败时候的调用
     * */
    public static <T> Result<T> error(MyResponseMessage myResponseMessage){
        return new  Result<T>(null,myResponseMessage);
    }
}
