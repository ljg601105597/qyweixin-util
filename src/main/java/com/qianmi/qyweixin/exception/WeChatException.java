package com.qianmi.qyweixin.exception;

public class WeChatException extends RuntimeException{

    private static final long serialVersionUID = -3967695783633762808L;

    private Long code = -1L;
    
    private String message;
    
    public WeChatException(String message) {
        super(message);
        this.message = message;
    }
    
    public WeChatException(Long code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    
    public WeChatException(Throwable e){
        super(e);
        if(e instanceof WeChatException){
        	this.code = ((WeChatException) e).getCode();
        }
        this.message = e.getMessage();
    }
    
    public WeChatException(String msg, Throwable e){
        super(msg,e);
        this.message = msg;
    }
    
    public WeChatException(Long code, Throwable e){
        super(e);
        this.message = e.getMessage();
        this.code = code;
    }

	public Long getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	

}
