/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.common.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 *
 * @author jmorey
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Embeddable
public class Assoication implements Serializable {
    private String name;
    private String role;
    private String href;
    private String validFor;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /**
     * @param href the href to set
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * @return the validFor
     */
    public String getValidFor() {
        return validFor;
    }

    /**
     * @param validFor the validFor to set
     */
    public void setValidFor(String validFor) {
        this.validFor = validFor;
    }
}
