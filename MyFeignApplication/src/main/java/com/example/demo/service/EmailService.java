package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.InvoiceRequest;
import com.example.demo.dto.MailRequest;
import com.example.demo.dto.ResetPasswordRequest;

@FeignClient(name="EmailMicroservice")
public interface EmailService {

	@PostMapping("/sendotp")
	public ResponseEntity<?> sendEmail(@RequestBody MailRequest request);
	
	
	@PostMapping("/otpverified")
	public List<String> resendotp(@RequestBody MailRequest request);
	
	@PostMapping("/resetpassword")
	public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request);
	
	@PostMapping("/sendinvoice")
	public ResponseEntity<?> sendInvoice(@RequestBody InvoiceRequest request);
}
