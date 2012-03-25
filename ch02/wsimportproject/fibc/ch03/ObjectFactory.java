
package fibc.ch03;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fibc.ch03 package.
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

    private final static QName _FibException_QNAME = new QName("http://ch03.fib", "FibException");
    private final static QName _CountRabbits_QNAME = new QName("http://ch03.fib", "countRabbits");
    private final static QName _CountRabbitsResponse_QNAME = new QName("http://ch03.fib", "countRabbitsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fibc.ch03
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CountRabbits }
     * 
     */
    public CountRabbits createCountRabbits() {
        return new CountRabbits();
    }

    /**
     * Create an instance of {@link FibException }
     * 
     */
    public FibException createFibException() {
        return new FibException();
    }

    /**
     * Create an instance of {@link CountRabbitsResponse }
     * 
     */
    public CountRabbitsResponse createCountRabbitsResponse() {
        return new CountRabbitsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FibException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch03.fib", name = "FibException")
    public JAXBElement<FibException> createFibException(FibException value) {
        return new JAXBElement<FibException>(_FibException_QNAME, FibException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountRabbits }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch03.fib", name = "countRabbits")
    public JAXBElement<CountRabbits> createCountRabbits(CountRabbits value) {
        return new JAXBElement<CountRabbits>(_CountRabbits_QNAME, CountRabbits.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountRabbitsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch03.fib", name = "countRabbitsResponse")
    public JAXBElement<CountRabbitsResponse> createCountRabbitsResponse(CountRabbitsResponse value) {
        return new JAXBElement<CountRabbitsResponse>(_CountRabbitsResponse_QNAME, CountRabbitsResponse.class, null, value);
    }

}
