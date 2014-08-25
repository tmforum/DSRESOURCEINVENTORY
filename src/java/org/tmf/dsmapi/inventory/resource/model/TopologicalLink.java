/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.inventory.resource.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.tmf.dsmapi.common.model.Href;

/**
 *
 * @author jmorey
 */
@Entity
@DiscriminatorValue("topologicalLink")
@XmlRootElement
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonTypeName("topologicalLink")
// @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class TopologicalLink extends LogicalResource {

    private String[] layerProtocalName;
    private String direction;
    private String isAlarmReporting;
    private Href[] tp;
    private String asap;

    //private Direction direction;

    /**
     * @return the layerProtocalName
     */
    public String[] getLayerProtocalName() {
        return layerProtocalName;
    }

    /**
     * @param layerProtocalName the layerProtocalName to set
     */
    public void setLayerProtocalName(String[] layerProtocalName) {
        this.setLayerProtocalName(layerProtocalName);
    }

    /**
     * @return the tpe
     */
    public Href[] getTp() {
        return tp;
    }


    /**
     * @return the direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * @return the isAlarmReporting
     */
    public String getIsAlarmReporting() {
        return isAlarmReporting;
    }

    /**
     * @param isAlarmReporting the isAlarmReporting to set
     */
    public void setIsAlarmReporting(String isAlarmReporting) {
        this.isAlarmReporting = isAlarmReporting;
    }

    /**
     * @return the asap
     */
    public String getAsap() {
        return asap;
    }

    /**
     * @param asap the asap to set
     */
    public void setAsap(String asap) {
        this.asap = asap;
    }

    /**
     * @param tp the tp to set
     */
    public void setTp(Href[] tp) {
        this.tp = tp;
    }
}
