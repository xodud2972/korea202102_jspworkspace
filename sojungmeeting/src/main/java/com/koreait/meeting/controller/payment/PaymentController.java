package com.koreait.meeting.controller.payment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.meeting.domain.Payment;
import com.koreait.meeting.model.service.payment.PaymentService;
import com.koreait.meeting.model.service.profile.ProFileService;

@Controller
public class PaymentController {
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private ProFileService proFileService;
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value="/profile/payment", method=RequestMethod.GET)
	public String registform(Model model, HttpServletRequest request) {
		
		List paymentList = paymentService.selectAll();
		
		model.addAttribute("paymentList", paymentList);
		
		return "admin/inc/success";
	}
	
	@PostMapping("/inc/success")
	public String regist(Payment payment, HttpServletRequest request) {
		
		paymentService.insert(payment);
		
		return "redirect:/inc/success";
	}
}
