package com.batch.steps;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.batch.model.Customer;

public class TempWriter implements ItemWriter<Customer> {

	@Override
	public void write(List<? extends Customer> arg0) throws Exception {
	
		
		System.out.println("Customer printed" + arg0);
	}

	
}
