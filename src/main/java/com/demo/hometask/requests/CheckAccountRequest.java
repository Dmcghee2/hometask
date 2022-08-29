package com.demo.hometask.requests;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
@Data
public class CheckAccountRequest {

    private String accountNumber;

    @Nullable
    private ArrayList<String> sources;

    @Override
    public String toString() {
        return "CheckAccountRequest{" +
                "accountNumber='" + accountNumber + '\'' +
                ", sources=" + sources +
                '}';
    }
}
