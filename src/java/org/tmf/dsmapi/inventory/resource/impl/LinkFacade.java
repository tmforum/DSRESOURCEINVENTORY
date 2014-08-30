/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.inventory.resource.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.common.impl.AbstractFacade;
import org.tmf.dsmapi.inventory.resource.model.Link;

/**
 *
 * @author pierregauthier
 */
@Stateless
public class LinkFacade extends AbstractFacade<Link> {
    @PersistenceContext(unitName = "DSResourceInventoryPU")
    private EntityManager em;

    public LinkFacade() {
        super(Link.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
