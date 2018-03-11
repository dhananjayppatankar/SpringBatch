package com.batch.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.batch.model.Customer;
import com.batch.steps.TempProcessor;
import com.batch.steps.TempWriter;

@Configuration
@EnableBatchProcessing

public class BatchConfig {

	@Autowired
	private  JobBuilderFactory jobs;

	@Autowired
	private  StepBuilderFactory stepBuilderFactory;

	// tag::jobstep[]
	@Bean
	public Job customerjob(){
		return jobs.get("customerjob")
				.incrementer(new RunIdIncrementer())
                .flow(step())
                .end()
                .build();
	}

	@Bean
	public Step step(){
		return stepBuilderFactory.get("step")
				.<Customer,Customer>chunk(2) //important to be one in this case to commit after every line read
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}

	/*@Bean
	public TempReader reader(){
		FlatFileItemReader<Customer> reader = new FlatFileItemReader<Customer>();
		reader.setResource(new ClassPathResource("sample.txt"));
		reader.setLineMapper(lineMapper());
		return new TempReader();
	}*/

	@Bean
	public FlatFileItemReader<Customer> reader(){
		FlatFileItemReader<Customer> reader = new FlatFileItemReader<Customer>();
		reader.setResource(new FileSystemResource("resources/sample.txt"));
		reader.setLineMapper(new DefaultLineMapper<Customer>() {{
		setLineTokenizer(new FixedLengthTokenizer(){{
			setNames(new String[] {"id","name","role"});
			setColumns(new Range[] {new Range(1,1), new Range(1,10), new Range(11,22)});
			setStrict(false);
		}});
		setFieldSetMapper(new BeanWrapperFieldSetMapper<Customer>() {{
			setTargetType(Customer.class);
		}});
		}});
		return reader();
		
	}
	
	
	
	
	/*@Bean
	public TempReader reader() {
		
		return new TempReader();
	}*/

	

	/** configure the processor related stuff */
    @Bean
    public TempProcessor processor() {
        return new TempProcessor();
    }

    @Bean
    public TempWriter writer() {
    	return new TempWriter();
    }

	

}