package za.co.telkom;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2019-04-10T11:11:23.423+05:30
 * Generated source version: 3.0.4
 * 
 */
@WebService(targetNamespace = "http://www.telkom.co.za", name = "BillingSoap")
@XmlSeeAlso({za.co.telkom.eai.billing.topuprechargemanage.ObjectFactory.class, za.co.telkom.eai.billing.cardholder3dsauthenticationresultverify.ObjectFactory.class, za.co.telkom._2009._03.servicemetadata.ObjectFactory.class, za.co.telkom.eai.billing_types.ObjectFactory.class, ObjectFactory.class, org.w3._2006._02.addressing.wsdl.ObjectFactory.class, za.co.telkom.eai.billing.cardholder3dsenrolmentstatusquery.ObjectFactory.class, za.co.telkom.eai.billing.topupenquirymanage.ObjectFactory.class, za.co.telkom.eai.billing.topupendnotify.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface BillingSoap {

    @WebMethod(action = "http://www.telkom.co.za/rechargeCancel")
    @WebResult(name = "rechargeCancelResponse", targetNamespace = "http://www.telkom.co.za", partName = "parameters")
    public RechargeCancelResponse rechargeCancel(
        @WebParam(partName = "parameters", name = "rechargeCancel", targetNamespace = "http://www.telkom.co.za")
        RechargeCancel parameters
    ) throws RechargeCancelSoapOut;

    @WebMethod(action = "http://www.telkom.co.za/validateAccount")
    @WebResult(name = "validateAccountResponse", targetNamespace = "http://www.telkom.co.za", partName = "parameters")
    public ValidateAccountResponse validateAccount(
        @WebParam(partName = "parameters", name = "validateAccount", targetNamespace = "http://www.telkom.co.za")
        ValidateAccount parameters
    ) throws ValidateAccountSoapOut;

    @WebMethod(action = "http://www.telkom.co.za/rechargeCallback")
    @Oneway
    public void rechargeCallback(
        @WebParam(partName = "parameters", name = "rechargeCallback", targetNamespace = "http://www.telkom.co.za")
        RechargeCallback parameters
    );

    @WebMethod(action = "http://www.telkom.co.za/check3DSEnrolment")
    @WebResult(name = "check3DSEnrolmentResponse", targetNamespace = "http://www.telkom.co.za", partName = "parameters")
    public Check3DSEnrolmentResponse check3DSEnrolment(
        @WebParam(partName = "parameters", name = "check3DSEnrolment", targetNamespace = "http://www.telkom.co.za")
        Check3DSEnrolment parameters
    ) throws Check3DSEnrolmentSoapOut;

    @WebMethod(action = "http://www.telkom.co.za/rechargeCancelFaultCallback")
    @Oneway
    public void rechargeCancelFaultCallback(
        @WebParam(partName = "parameters", name = "rechargeCancelFaultCallback", targetNamespace = "http://www.telkom.co.za")
        RechargeCancelFaultCallback parameters
    );

    @WebMethod(action = "http://www.telkom.co.za/rechargeCancelCallback")
    @Oneway
    public void rechargeCancelCallback(
        @WebParam(partName = "parameters", name = "rechargeCancelCallback", targetNamespace = "http://www.telkom.co.za")
        RechargeCancelCallback parameters
    );

    @WebMethod(action = "http://www.telkom.co.za/authenticate3DSResultFaultCallback")
    @Oneway
    public void authenticate3DSResultFaultCallback(
        @WebParam(partName = "parameters", name = "authenticate3DSResultFaultCallback", targetNamespace = "http://www.telkom.co.za")
        Authenticate3DSResultFaultCallback parameters
    );

    @WebMethod(action = "http://www.telkom.co.za/check3DSEnrolmentCallback")
    @Oneway
    public void check3DSEnrolmentCallback(
        @WebParam(partName = "parameters", name = "check3DSEnrolmentCallback", targetNamespace = "http://www.telkom.co.za")
        Check3DSEnrolmentCallback parameters
    );

    @WebMethod(action = "http://www.telkom.co.za/check3DSEnrolmentFaultCallback")
    @Oneway
    public void check3DSEnrolmentFaultCallback(
        @WebParam(partName = "parameters", name = "check3DSEnrolmentFaultCallback", targetNamespace = "http://www.telkom.co.za")
        Check3DSEnrolmentFaultCallback parameters
    );

    @WebMethod(action = "http://www.telkom.co.za/validateAccountCallback")
    @Oneway
    public void validateAccountCallback(
        @WebParam(partName = "parameters", name = "validateAccountCallback", targetNamespace = "http://www.telkom.co.za")
        ValidateAccountCallback parameters
    );

    @WebMethod(action = "http://www.telkom.co.za/rechargeFaultCallback")
    @Oneway
    public void rechargeFaultCallback(
        @WebParam(partName = "parameters", name = "rechargeFaultCallback", targetNamespace = "http://www.telkom.co.za")
        RechargeFaultCallback parameters
    );

    @WebMethod(action = "http://www.telkom.co.za/authenticate3DSResultCallback")
    @Oneway
    public void authenticate3DSResultCallback(
        @WebParam(partName = "parameters", name = "authenticate3DSResultCallback", targetNamespace = "http://www.telkom.co.za")
        Authenticate3DSResultCallback parameters
    );

    @WebMethod(action = "http://www.telkom.co.za/recharge")
    @WebResult(name = "rechargeResponse", targetNamespace = "http://www.telkom.co.za", partName = "parameters")
    public RechargeResponse recharge(
        @WebParam(partName = "parameters", name = "recharge", targetNamespace = "http://www.telkom.co.za")
        Recharge parameters
    ) throws RechargeSoapOut;

    @WebMethod(action = "http://www.telkom.co.za/validateAccountFaultCallback")
    @Oneway
    public void validateAccountFaultCallback(
        @WebParam(partName = "parameters", name = "validateAccountFaultCallback", targetNamespace = "http://www.telkom.co.za")
        ValidateAccountFaultCallback parameters
    );

    @WebMethod(action = "http://www.telkom.co.za/authenticate3DSResult")
    @WebResult(name = "authenticate3DSResultResponse", targetNamespace = "http://www.telkom.co.za", partName = "parameters")
    public Authenticate3DSResultResponse authenticate3DSResult(
        @WebParam(partName = "parameters", name = "authenticate3DSResult", targetNamespace = "http://www.telkom.co.za")
        Authenticate3DSResult parameters
    ) throws Authenticate3DSResultSoapOut;
}
