
package ch02.tc;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ch02.tc package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ch02.tc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link F2CResponse }
     * 
     */
    public F2CResponse createF2CResponse() {
        return new F2CResponse();
    }

    /**
     * Create an instance of {@link C2F }
     * 
     */
    public C2F createC2F() {
        return new C2F();
    }

    /**
     * Create an instance of {@link C2FResponse }
     * 
     */
    public C2FResponse createC2FResponse() {
        return new C2FResponse();
    }

    /**
     * Create an instance of {@link F2C }
     * 
     */
    public F2C createF2C() {
        return new F2C();
    }

}
