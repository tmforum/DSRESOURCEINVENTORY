/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.inventory.resource.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.common.impl.AbstractFacade;
import org.tmf.dsmapi.inventory.resource.model.TopologicalLink;

/**
 *
 * @author pierregauthier
 */
@Stateless
public class TopologicalLinkFacade extends AbstractFacade<TopologicalLink> {
    @PersistenceContext(unitName = "DSResourceInventoryPU")
    private EntityManager em;

    public TopologicalLinkFacade() {
        super(TopologicalLink.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
