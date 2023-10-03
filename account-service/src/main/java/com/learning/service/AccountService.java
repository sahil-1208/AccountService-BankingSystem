package com.learning.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.AccountEntity;
import com.learning.enums.Status;
import com.learning.model.AccountRequest;
import com.learning.model.AccountResponse;
import com.learning.repo.AccountRepository;
import com.learning.utils.Convertor;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private Convertor convertor;

	public AccountResponse create(AccountRequest accountRequest) {
		AccountResponse accountResponse = null;
		if (Objects.nonNull(accountRequest)) {
			AccountEntity accountEntity = convertor.requestToEntity(accountRequest);
			accountEntity = accountRepo.save(accountEntity);
			accountResponse = convertor.entityToResponse(accountEntity);
		}
		return accountResponse;
	}

	public AccountResponse findAccountById(Long id) {
		AccountResponse accountResponse = null;
		Optional<AccountEntity> optionalEntity = accountRepo.findById(id);
		if (optionalEntity.isPresent()) {
			AccountEntity accountEntity = optionalEntity.get();
			accountResponse = convertor.entityToResponse(accountEntity);
		}
		return accountResponse;
	}

	public AccountResponse update(Long id, AccountRequest accountRequest) {
		AccountResponse accountResponse = null;
		Optional<AccountEntity> optionalEntity = accountRepo.findById(id);
		if (optionalEntity.isPresent()) {
			AccountEntity accountEntity = optionalEntity.get();
			accountEntity = convertor.updateEntity(accountRequest, accountEntity);
			accountEntity = accountRepo.save(accountEntity);
			accountResponse = convertor.entityToResponse(accountEntity);
		}
		return accountResponse;
	}

	public Status deleteAccountById(Long id) {
		Optional<AccountEntity> optionalEntity = accountRepo.findById(id);
		if (optionalEntity.isPresent()) {
			accountRepo.deleteById(id);
			return Status.SUCCESS;
		}
		return Status.FAILED;
	}

}
