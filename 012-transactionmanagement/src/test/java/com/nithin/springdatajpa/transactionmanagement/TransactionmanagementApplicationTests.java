package com.nithin.springdatajpa.transactionmanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.nithin.springdatajpa.transactionmanagement.entities.BankAccount;
import com.nithin.springdatajpa.transactionmanagement.entities.repos.BankAccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionmanagementApplicationTests {

	@Autowired
	BankAccountRepository repository;
	
	@Test
	@Transactional
	public void testTransfer(int amount) {
		BankAccount obamasAccount = repository.findById(1).get();
		obamasAccount.setBal(obamasAccount.getBal() - amount);
		repository.save(obamasAccount);
		
		if(true) {
			throw new RuntimeException();
		}
		
		BankAccount trumpsAccount = repository.findById(2).get();
		trumpsAccount.setBal(trumpsAccount.getBal() + amount);
		repository.save(trumpsAccount);
	}

}