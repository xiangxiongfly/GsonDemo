package com.example.lib_java.bean;

public class BaseResult<T> {
    public int code;
    public String message;
    public T data;

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}


