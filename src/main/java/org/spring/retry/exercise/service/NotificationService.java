package org.spring.retry.exercise.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	public void sendNotification(){
		throw new UnsupportedOperationException("send notification not supported");
	}
}
