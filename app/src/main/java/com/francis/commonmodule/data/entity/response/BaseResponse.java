package com.francis.commonmodule.data.entity.response;

/**
 * Created by Francis on 2018/10/10.
 */

public class BaseResponse<T> {

    //返回的code
    private int flag;
    //具体的返回内容
    private T body;
    //错误提示
    private String msg;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
