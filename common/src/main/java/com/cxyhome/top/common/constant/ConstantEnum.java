package com.cxyhome.top.common.constant;

/**
 * 状态枚举
 */
public class ConstantEnum
{

	/**
	 * 通用的结果状态
	 */
	public enum Result
	{
		/**
		 * 成功
		 */
		SUCCESS(0, "成功"),
		/**
		 * 失败
		 */
		FAILURE(1, "失败");

		Result (Integer code, String name)
		{
			this.code = code;
			this.name = name;
		}

		private final Integer code;
		private final String name;

		public Integer getValue ()
		{
			return code;
		}

		public String getName ()
		{
			return name;
		}
	}
	
	 /**
     * 返回相应参数
     */
    public enum ResponseMsg {
    	  /**
         * 响应成功
         */
        OK("响应成功"),
    	  /**
         * 查询成功
         */
        SELECT_SUCCESS("查询成功"),
        /**
         * 查询失败
         */
        SELECT_FAILURE("查询失败"),
        /**
         * 插入成功
         */
        INSERT_SUCCESS("插入成功"),
        /**
         * 插入失败
         */
        INSERT_FAILURE("插入失败"),
        /**
         * 更新成功
         */
        UPDATE_SUCCESS("更新成功"),
        /**
         * 更新失败
         */
        UPDATE_FAILURE("更新失败"),
        /**
         * 删除成功
         */
        DELETE_SUCCESS("删除成功"),
    	/**
         * 删除失败
         */
        DELETE_FAILURE("删除失败"),
    	/*
    	 * 服务器错误
    	 */
    	SYSTEM_ERROR("服务器错误"),
    	/*
    	 * 无数据
    	 */
    	NO_DATA("无数据"),
    	/*
    	 * 无权限
    	 */
    	NO_AUTHORITY("无权限"), 
    	/*
    	 * 二维码不存在或者已经过期
    	 */
    	QRCOD_EXIPRE(" 二维码不存在或者已经过期"),
    	/*
    	 * token不存在
    	 */
    	NO_TOKEN("token不存在"),
    	/*
    	 * qrcode状态异常
    	 */
    	QRCODE_ERROR("qrcode状态异常");

        private String value;

        private ResponseMsg(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

	/**
	 * 操作动作
	 */
	public enum Action
	{
		/**
		 * 新增
		 */
		ADD(1, "新增"),
		/**
		 * 删除
		 */
		DELETE(2, "删除"),
		/**
		 * 修改
		 */
		MODIFY(3, "修改"),
		/**
		 * 查询
		 */
		SEARCH(4, "查询");

		Action (Integer code, String name)
		{
			this.code = code;
			this.name = name;
		}

		private final Integer code;
		private final String name;

		public Integer getValue ()
		{
			return code;
		}

		public String getName ()
		{
			return name;
		}
	}

	/*
	 * 通用成功返回提示
	 */
	public enum MyData
	{
		addOK("添加成功"), updateOK("修改成功"), deleteOK("删除成功");

		MyData (String data)
		{
			this.data = data;
		}

		private final String data;

		public String getData ()
		{
			return data;
		}


	}

	/*
	 * 通用状态返回
	 */
	public enum MyStatus
	{
		OK(0), FALSE(1);

		MyStatus (int status)
		{
			this.status = status;
		}

		private final int status;

		public int getStatus ()
		{
			return status;
		}
	}
	
	/*
	 * http状态返回
	 */
	  public enum HttpStatusCode
	    {
	 
	        /*
	         * 指示客户端可能继续其请求
	         */
		   CONTINUE(100),
	        /*
	         * 指示请求成功
	         */
	        OK(200),
	        /*
	         * 指示请求导致在响应被发送前创建新资源
	         */
	        CREATED(201),
	        /*
	         * 指示请求已被接受做进一步处理
	         */
	        ACCEPTED(202),
	        /*
	         * 指示返回的元信息来自缓存副本而不是原始服务器，因此可能不正确
	         */
	        NONAUTHORITATIVEINFORMATION(203),
	        /*
	         * 指示已成功处理请求并且响应已被设定为无内容
	         */
	        NOCONTENT(204),
	        /*
	         * 指示客户端应重置（或重新加载）当前资源
	         */
	        RESETCONTENT(205),
	        /*
	         * 重定向
	         */
	        MULTIPLECHOICES(300),
	        /*
	         * 语法错误
	         */
	        BADREQUEST(400),
	        /*
	         * 请求的资源不在服务器上
	         */
	        NOTFOUND(404),
	        /*
	         * 请求的资源上不允许请求方法（POST 或 GET）
	         */
	        METHODNOTALLOWED(405),
	        /*
	         * 服务器上发生了一般错误
	         */
	        INTERNALSERVERERROR(500);
	        
		  HttpStatusCode (int status)
			{
				this.status = status;
			}

			private final int status;

			public int getStatus ()
			{
				return status;
			}
	    }


}
