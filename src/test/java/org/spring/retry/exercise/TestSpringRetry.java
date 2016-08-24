package org.spring.retry.exercise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.retry.exercise.config.AppConfig;
import org.spring.retry.exercise.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class TestSpringRetry {

	@Autowired
	private RegistrationService registrationService;
	
	@Test
	public void registerUserWithAttemptToRetryExpectRetries(){
		registrationService.sendNotifcation();
		Assert.assertEquals(Integer.valueOf(3), registrationService.getRetryCountForCurrentThread());
	}
}