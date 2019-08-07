package com.telkom.pinlessrechargeadapter.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.telkom.pinlessrechargeadapter.processor.BalanceTopUpProcessor;
import com.telkom.pinlessrechargeadapter.processor.PinlessRechargeAdapterProcessor;
import com.telkom.pinlessrechargeadapter.processor.RechargeResponseProcessor;
import com.telkom.pinlessrechargeadapter.utility.HeadersWrapper;

import za.co.telkom.RechargeResponse;

public class Route extends RouteBuilder{

	Logger logger = LoggerFactory.getLogger(Route.class);
	@Override
	public void configure() throws Exception {
		
		from("cxf:bean:cxfSoapServiceEndpoint")
		.log(" ==== In Two Phase Request ==== ")
		.process(new PinlessRechargeAdapterProcessor())
		.log(" ==== Sending Get Call to CRM ==== ")
		/*.removeHeaders("*").removeProperties("*")
		.setHeader(Exchange.HTTP_METHOD, constant("GET"))
		.recipientList(simple(""
				+ "${body}?throwExceptionOnFailure=false"));*/
		.process(new BalanceTopUpProcessor())
		.setHeader(Exchange.HTTP_METHOD, constant("POST"))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.to("{{twophaseprocessbalancetopup}}")
		.process(new RechargeResponseProcessor())
		
		.end();
	}

	
}
