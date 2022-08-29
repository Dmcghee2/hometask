package com.demo.hometask.controller;

import com.demo.hometask.AppConfigs;
import com.demo.hometask.objects.Result;
import com.demo.hometask.requests.CheckAccountRequest;
import com.demo.hometask.responses.CheckAccountResponse;
import com.demo.hometask.responses.DataSourceResponse;
import com.demo.hometask.services.CheckAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
// Class
public class AccountsController {

	@Autowired
	private AppConfigs configs;

	private CheckAccountService checkAccountService;

	public AccountsController(CheckAccountService checkAccountService) {
		this.checkAccountService = checkAccountService;
	}


	// Handling post request
	@PostMapping("/CheckAccount")
	CheckAccountResponse insert(@RequestBody CheckAccountRequest checkAccountRequest) {
		ArrayList<String> sources = checkAccountRequest.getSources();

		if((sources == null || sources.isEmpty()) &&
				(configs.getConfigsources() != null & !configs.getConfigsources().isEmpty())) {
			sources = configs.getConfigsources();
		}
		DataSourceResponse responses = checkAccountService.callAPIs(sources, checkAccountRequest.getAccountNumber());

		//convert to Translator class
		int idx = 0;
		ArrayList<Result> resultsArrayList = new ArrayList<>();
		for(Boolean response: responses.getAreValid()) {
			Result result = new Result(sources.get(idx),response);
			resultsArrayList.add(result);
			idx++;
		}

		CheckAccountResponse checkAccountResponse = new CheckAccountResponse(resultsArrayList);
		return checkAccountResponse;
	}
}
