package com.koreait.meeting.model.service.payment;

import java.util.List;

import com.koreait.meeting.domain.Payment;

public interface PaymentService {
	public List selectAll();
	public List selectByProfile(int profile_id);
	public Payment select(int payment_id);
	public void insert(Payment payment);
	public void update(Payment payment);
	public void delete(int payment_id);
	
}
