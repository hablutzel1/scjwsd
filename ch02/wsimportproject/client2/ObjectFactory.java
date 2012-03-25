
package client2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client2 package. 
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

    private final static QName _GetTimeAsStringResponse_QNAME = new QName("http://ts.ch02/", "getTimeAsStringResponse");
    private final static QName _GetTimeAsString_QNAME = new QName("http://ts.ch02/", "getTimeAsString");
    private final static QName _GetTimeAsElapsed_QNAME = new QName("http://ts.ch02/", "getTimeAsElapsed");
    private final static QName _GetTimeAsElapsedResponse_QNAME = new QName("http://ts.ch02/", "getTimeAsElapsedResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTimeAsString }
     * 
     */
    public GetTimeAsString createGetTimeAsString() {
        return new GetTimeAsString();
    }

    /**
     * Create an instance of {@link GetTimeAsStringResponse }
     * 
     */
    public GetTimeAsStringResponse createGetTimeAsStringResponse() {
        return new GetTimeAsStringResponse();
    }

    /**
     * Create an instance of {@link GetTimeAsElapsed }
     * 
     */
    public GetTimeAsElapsed createGetTimeAsElapsed() {
        return new GetTimeAsElapsed();
    }

    /**
     * Create an instance of {@link GetTimeAsElapsedResponse }
     * 
     */
    public GetTimeAsElapsedResponse createGetTimeAsElapsedResponse() {
        return new GetTimeAsElapsedResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTimeAsStringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ts.ch02/", name = "getTimeAsStringResponse")
    public JAXBElement<GetTimeAsStringResponse> createGetTimeAsStringResponse(GetTimeAsStringResponse value) {
        return new JAXBElement<GetTimeAsStringResponse>(_GetTimeAsStringResponse_QNAME, GetTimeAsStringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTimeAsString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ts.ch02/", name = "getTimeAsString")
    public JAXBElement<GetTimeAsString> createGetTimeAsString(GetTimeAsString value) {
        return new JAXBElement<GetTimeAsString>(_GetTimeAsString_QNAME, GetTimeAsString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTimeAsElapsed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ts.ch02/", name = "getTimeAsElapsed")
    public JAXBElement<GetTimeAsElapsed> createGetTimeAsElapsed(GetTimeAsElapsed value) {
        return new JAXBElement<GetTimeAsElapsed>(_GetTimeAsElapsed_QNAME, GetTimeAsElapsed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTimeAsElapsedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ts.ch02/", name = "getTimeAsElapsedResponse")
    public JAXBElement<GetTimeAsElapsedResponse> createGetTimeAsElapsedResponse(GetTimeAsElapsedResponse value) {
        return new JAXBElement<GetTimeAsElapsedResponse>(_GetTimeAsElapsedResponse_QNAME, GetTimeAsElapsedResponse.class, null, value);
    }

}
