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
    private String associationName;
    private String[] field;
    private String zendhref;
    private int depth;

    /**
     * @return the associationName
     */
    public String getAssociationName() {
        return associationName;
    }

    /**
     * @param associationName the associationName to set
     */
    public void setAssociationName(String associationName) {
        this.associationName = associationName;
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
    
}
