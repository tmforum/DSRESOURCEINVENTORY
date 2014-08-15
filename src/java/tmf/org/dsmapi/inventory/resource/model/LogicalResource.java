/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tmf.org.dsmapi.inventory.resource.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 *
 * @author jmorey
 */
@MappedSuperclass
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class LogicalResource extends Resource {
    
}
