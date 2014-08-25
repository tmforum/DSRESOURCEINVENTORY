/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.common.model;

import org.tmf.dsmapi.inventory.resource.model.Resource;

/**
 *
 * @author jmorey
 */
public class Graph {
    public Graph.Assoication[] assoication;
    public Object[] data;
    public class Assoication {
        public String name;
        public String role;
        public String aEnd;
        public String zEnd;
    }
}
