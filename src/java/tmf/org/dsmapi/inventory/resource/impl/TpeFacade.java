/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tmf.org.dsmapi.inventory.resource.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tmf.org.dsmapi.common.impl.AbstractFacade;
import tmf.org.dsmapi.inventory.resource.model.Tpe;

/**
 *
 * @author pierregauthier
 */
@Stateless
public class TpeFacade extends AbstractFacade<Tpe> {
    @PersistenceContext(unitName = "DSResourceInventoryPU")
    private EntityManager em;

    public TpeFacade() {
        super(Tpe.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
