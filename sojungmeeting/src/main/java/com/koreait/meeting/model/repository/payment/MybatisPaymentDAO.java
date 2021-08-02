package com.koreait.meeting.model.repository.payment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.meeting.domain.Payment;
import com.koreait.meeting.exception.DMLException;

@Repository
public class MybatisPaymentDAO implements PaymentDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List selectAll() {
		return sqlSessionTemplate.selectList("Payment.selectAll");
	}

	@Override
	public List selectByProfile(int profile_id) {
		return sqlSessionTemplate.selectList("Payment.selectByProfile", profile_id);
	}

	@Override
	public Payment select(int payment_id) {

		return null;
	}

	@Override
	public void insert(Payment payment) throws DMLException{
		int result=sqlSessionTemplate.insert("Payment.insert", payment);
		if(result==0) {
			throw new DMLException("결제에 실패 하였습니다");
		}
		
	}

	@Override
	public void update(Payment payment) {

		
	}

	@Override
	public void delete(int payment_id) {

		
	}

}
