package com.example.practice7.models;

public class ResponseObject {
    private String status;
    private String object;
    private Object data;

    public ResponseObject(String status, String object, Object data) {
        this.status = status;
        this.object = object;
        this.data = data;
    }

    public ResponseObject() {
    }

    public String getStatus() {
        return status;
    }

    public String getObject() {
        return object;
    }

    public Object getData() {
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
