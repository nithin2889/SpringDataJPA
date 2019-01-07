package com.nithin.springdatajpa.transactionmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nithin.springdatajpa.transactionmanagement.entities.BankAccount;
import com.nithin.springdatajpa.transactionmanagement.entities.repos.BankAccountRepository;

@Service
class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository bankRepo;
	
	@Override
	public void transfer(int amount) {
		BankAccount snowAccount = bankRepo.findById(1).get();
		snowAccount.setBal(snowAccount.getBal()-amount);
		bankRepo.save(snowAccount);
		
		BankAccount aryaAccount = bankRepo.findById(2).get();
		aryaAccount.setBal(aryaAccount.getBal()+amount);
		bankRepo.save(aryaAccount);
	}

}