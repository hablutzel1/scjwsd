package ch02.ts;

import javax.jws.*;
import javax.jws.soap.*;
import javax.jws.soap.SOAPBinding.*;

/**
 * The annotation @WebService signals that this is the
 * SEI (Service Endpoint Interface). @WebMethod signals
 * that each method is a service operation.
 * <p/>
 * The @SOAPBinding annotation impacts the under-the-hood
 * construction of the service contract, the WSDL
 * (Web Services Definition Language) document. Style.RPC
 * simplifies the contract and makes deployment easier.
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT) // more on this later
public interface TimeServer {

    @WebResult(partName = "time_response")
    @WebMethod
    String getTimeAsString();

    @WebResult(partName = "time_response")
    @WebMethod
    long getTimeAsElapsed();
}