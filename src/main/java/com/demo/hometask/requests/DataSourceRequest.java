package com.demo.hometask.requests;

import lombok.Data;

@Data
public class DataSourceRequest {
    private String accountNumber;

    public DataSourceRequest(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}
