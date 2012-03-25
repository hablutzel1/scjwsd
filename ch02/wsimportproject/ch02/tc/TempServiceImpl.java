package ch02.tc;

import javax.jws.*;

/**
 * Creado por: jaime
 * 9/01/12
 */
@WebService(name = "TempService", targetNamespace = "http://tempConvertURI.org/")
public class TempServiceImpl implements TempService {
    public double c2F(@WebParam(name = "t", targetNamespace = "http://tempConvertURI.org/") double t) {
        return 32.0 + (t * 9.0 / 5.0);
    }

    public double f2C(@WebParam(name = "t", targetNamespace = "http://tempConvertURI.org/") double t) {
         return (5.0 / 9.0) * (t - 32.0);
    }
}
