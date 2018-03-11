package com.batch.steps;

import org.springframework.batch.item.ItemProcessor;

import com.batch.model.Customer;

public class TempProcessor implements ItemProcessor<Customer,Customer> {

	@Override
	public Customer process(Customer arg0) throws Exception {
		// TODO Auto-generated method stub
		return arg0;
	}

	

}
