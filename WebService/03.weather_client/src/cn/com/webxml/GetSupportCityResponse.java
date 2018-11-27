
package cn.com.webxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="getSupportCityResult" type="{http://WebXml.com.cn/}ArrayOfString" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getSupportCityResult"
})
@XmlRootElement(name = "getSupportCityResponse")
public class GetSupportCityResponse {

    protected ArrayOfString getSupportCityResult;

    /**
     * 获取getSupportCityResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getGetSupportCityResult() {
        return getSupportCityResult;
    }

    /**
     * 设置getSupportCityResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setGetSupportCityResult(ArrayOfString value) {
        this.getSupportCityResult = value;
    }

}
