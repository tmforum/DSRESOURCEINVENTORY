/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.inventory.resource.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmorey
 */
@Entity
@DiscriminatorValue("equipment")
@XmlRootElement
public class Equipment extends PhysicalResource {
    private String protectionSchemeState;
    private String protectionRole;
    private Boolean isReportingAlarms;
    private String installedVersion;
    private String installedSerialNumber;
    private String installedPartNumber;
    private String installedEquipmentType;
    private String expectedEquipmentType;
    private String asap;

    /**
     * @return the protectionSchemeState
     */
    public String getProtectionSchemeState() {
        return protectionSchemeState;
    }

    /**
     * @param protectionSchemeState the protectionSchemeState to set
     */
    public void setProtectionSchemeState(String protectionSchemeState) {
        this.protectionSchemeState = protectionSchemeState;
    }

    /**
     * @return the protectionRole
     */
    public String getProtectionRole() {
        return protectionRole;
    }

    /**
     * @param protectionRole the protectionRole to set
     */
    public void setProtectionRole(String protectionRole) {
        this.protectionRole = protectionRole;
    }

    /**
     * @return the isReportingAlarms
     */
    public Boolean getIsReportingAlarms() {
        return isReportingAlarms;
    }

    /**
     * @param isReportingAlarms the isReportingAlarms to set
     */
    public void setIsReportingAlarms(Boolean isReportingAlarms) {
        this.isReportingAlarms = isReportingAlarms;
    }

    /**
     * @return the installedVersion
     */
    public String getInstalledVersion() {
        return installedVersion;
    }

    /**
     * @param installedVersion the installedVersion to set
     */
    public void setInstalledVersion(String installedVersion) {
        this.installedVersion = installedVersion;
    }

    /**
     * @return the installedSerialNumber
     */
    public String getInstalledSerialNumber() {
        return installedSerialNumber;
    }

    /**
     * @param installedSerialNumber the installedSerialNumber to set
     */
    public void setInstalledSerialNumber(String installedSerialNumber) {
        this.installedSerialNumber = installedSerialNumber;
    }

    /**
     * @return the installedPartNumber
     */
    public String getInstalledPartNumber() {
        return installedPartNumber;
    }

    /**
     * @param installedPartNumber the installedPartNumber to set
     */
    public void setInstalledPartNumber(String installedPartNumber) {
        this.installedPartNumber = installedPartNumber;
    }

    /**
     * @return the installedEquipmentType
     */
    public String getInstalledEquipmentType() {
        return installedEquipmentType;
    }

    /**
     * @param installedEquipmentType the installedEquipmentType to set
     */
    public void setInstalledEquipmentType(String installedEquipmentType) {
        this.installedEquipmentType = installedEquipmentType;
    }

    /**
     * @return the expectedEquipmentType
     */
    public String getExpectedEquipmentType() {
        return expectedEquipmentType;
    }

    /**
     * @param expectedEquipmentType the expectedEquipmentType to set
     */
    public void setExpectedEquipmentType(String expectedEquipmentType) {
        this.expectedEquipmentType = expectedEquipmentType;
    }
}
