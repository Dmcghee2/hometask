package com.demo.hometask.services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import com.demo.hometask.AppConfigs;
import com.demo.hometask.requests.DataSourceRequest;
import com.demo.hometask.responses.DataSourceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CheckAccountService {

    private RestTemplate restTemplate;

    @Autowired
    public CheckAccountService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DataSourceResponse callAPIs(ArrayList<String> sources, String accountNumber){
         ArrayList<Boolean> responses = new ArrayList<>();

         for (String source : sources) {
                final String uri = source;
                DataSourceRequest dataSourceRequest = new DataSourceRequest(accountNumber);
                Boolean result = restTemplate.postForObject(uri, dataSourceRequest, Boolean.class);
                System.out.println(result);
                responses.add(result);
            }

        return new DataSourceResponse(responses);
     }

}
