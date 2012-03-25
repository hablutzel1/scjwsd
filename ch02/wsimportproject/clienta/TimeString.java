
package clienta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for time_string complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="time_string">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="client_message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "time_string", propOrder = {
    "clientMessage"
})
public class TimeString {

    @XmlElement(name = "client_message")
    protected String clientMessage;

    /**
     * Gets the value of the clientMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientMessage() {
        return clientMessage;
    }

    /**
     * Sets the value of the clientMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientMessage(String value) {
        this.clientMessage = value;
    }

}
