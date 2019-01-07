package com.nithin.springdatajpa.idgenerators.idgenerator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIDRandomGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor si, Object obj) throws HibernateException {
		int id=0;
		Random random = new Random();
		id = random.nextInt(1000000);
		return Long.valueOf(id);
	}

}