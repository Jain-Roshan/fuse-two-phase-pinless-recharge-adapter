package com.telkom.pinlessrechargeadapter.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telkom.pinlessrechargeadapter.balancetopup.BalanceTopUpResponse;
import com.telkom.pinlessrechargeadapter.utility.Mapper;

import za.co.telkom.RechargeResponse;

public class RechargeResponseProcessor implements Processor{

	Logger logger = LoggerFactory.getLogger(RechargeResponseProcessor.class);
	ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public void process(Exchange exchange) throws Exception {
		BalanceTopUpResponse balanceTopUpResponse =  objectMapper.readValue(exchange.getIn().getBody(String.class),BalanceTopUpResponse.class);
		logger.info("=====code is "+balanceTopUpResponse.getCode());
		
		RechargeResponse rechargeResponse = Mapper.mapFromBalanceTopUpResponseToRechargeResponse(balanceTopUpResponse);
		exchange.getIn().setBody(rechargeResponse);
	    
	}

	
}
