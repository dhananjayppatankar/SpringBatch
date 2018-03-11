package com.batch.steps;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.core.io.Resource;

import com.batch.model.Customer;

public class FlatItemReader extends FlatFileItemReader<Customer>{

	@Override
	public void setLineMapper(LineMapper<Customer> lineMapper) {
		// TODO Auto-generated method stub
		super.setLineMapper(lineMapper);
	}

	@Override
	public void setResource(Resource resource) {
		// TODO Auto-generated method stub
		super.setResource(resource);
	}

	@Override
	public void setStrict(boolean strict) {
		// TODO Auto-generated method stub
		super.setStrict(strict);
	}
	
	
	
	
	
	
	
	

}
