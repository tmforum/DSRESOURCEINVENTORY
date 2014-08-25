/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.inventory.resource.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.tmf.dsmapi.common.model.Href;

/**
 *
 * @author jmorey
 */
@Entity
@DiscriminatorValue("tpe")
@XmlRootElement
//@JsonIgnoreProperties(ignoreUnknown=true)
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonTypeName("tpe")
//@JsonDeserialize(as=Tpe.class)
 //@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class Tpe extends LogicalResource {

    private String tpeType;
    private Boolean isEquipmentProtected;
    private String egressTmdState;
    private String ingressTmdState;
    private Href[] supportingEquipment;


    /**
     * @return the tpeType
     */
    public String getTpeType() {
        return tpeType;
    }

    /**
     * @param tpeType the tpeType to set
     */
    public void setTpeType(String tpeType) {
        this.tpeType = tpeType;
    }

    /**
     * @return the isEquipmentProtected
     */
    public Boolean getIsEquipmentProtected() {
        return isEquipmentProtected;
    }

    /**
     * @param isEquipmentProtected the isEquipmentProtected to set
     */
    public void setIsEquipmentProtected(Boolean isEquipmentProtected) {
        this.isEquipmentProtected = isEquipmentProtected;
    }

    /**
     * @return the egressTmdState
     */
    public String getEgressTmdState() {
        return egressTmdState;
    }

    /**
     * @param egressTmdState the egressTmdState to set
     */
    public void setEgressTmdState(String egressTmdState) {
        this.egressTmdState = egressTmdState;
    }

    /**
     * @return the ingressTmdState
     */
    public String getIngressTmdState() {
        return ingressTmdState;
    }

    /**
     * @param ingressTmdState the ingressTmdState to set
     */
    public void setIngressTmdState(String ingressTmdState) {
        this.ingressTmdState = ingressTmdState;
    }

    /**
     * @return the supportingEquipment
     */
    public Href[] getSupportingEquipment() {
        return supportingEquipment;
    }

    /**
     * @param supportingEquipment the supportingEquipment to set
     */
    public void setSupportingEquipment(Href[] supportingEquipment) {
        this.supportingEquipment = supportingEquipment;
    }

}
