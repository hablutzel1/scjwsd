
package clienta;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clienta package. 
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

    private final static QName _AcceptInput_QNAME = new QName("http://ch02.tsa", "acceptInput");
    private final static QName _TimeElapsed_QNAME = new QName("http://ch02.tsa", "time_elapsed");
    private final static QName _TimeElapsedResponse_QNAME = new QName("http://ch02.tsa", "time_elapsedResponse");
    private final static QName _TimeStringResponse_QNAME = new QName("http://ch02.tsa", "time_stringResponse");
    private final static QName _TimeString_QNAME = new QName("http://ch02.tsa", "time_string");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clienta
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AcceptInput }
     * 
     */
    public AcceptInput createAcceptInput() {
        return new AcceptInput();
    }

    /**
     * Create an instance of {@link TimeElapsed }
     * 
     */
    public TimeElapsed createTimeElapsed() {
        return new TimeElapsed();
    }

    /**
     * Create an instance of {@link TimeStringResponse }
     * 
     */
    public TimeStringResponse createTimeStringResponse() {
        return new TimeStringResponse();
    }

    /**
     * Create an instance of {@link TimeElapsedResponse }
     * 
     */
    public TimeElapsedResponse createTimeElapsedResponse() {
        return new TimeElapsedResponse();
    }

    /**
     * Create an instance of {@link TimeString }
     * 
     */
    public TimeString createTimeString() {
        return new TimeString();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcceptInput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch02.tsa", name = "acceptInput")
    public JAXBElement<AcceptInput> createAcceptInput(AcceptInput value) {
        return new JAXBElement<AcceptInput>(_AcceptInput_QNAME, AcceptInput.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeElapsed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch02.tsa", name = "time_elapsed")
    public JAXBElement<TimeElapsed> createTimeElapsed(TimeElapsed value) {
        return new JAXBElement<TimeElapsed>(_TimeElapsed_QNAME, TimeElapsed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeElapsedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch02.tsa", name = "time_elapsedResponse")
    public JAXBElement<TimeElapsedResponse> createTimeElapsedResponse(TimeElapsedResponse value) {
        return new JAXBElement<TimeElapsedResponse>(_TimeElapsedResponse_QNAME, TimeElapsedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeStringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch02.tsa", name = "time_stringResponse")
    public JAXBElement<TimeStringResponse> createTimeStringResponse(TimeStringResponse value) {
        return new JAXBElement<TimeStringResponse>(_TimeStringResponse_QNAME, TimeStringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch02.tsa", name = "time_string")
    public JAXBElement<TimeString> createTimeString(TimeString value) {
        return new JAXBElement<TimeString>(_TimeString_QNAME, TimeString.class, null, value);
    }

}
