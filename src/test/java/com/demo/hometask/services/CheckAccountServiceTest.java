package com.demo.hometask.services;

import com.demo.hometask.requests.DataSourceRequest;
import com.demo.hometask.responses.DataSourceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class CheckAccountServiceTest {

    public CheckAccountService testCheckAccountService;

    @Mock
    public RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testCheckAccountService = new CheckAccountService(restTemplate);
        when(restTemplate.postForObject(eq("http://localhost:8080/source12"), any(), any())).thenReturn(false);
        when(restTemplate.postForObject(eq("http://localhost:8080/source34"), any(), any())).thenReturn(true);

    }

    @Test
    void callAPIs_should_return_proper_responses_based_on_source() {
        ArrayList<String> sources = new ArrayList<>(Arrays.asList("http://localhost:8080/source12", "http://localhost:8080/source34"));

        DataSourceResponse response = testCheckAccountService.callAPIs(sources, "testAccountNumber");

        ArrayList<Boolean> expectedResponses = new ArrayList<>(Arrays.asList(false, true));
        assertTrue(response.getAreValid().equals(expectedResponses));
    }
}