/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tmf.org.dsmapi.inventory.resource.model;

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

    private String tpeName;

    /**
     * @return the tpeName
     */
    public String getTpeName() {
        return tpeName;
    }

    /**
     * @param tpeName the tpeName to set
     */
    public void setTpeName(String tpeName) {
        this.tpeName = tpeName;
    }

}
