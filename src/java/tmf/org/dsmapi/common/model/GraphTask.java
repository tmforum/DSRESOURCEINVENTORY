/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tmf.org.dsmapi.common.model;

/**
 *
 * @author jmorey
 */
public class GraphTask {
    private AssoicationAndRole[] associationAndRole;
    private String[] field;
    private String zendhref;
    private int depth;

    /**
     * @return the associationName
     */
    public AssoicationAndRole[] getAssociationAndRole() {
        return associationAndRole;
    }

    /**
     * @param associationName the associationName to set
     */
    public void setAssociationAndRole(AssoicationAndRole[] associationAndRole) {
        this.associationAndRole = associationAndRole;
    }

    /**
     * @return the field
     */
    public String[] getField() {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField(String[] field) {
        this.field = field;
    }

    /**
     * @return the zendhref
     */
    public String getZendhref() {
        return zendhref;
    }

    /**
     * @param zendhref the zendhref to set
     */
    public void setZendhref(String zendhref) {
        this.zendhref = zendhref;
    }

    /**
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * @param depth the depth to set
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }
    
    public class AssoicationAndRole {
        public String attribute;
        public String roles[];
    }
}
