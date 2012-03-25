
package clienta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for time_stringResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="time_stringResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ts_out" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "time_stringResponse", propOrder = {
    "tsOut"
})
public class TimeStringResponse {

    @XmlElement(name = "ts_out")
    protected String tsOut;

    /**
     * Gets the value of the tsOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTsOut() {
        return tsOut;
    }

    /**
     * Sets the value of the tsOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTsOut(String value) {
        this.tsOut = value;
    }

}
