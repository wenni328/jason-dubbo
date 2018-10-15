package com.jason.dubbo.provider.api.utils;

/**
 * @author: xieyong
 * @date: 2018/9/28 16:23
 * @Description:
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -7221430743998758357L;
    private String code = "0000";
    private String message;
    public BaseException(Throwable cause) {
        super(cause);
    }
    public BaseException(){
        super();
    }
    public BaseException(String message) {
        super(message);
        this.message = message;
    }
    public BaseException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }
    public BaseException(String code,String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    public BaseException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    @Override
    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {
        BaseException e = new BaseException("exc");
        System.out.println(e.getMessage());
    }
}
