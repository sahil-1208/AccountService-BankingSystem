package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

}
