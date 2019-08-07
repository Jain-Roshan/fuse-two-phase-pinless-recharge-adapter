package com.telkom.pinlessrechargeadapter.utility;

import java.io.StringReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.telkom.pinlessrechargeadapter.balancetopup.Amount;
import com.telkom.pinlessrechargeadapter.balancetopup.BalanceTopUp;
import com.telkom.pinlessrechargeadapter.balancetopup.BalanceTopUpResponse;
import com.telkom.pinlessrechargeadapter.balancetopup.Channel;
import com.telkom.pinlessrechargeadapter.balancetopup.Characteristic;
import com.telkom.pinlessrechargeadapter.balancetopup.Product;

import za.co.telkom.Recharge;
import za.co.telkom.RechargeResponse;
import za.co.telkom.eai.billing.topuprechargemanage.RequestType;
import za.co.telkom.eai.billing.topuprechargemanage.ResponseType;
import za.co.telkom.eai.billing.topuprechargemanage.TopUpRechargeManage;
import za.co.telkom.eai.billing_types.ResultType;
public class Mapper {

	
	static Logger logger = LoggerFactory.getLogger(Mapper.class);
	
	
	public static Recharge mapXmlValuesToPojo(String body) throws Exception {
		Recharge result = null;
		try {
			
			JAXBContext instance = JAXBContext.newInstance(Recharge.class);

			Unmarshaller unmarshaller = instance.createUnmarshaller();

			StringReader reader = new StringReader(body);
			logger.info("body==  " + body);
			logger.info("reader==  " + reader);

			result = (Recharge) unmarshaller.unmarshal(reader);

		} catch (Exception ex) {
			logger.error("Problem occured during marshalling in mapper : " + ex.getMessage());
			ex.printStackTrace();
		}
		return result;

	}
	
	
	public static BalanceTopUp mapFromRechargeToBalanceTopUp(Recharge recharge)
	{
		BalanceTopUp balanceTopUp = new BalanceTopUp();
		List<Characteristic> characteristicList = new ArrayList<>();
		Characteristic characteristic = new Characteristic();;
		Channel channel = new Channel();
		Product product = new Product();
		Amount amount = new Amount();
		
		if(null != recharge && null != recharge.getTopUpRechargeManage() && null != recharge.getTopUpRechargeManage().getRequest())
		{
			RequestType requestType = recharge.getTopUpRechargeManage().getRequest();
			if(null != requestType.getTransactionType())
			{
				characteristic = new Characteristic();
				characteristic.setName("TransactionType");
				characteristic.setValue(requestType.getTransactionType());
				characteristicList.add(characteristic);
			}
			
			balanceTopUp.setType(requestType.getProductId());
			
			if(null != requestType.getTopUpReferenceNumber())
			{
				characteristic = new Characteristic();
				characteristic.setName("RechargeReferenceNumber");
				characteristic.setValue(requestType.getTopUpReferenceNumber());
				characteristicList.add(characteristic);
			}
			
			if(null != requestType.getSessionID())
			{
				characteristic = new Characteristic();
				characteristic.setName("SessionID");
				characteristic.setValue(requestType.getSessionID());
				characteristicList.add(characteristic);
			}
	
			if(null != requestType.getServicePackCode())
			{
				characteristic = new Characteristic();
				characteristic.setName("ServicePackCode");
				characteristic.setValue(requestType.getServicePackCode());
				characteristicList.add(characteristic);
			}
			
			channel.setId(requestType.getMechantId());
			product.setId(requestType.getServiceId());
			if(null != requestType.getRechargeAmount())
				amount.setAmount(Integer.valueOf(requestType.getRechargeAmount().intValue()));
			if(null != requestType.getVoucherInfo())
				balanceTopUp.setVoucher(requestType.getVoucherInfo().getVoucherNumber());
		}
		
		balanceTopUp.setChannel(channel);
		balanceTopUp.setCharacteristic(characteristicList);
		balanceTopUp.setProduct(product);
		balanceTopUp.setAmount(amount);
		
		return balanceTopUp;
	}
	
	public static RechargeResponse mapFromBalanceTopUpResponseToRechargeResponse(BalanceTopUpResponse balanceTopUpResponse)
	{
		Recharge rechargeRequest = RechargeWrapper.RECHARGE;
		
		RechargeResponse rechargeResponse = new RechargeResponse();
		TopUpRechargeManage topUpRechargeManage = new TopUpRechargeManage();
		ResponseType responseType = new ResponseType();
		ResultType result = new ResultType();
		ResponseType.Payload payload = new ResponseType.Payload();
		if(balanceTopUpResponse.getCode().equalsIgnoreCase("201"))
		{
			logger.info("====inside mapFromBalanceTopUpResponseToRechargeResponse success response====");
			result.setResultCode(BigInteger.valueOf(0));	
			result.setResultMsg("Validation Success");
		
			if(null != rechargeRequest.getTopUpRechargeManage() && null != rechargeRequest.getTopUpRechargeManage().getRequest())
			{
				payload.setSessionID(rechargeRequest.getTopUpRechargeManage().getRequest().getSessionID());
				payload.setRechargeAmount(Long.toString(rechargeRequest.getTopUpRechargeManage().getRequest().getRechargeAmount()));
				payload.setCardNumber(rechargeRequest.getTopUpRechargeManage().getRequest().getProductId());
			}
				payload.setAccountStatus("NA");
				payload.setAccountBalance("0");
				responseType.setPayload(payload);
		}else
		{
			result.setResultCode(BigInteger.valueOf(1));
			result.setResultMsg("Invalid Merchant");
			result.setResultMsgCode("MPR-001");
		}
		
		
		responseType.setResult(result);
		topUpRechargeManage.setResponse(responseType);
		rechargeResponse.setTopUpRechargeManage(topUpRechargeManage);
		
		return rechargeResponse;
	}
	
	

}
