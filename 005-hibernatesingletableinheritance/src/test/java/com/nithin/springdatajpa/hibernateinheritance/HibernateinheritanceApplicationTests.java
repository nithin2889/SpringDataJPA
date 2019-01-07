package com.nithin.springdatajpa.hibernateinheritance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nithin.springdatajpa.hibernateinheritance.entities.Check;
import com.nithin.springdatajpa.hibernateinheritance.entities.CreditCard;
import com.nithin.springdatajpa.hibernateinheritance.repos.PaymentRepos;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateinheritanceApplicationTests {
	
	@Autowired
	PaymentRepos pr;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void createCreditCardPayment() {
		CreditCard cc = new CreditCard();
		cc.setId(111);
		cc.setAmount(1000);
		cc.setCardnumber("1234567890");
		pr.save(cc);
	}
	
	@Test
	public void createCheckPayment() {
		Check ch = new Check();
		ch.setId(112);
		ch.setAmount(1233);
		ch.setChecknumber("9807654321");
		pr.save(ch);
	}

}