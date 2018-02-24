package com.batch.steps;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class TempWriter implements ItemWriter<List<String>> {

	@Override
	public void write(List<? extends List<String>> arg0) throws Exception {
		System.out.println("Writer ");
		
	}

	
}
