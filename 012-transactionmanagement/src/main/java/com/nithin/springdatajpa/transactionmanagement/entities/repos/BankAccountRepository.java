package com.nithin.springdatajpa.transactionmanagement.entities.repos;

import org.springframework.data.repository.CrudRepository;

import com.nithin.springdatajpa.transactionmanagement.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}