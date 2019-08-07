package com.telkom.pinlessrechargeadapter.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telkom.pinlessrechargeadapter.utility.HeadersWrapper;
import com.telkom.pinlessrechargeadapter.utility.RechargeWrapper;

import za.co.telkom.Recharge;

public class PinlessRechargeAdapterProcessor implements Processor {

	Logger logger = LoggerFactory.getLogger(PinlessRechargeAdapterProcessor.class);
	ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info("======inside PinlessRechargeAdapterProcessor ===");
		HeadersWrapper.HEADERS = exchange.getIn().getHeaders();
		
		MessageContentsList result = (MessageContentsList)exchange.getIn().getBody();
		Recharge recharge = (Recharge)result.get(0);
		RechargeWrapper.RECHARGE = recharge;
		String sessionID = recharge.getTopUpRechargeManage().getRequest().getSessionID();
		logger.info("recharge sessionID ===="+ sessionID);
		exchange.getIn().setBody(sessionID);
		
	}

}
