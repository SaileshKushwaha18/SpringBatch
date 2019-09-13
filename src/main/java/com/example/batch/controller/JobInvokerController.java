package com.example.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class JobInvokerController {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	@Qualifier("accountJob")
	Job accountKeeperJob;

	@RequestMapping("/invokejob")
	public String handle1() throws Exception {

		JobParameters jobParameters = new JobParametersBuilder()
				.addString("JobID", String.valueOf(System.currentTimeMillis())).toJobParameters();
		jobLauncher.run(accountKeeperJob, jobParameters);

		return "Batch job has been invoked";
	}
}