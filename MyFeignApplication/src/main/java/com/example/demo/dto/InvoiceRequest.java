package com.example.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class InvoiceRequest {

	private String name;
	private String to;
	private String subject;
	private String body;
}
