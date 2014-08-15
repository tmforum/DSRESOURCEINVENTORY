/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tmf.org.dsmapi.inventory.resource.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import tmf.org.dsmapi.common.model.Href;

/**
 *
 * @author jmorey
 */
@Entity
@DiscriminatorValue("topologicalLink")
@XmlRootElement
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonTypeName("topologicalLink")
// @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class TopologicalLink extends Resource {

    private Href[] tp;
    
    private String[] layerProtocalName;
    //private Direction direction;

    /**
     * @return the tp
     */
    public Href[] getTp() {
        return tp;
    }

    /**
     * @param tp the tp to set
     */
    public void setTp(Href[] tp) {
        this.setTp(tp);
    }

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

}
