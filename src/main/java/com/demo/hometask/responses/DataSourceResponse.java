package com.demo.hometask.responses;

import lombok.Data;

import java.util.ArrayList;

@Data
public class DataSourceResponse {
    private ArrayList<Boolean> areValid;

    public DataSourceResponse(ArrayList<Boolean> areValid) {
        this.areValid = areValid;
    }
}
