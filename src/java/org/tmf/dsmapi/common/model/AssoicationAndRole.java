/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.common.model;

/**
 *
 * @author jmorey
 */
public class AssoicationAndRole {

    private String attribute;
    private String role[];

    /**
     * @return the attribute
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * @param attribute the attribute to set
     */
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    /**
     * @return the roles
     */
    public String[] getRole() {
        return role;
    }

    /**
     * @param roles the roles to set
     */
    public void setRole(String[] role) {
        this.role = role;
    }
}
