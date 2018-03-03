package com.batch.springbatch;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batch.steps.TempProcessor;
import com.batch.steps.TempReader;
import com.batch.steps.TempWriter;

@Configuration
@EnableBatchProcessing

public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	// tag::jobstep[]
	@Bean
	public Job addNewPodcastJob(){
		return jobs.get("addNewPodcastJob")
				.start(step())
				.build();
	}

	@Bean
	public Step step(){
		return stepBuilderFactory.get("step")
				.<List<String>,List<String>>chunk(2) //important to be one in this case to commit after every line read
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}

	@Bean
	public TempReader reader(){
		/*FlatFileItemReader<SuggestedPodcast> reader = new FlatFileItemReader<SuggestedPodcast>();
		reader.setLinesToSkip(1);//first line is title definition
		reader.setResource(new ClassPathResource("suggested-podcasts.txt"));
		reader.setLineMapper(lineMapper());*/
		return new TempReader();
	}

	

	

	/** configure the processor related stuff */
    @Bean
    public TempProcessor processor() {
        return new TempProcessor();
    }

    @Bean
    public ItemWriter<? super List<String>> writer() {
    	return new TempWriter();
    }

	

}