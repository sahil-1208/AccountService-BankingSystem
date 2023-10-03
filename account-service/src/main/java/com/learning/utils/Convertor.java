package com.learning.utils;

import org.springframework.stereotype.Component;

import com.learning.entity.AccountEntity;
import com.learning.model.AccountRequest;
import com.learning.model.AccountResponse;

@Component
public class Convertor {
	
	public AccountEntity requestToEntity(AccountRequest accountRequest) {
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setName(accountRequest.getName());
		accountEntity.setAccountNumber(accountRequest.getAccountNumber());
		accountEntity.setIfsc(accountRequest.getIfsc());
		accountEntity.setUserId(accountRequest.getUserId());
		return accountEntity;
	}
	
	public AccountResponse entityToResponse(AccountEntity accountEntity) {
		AccountResponse accountResponse = new AccountResponse();
		accountResponse.setId(accountEntity.getId());
		accountResponse.setName(accountEntity.getName());
		accountResponse.setAccountNumber(accountEntity.getAccountNumber());
		accountResponse.setIfsc(accountEntity.getIfsc());
		accountResponse.setUserId(accountEntity.getUserId());
		return accountResponse;
	}
	
	public AccountEntity updateEntity(AccountRequest accountRequest, AccountEntity accountEntity) {
		accountEntity.setName(accountRequest.getName());
		accountEntity.setAccountNumber(accountRequest.getAccountNumber());
		accountEntity.setIfsc(accountRequest.getIfsc());
		accountEntity.setUserId(accountRequest.getUserId());
		return accountEntity;
	}

}
