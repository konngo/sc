package cn.konngo.exception;

public class DBTransforException extends Exception{

    public DBTransforException(String message,Throwable cause) {
        super(message,cause);
        System.out.println("数据库映射到对象异常");
    }


}
