
package ch02.tc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="f2cResult" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "f2CResult"
})
@XmlRootElement(name = "f2cResponse")
public class F2CResponse {

    @XmlElement(name = "f2cResult")
    protected double f2CResult;

    /**
     * Gets the value of the f2CResult property.
     * 
     */
    public double getF2CResult() {
        return f2CResult;
    }

    /**
     * Sets the value of the f2CResult property.
     * 
     */
    public void setF2CResult(double value) {
        this.f2CResult = value;
    }

}
