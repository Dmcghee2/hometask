package com.demo.hometask.responses;

import com.demo.hometask.objects.Result;
import lombok.Data;

import java.util.ArrayList;
@Data
public class CheckAccountResponse {
    private ArrayList<Result> results;

    public CheckAccountResponse(ArrayList<Result> results) {
        this.results = results;
    }
}
