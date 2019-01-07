package com.nithin.springdatajpa.transactionmanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nithin.springdatajpa.transactionmanagement.services.BankAccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionmanagementApplicationTests {

	@Autowired
	BankAccountService service;
	
	@Test
	public void testTransfer() {
		service.transfer(500);
	}
	
}