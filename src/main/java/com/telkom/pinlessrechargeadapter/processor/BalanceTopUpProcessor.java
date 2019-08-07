package com.telkom.pinlessrechargeadapter.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telkom.pinlessrechargeadapter.balancetopup.BalanceTopUp;
import com.telkom.pinlessrechargeadapter.utility.Mapper;
import com.telkom.pinlessrechargeadapter.utility.RechargeWrapper;

import za.co.telkom.Recharge;

public class BalanceTopUpProcessor implements Processor {

	Logger logger = LoggerFactory.getLogger(BalanceTopUpProcessor.class);
	ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info("===inside BalanceTopUpProcessor======");
		
		Recharge recharge = RechargeWrapper.RECHARGE;
		BalanceTopUp balanceTopUp = Mapper.mapFromRechargeToBalanceTopUp(recharge);
		logger.info("BalanceTopUp :"+ objectMapper.writeValueAsString(balanceTopUp));
		exchange.getIn().setBody(objectMapper.writeValueAsString(balanceTopUp));
		
	}

}
