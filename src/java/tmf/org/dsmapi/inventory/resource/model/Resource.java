/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tmf.org.dsmapi.inventory.resource.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import tmf.org.dsmapi.common.model.Assoication;
import tmf.org.dsmapi.common.model.Href;
import tmf.org.dsmapi.common.model.ExplicitNameValuePair;

/**
 *
 * @author jmorey
 */
//@JsonTypeInfo(
//    use = JsonTypeInfo.Id.NAME,
//    include = JsonTypeInfo.As.PROPERTY,
//    property = "type")
//@JsonSubTypes({
//    @Type(value = TopologicalLink.class, name = "topologicalLink"),
//    @Type(value = Tpe.class, name = "tpe") })
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Entity
@Inheritance
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="RESOURCE_TYPE")
public class Resource implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    protected String type;
    private String name;
    private String description;
    private String lifeCycleState;
    private String version;
    private boolean isBundle;
    private ExplicitNameValuePair[] alias;
    private ExplicitNameValuePair[] extensionInfo;
    private ExplicitNameValuePair[] resourceCharacteristic;
    private Href[] resourceSpecification;
    private Assoication[] association;
    private Href[] bundle;
    private String self;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the lifeCycleState
     */
    public String getLifeCycleState() {
        return lifeCycleState;
    }

    /**
     * @param lifeCycleState the lifeCycleState to set
     */
    public void setLifeCycleState(String lifeCycleState) {
        this.lifeCycleState = lifeCycleState;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the isBundle
     */
    public boolean isIsBundle() {
        return isBundle;
    }

    /**
     * @param isBundle the isBundle to set
     */
    public void setIsBundle(boolean isBundle) {
        this.isBundle = isBundle;
    }

    /**
     * @return the aliasName
     */
    public ExplicitNameValuePair[] getAlias() {
        return alias;
    }

    /**
     * @param aliasName the aliasName to set
     */
    public void setAliasName(ExplicitNameValuePair[] alias) {
        this.alias = alias;
    }

    /**
     * @return the extensionInfo
     */
    public ExplicitNameValuePair[] getExtensionInfo() {
        return extensionInfo;
    }

    /**
     * @param extensionInfo the extensionInfo to set
     */
    public void setExtensionInfo(ExplicitNameValuePair[] extensionInfo) {
        this.extensionInfo = extensionInfo;
    }

    /**
     * @return the resourceCharacteristic
     */
    public ExplicitNameValuePair[] getResourceCharacteristic() {
        return resourceCharacteristic;
    }

    /**
     * @param resourceCharacteristic the resourceCharacteristic to set
     */
    public void setResourceCharacteristic(ExplicitNameValuePair[] resourceCharacteristic) {
        this.resourceCharacteristic = resourceCharacteristic;
    }

    /**
     * @return the resourceSpecification
     */
    public Href[] getResourceSpecification() {
        return resourceSpecification;
    }

    /**
     * @param resourceSpecification the resourceSpecification to set
     */
    public void setResourceSpecification(Href[] resourceSpecification) {
        this.resourceSpecification = resourceSpecification;
    }

    /**
     * @return the association
     */
    public Assoication[] getAssociation() {
        return association;
    }

    /**
     * @param association the association to set
     */
    public void setAssociation(Assoication[] association) {
        this.association = association;
    }

    /**
     * @return the bundle
     */
    public Href[] getBundle() {
        return bundle;
    }

    /**
     * @param bundle the bundle to set
     */
    public void setBundle(Href[] bundle) {
        this.bundle = bundle;
    }

    /**
     * @return the self
     */
    public String getSelf() {
        return self;
    }

    /**
     * @param self the self to set
     */
    public void setSelf(String self) {
        this.self = self;
    }

}
