package com.thecareercore.thecareercore.dtos.responses;

public class ApiResponse {
    private boolean isSuccessful;
    private Object data;


    public  ApiResponse(boolean isSuccessful, Object data){
        this.isSuccessful=isSuccessful;
        this.data=data;

    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }
}
