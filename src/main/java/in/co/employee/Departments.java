//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.28 at 12:20:39 PM IST 
//


package in.co.employee;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Departments.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Departments">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IT"/>
 *     &lt;enumeration value="Development"/>
 *     &lt;enumeration value="Manager"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Departments")
@XmlEnum
public enum Departments {

    IT("IT"),
    @XmlEnumValue("Development")
    DEVELOPMENT("Development"),
    @XmlEnumValue("Manager")
    MANAGER("Manager");
    private final String value;

    Departments(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Departments fromValue(String v) {
        for (Departments c: Departments.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
