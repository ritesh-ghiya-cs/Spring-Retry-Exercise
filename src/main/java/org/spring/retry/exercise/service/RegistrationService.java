package org.spring.retry.exercise.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

	private Map<String, Integer> threadNameRetryCountMap = new HashMap<>();
	
	@Autowired
	private NotificationService notificationService;
	
	public Integer getRetryCountForCurrentThread(){
		return threadNameRetryCountMap.get(Thread.currentThread().getName());
	}
	
	@Retryable(maxAttempts = 3)
	public void sendNotifcation() {
		try{
			notificationService.sendNotification();
		}
		catch ( UnsupportedOperationException e ){
			maintainAttemptCount();
			if ( getRetryCountForCurrentThread() < 3 ) throw e;
		}
	}
	
	private void maintainAttemptCount(){
		final Integer attemptCount = threadNameRetryCountMap.get(Thread.currentThread().getName());
		if ( attemptCount == null ){
			threadNameRetryCountMap.put(Thread.currentThread().getName(), 1);
		}else{
			threadNameRetryCountMap.put(Thread.currentThread().getName(), attemptCount + 1);
		}
	}
}