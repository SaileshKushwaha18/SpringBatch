package com.example.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
public class SpringBatchApplication {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	@Autowired
	@Qualifier("accountJob")
	Job accountKeeperJob;

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);
	}

// Uncommenting this will run the job automatically after some time.
//	@Scheduled(cron = "*/5 * * * * *")
//	public String handle1() throws Exception {
//
//		JobParameters jobParameters = new JobParametersBuilder()
//				.addString("JobID", String.valueOf(System.currentTimeMillis())).toJobParameters();
//		jobLauncher.run(accountKeeperJob, jobParameters);
//
//		return "Batch job has been invoked by Scheduling";
//	}

}
