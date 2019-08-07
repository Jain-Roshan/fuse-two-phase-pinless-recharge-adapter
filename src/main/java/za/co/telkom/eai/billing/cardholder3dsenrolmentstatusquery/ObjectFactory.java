
package za.co.telkom.eai.billing.cardholder3dsenrolmentstatusquery;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the za.co.telkom.eai.billing.cardholder3dsenrolmentstatusquery package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: za.co.telkom.eai.billing.cardholder3dsenrolmentstatusquery
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestType }
     * 
     */
    public RequestType createRequestType() {
        return new RequestType();
    }

    /**
     * Create an instance of {@link Cardholder3DSEnrolmentStatusQuery }
     * 
     */
    public Cardholder3DSEnrolmentStatusQuery createCardholder3DSEnrolmentStatusQuery() {
        return new Cardholder3DSEnrolmentStatusQuery();
    }

    /**
     * Create an instance of {@link ResponseType }
     * 
     */
    public ResponseType createResponseType() {
        return new ResponseType();
    }

    /**
     * Create an instance of {@link PayloadType }
     * 
     */
    public PayloadType createPayloadType() {
        return new PayloadType();
    }

    /**
     * Create an instance of {@link RequestType.CardExpiry }
     * 
     */
    public RequestType.CardExpiry createRequestTypeCardExpiry() {
        return new RequestType.CardExpiry();
    }

}
