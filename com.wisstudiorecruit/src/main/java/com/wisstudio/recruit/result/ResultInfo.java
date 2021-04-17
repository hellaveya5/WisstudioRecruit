package com.wisstudio.recruit.result;

/**
 * @author 98333
 */
public class ResultInfo {
    private boolean Flag;
    private Object data;
    private String msg;

    public ResultInfo() {
    }

    public boolean isFlag() {
        return Flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultInfo(boolean status, Object data, String msg) {
        this.Flag = status;
        this.data = data;
        this.msg = msg;
    }

    public void setFlag(boolean b) {
        Flag=b;
    }


}
