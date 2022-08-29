package com.demo.hometask.objects;

import lombok.Data;

@Data
public class Result {
    private String source;
    private Boolean isValid;

    public Result(String source, Boolean isValid) {
        this.source = source;
        this.isValid = isValid;
    }
}
