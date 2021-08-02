package com.koreait.meeting.model.service.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.meeting.domain.Payment;
import com.koreait.meeting.model.repository.payment.PaymentDAO;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentDAO paymentDAO;

	public List selectAll() {
		return paymentDAO.selectAll();
	}

	@Override
	public List selectByProfile(int profile_id) {
		return paymentDAO.selectByProfile(profile_id);
	}

	@Override
	public Payment select(int payment_id) {
		return null;//paymentDAO.select(payment_id);
	}

	@Override
	public void insert(Payment payment) {
		paymentDAO.insert(payment);
		
	}

	@Override
	public void update(Payment payment) {

		
	}

	@Override
	public void delete(int payment_id) {

		
	}

}
