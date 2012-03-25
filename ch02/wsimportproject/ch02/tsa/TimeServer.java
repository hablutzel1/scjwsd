package ch02.tsa;  // 'a' for 'annotation'

import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.Oneway;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService(name            = "AnnotatedTimeServer",
            serviceName     = "RevisedTimeServer",
            targetNamespace = "http://ch02.tsa")
@SOAPBinding(style          = SOAPBinding.Style.DOCUMENT,
             use            = SOAPBinding.Use.LITERAL,
             parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class TimeServer {
    @WebMethod(operationName   = "time_string")
    @WebResult(name            = "ts_out",
               targetNamespace = "http://ch02.tsa")
    public String getTimeAsString(
       @WebParam(name            = "client_message",
                 targetNamespace = "http://ch02.tsa",
                 mode            = WebParam.Mode.IN)
       String msg) {
          return msg + " at " + new Date().toString();
    }

    @WebMethod (operationName = "time_elapsed")
    public long getTimeAsElapsed() { return new Date().getTime(); }

    @WebMethod
    @Oneway
    public void acceptInput(String msg) { System.out.println(msg); }
}     

		