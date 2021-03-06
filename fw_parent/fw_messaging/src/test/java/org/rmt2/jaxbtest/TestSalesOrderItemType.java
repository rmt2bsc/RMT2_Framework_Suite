//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.11 at 04:31:30 PM CST 
//


package org.rmt2.jaxbtest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.RMT2Base;


/**
 * The sales order item record.
 * 
 * <p>Java class for sales_order_item_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sales_order_item_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sales_order_item_id" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="sales_order" type="{}sales_order_type"/>
 *         &lt;element name="customer" type="{}customer_type"/>
 *         &lt;element name="item" type="{}item_master_type"/>
 *         &lt;element name="item_name_override" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="back_order_qty" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="markup" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="unit_cost" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="order_qty" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="tracking" type="{}record_tracking_type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sales_order_item_type", propOrder = {
    "salesOrderItemId",
    "salesOrder",
    "customer",
    "item",
    "itemNameOverride",
    "backOrderQty",
    "markup",
    "unitCost",
    "orderQty",
    "tracking"
})
public class TestSalesOrderItemType
    extends RMT2Base
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "sales_order_item_id", required = true, defaultValue = "0")
    protected BigInteger salesOrderItemId;
    @XmlElement(name = "sales_order", required = true)
    protected TestSalesOrderType salesOrder;
    @XmlElement(required = true)
    protected TestCustomerType customer;
    @XmlElement(required = true)
    protected TestItemMasterType item;
    @XmlElement(name = "item_name_override", required = true)
    protected String itemNameOverride;
    @XmlElement(name = "back_order_qty")
    protected BigDecimal backOrderQty;
    @XmlElement(required = true, defaultValue = "0")
    protected BigDecimal markup;
    @XmlElement(name = "unit_cost", required = true, defaultValue = "0")
    protected BigDecimal unitCost;
    @XmlElement(name = "order_qty", required = true, defaultValue = "0")
    protected BigInteger orderQty;
    protected TestRecordTrackingType tracking;

    /**
     * Gets the value of the salesOrderItemId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSalesOrderItemId() {
        return salesOrderItemId;
    }

    /**
     * Sets the value of the salesOrderItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSalesOrderItemId(BigInteger value) {
        this.salesOrderItemId = value;
    }

    /**
     * Gets the value of the salesOrder property.
     * 
     * @return
     *     possible object is
     *     {@link SalesOrderType }
     *     
     */
    public TestSalesOrderType getSalesOrder() {
        return salesOrder;
    }

    /**
     * Sets the value of the salesOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link SalesOrderType }
     *     
     */
    public void setSalesOrder(TestSalesOrderType value) {
        this.salesOrder = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerType }
     *     
     */
    public TestCustomerType getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerType }
     *     
     */
    public void setCustomer(TestCustomerType value) {
        this.customer = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link ItemMasterType }
     *     
     */
    public TestItemMasterType getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemMasterType }
     *     
     */
    public void setItem(TestItemMasterType value) {
        this.item = value;
    }

    /**
     * Gets the value of the itemNameOverride property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemNameOverride() {
        return itemNameOverride;
    }

    /**
     * Sets the value of the itemNameOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemNameOverride(String value) {
        this.itemNameOverride = value;
    }

    /**
     * Gets the value of the backOrderQty property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBackOrderQty() {
        return backOrderQty;
    }

    /**
     * Sets the value of the backOrderQty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBackOrderQty(BigDecimal value) {
        this.backOrderQty = value;
    }

    /**
     * Gets the value of the markup property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMarkup() {
        return markup;
    }

    /**
     * Sets the value of the markup property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMarkup(BigDecimal value) {
        this.markup = value;
    }

    /**
     * Gets the value of the unitCost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitCost() {
        return unitCost;
    }

    /**
     * Sets the value of the unitCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitCost(BigDecimal value) {
        this.unitCost = value;
    }

    /**
     * Gets the value of the orderQty property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrderQty() {
        return orderQty;
    }

    /**
     * Sets the value of the orderQty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrderQty(BigInteger value) {
        this.orderQty = value;
    }

    /**
     * Gets the value of the tracking property.
     * 
     * @return
     *     possible object is
     *     {@link RecordTrackingType }
     *     
     */
    public TestRecordTrackingType getTracking() {
        return tracking;
    }

    /**
     * Sets the value of the tracking property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordTrackingType }
     *     
     */
    public void setTracking(TestRecordTrackingType value) {
        this.tracking = value;
    }

}
