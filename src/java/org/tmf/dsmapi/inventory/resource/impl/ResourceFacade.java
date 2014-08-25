/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.inventory.resource.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.common.impl.AbstractFacade;
import org.tmf.dsmapi.inventory.resource.model.Resource;

/**
 *
 * @author pierregauthier
 */
@Stateless
public class ResourceFacade extends AbstractFacade<Resource> {
    @PersistenceContext(unitName = "DSResourceInventoryPU")
    private EntityManager em;

    public ResourceFacade() {
        super(Resource.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
