package com.batch.steps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class TempReader implements ItemReader<List<String>> {
	int count=0;
	List<String> list = new ArrayList<>();
	@Override
	public List<String> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
	
	
	BufferedReader bf = new BufferedReader(new FileReader("sample.txt"));
	
			list.add(bf.readLine());
			System.out.println(list);
			return list;
		

	}

}
