package com.zixue.demo.dto.model;

public class MessageInfoDtoWithBLOBs extends MessageInfoDto {
    private String response;

    private String request;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response == null ? null : response.trim();
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request == null ? null : request.trim();
    }
}