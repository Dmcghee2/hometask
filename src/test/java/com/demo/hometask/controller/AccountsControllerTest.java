package com.demo.hometask.controller;

import com.demo.hometask.objects.Result;
import com.demo.hometask.requests.CheckAccountRequest;
import com.demo.hometask.responses.CheckAccountResponse;
import com.demo.hometask.responses.DataSourceResponse;
import com.demo.hometask.services.CheckAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AccountsControllerTest {

    private AccountsController accountsController;
    @Mock
    private CheckAccountService mockCheckAccountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        accountsController = new AccountsController(mockCheckAccountService);
        when(mockCheckAccountService.callAPIs(any(), any()))
                .thenReturn(new DataSourceResponse(new ArrayList<>(Arrays.asList(true, false))));
    }

    @Test
    void insert() {
        CheckAccountRequest checkAccountRequest = new CheckAccountRequest();
        checkAccountRequest.setAccountNumber("123456");
        checkAccountRequest.setSources(new ArrayList<>(Arrays.asList("source1", "source2")));

        CheckAccountResponse checkAccountsResponse = accountsController.insert(checkAccountRequest);


        assertTrue(checkAccountsResponse.getResults()
                .equals(new ArrayList<>(
                        Arrays.asList(new Result("source1", true), new Result("source2", false)))));
    }
}