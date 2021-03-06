//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.11 at 04:31:30 PM CST 
//


package org.rmt2.jaxbtest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.RMT2Base;

 
/**
 * <p>Java class for auth_criteria_group complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="auth_criteria_group">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user_profile_criteria" type="{}user_profile_criteria_type"/>
 *         &lt;element name="user_app_roles_criteria" type="{}user_app_roles_criteria_type"/>
 *         &lt;element name="resource_criteria" type="{}resource_criteria_type"/>
 *         &lt;element name="resource_subtype_criteria" type="{}resource_subtype_criteria_type"/>
 *         &lt;element name="user_resource_access_criteria" type="{}user_resource_access_criteria_type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "auth_criteria_group", propOrder = {
    "userProfileCriteria",
    "userAppRolesCriteria",
    "resourceCriteria",
    "resourceSubtypeCriteria",
    "userResourceAccessCriteria"
})
public class TestAuthCriteriaGroup
    extends RMT2Base
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "user_profile_criteria", required = true)
    protected TestUserProfileCriteriaType userProfileCriteria;
    @XmlElement(name = "user_app_roles_criteria", required = true)
    protected TestUserAppRolesCriteriaType userAppRolesCriteria;
    @XmlElement(name = "resource_criteria", required = true)
    protected TestResourceCriteriaType resourceCriteria;
    @XmlElement(name = "resource_subtype_criteria", required = true)
    protected TestResourceSubtypeCriteriaType resourceSubtypeCriteria;
    @XmlElement(name = "user_resource_access_criteria", required = true)
    protected TestUserResourceAccessCriteriaType userResourceAccessCriteria;

    /**
     * Gets the value of the userProfileCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link UserProfileCriteriaType }
     *     
     */
    public TestUserProfileCriteriaType getUserProfileCriteria() {
        return userProfileCriteria;
    }

    /**
     * Sets the value of the userProfileCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserProfileCriteriaType }
     *     
     */
    public void setUserProfileCriteria(TestUserProfileCriteriaType value) {
        this.userProfileCriteria = value;
    }

    /**
     * Gets the value of the userAppRolesCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link UserAppRolesCriteriaType }
     *     
     */
    public TestUserAppRolesCriteriaType getUserAppRolesCriteria() {
        return userAppRolesCriteria;
    }

    /**
     * Sets the value of the userAppRolesCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserAppRolesCriteriaType }
     *     
     */
    public void setUserAppRolesCriteria(TestUserAppRolesCriteriaType value) {
        this.userAppRolesCriteria = value;
    }

    /**
     * Gets the value of the resourceCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceCriteriaType }
     *     
     */
    public TestResourceCriteriaType getResourceCriteria() {
        return resourceCriteria;
    }

    /**
     * Sets the value of the resourceCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceCriteriaType }
     *     
     */
    public void setResourceCriteria(TestResourceCriteriaType value) {
        this.resourceCriteria = value;
    }

    /**
     * Gets the value of the resourceSubtypeCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceSubtypeCriteriaType }
     *     
     */
    public TestResourceSubtypeCriteriaType getResourceSubtypeCriteria() {
        return resourceSubtypeCriteria;
    }

    /**
     * Sets the value of the resourceSubtypeCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceSubtypeCriteriaType }
     *     
     */
    public void setResourceSubtypeCriteria(TestResourceSubtypeCriteriaType value) {
        this.resourceSubtypeCriteria = value;
    }

    /**
     * Gets the value of the userResourceAccessCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link UserResourceAccessCriteriaType }
     *     
     */
    public TestUserResourceAccessCriteriaType getUserResourceAccessCriteria() {
        return userResourceAccessCriteria;
    }

    /**
     * Sets the value of the userResourceAccessCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserResourceAccessCriteriaType }
     *     
     */
    public void setUserResourceAccessCriteria(TestUserResourceAccessCriteriaType value) {
        this.userResourceAccessCriteria = value;
    }

}
