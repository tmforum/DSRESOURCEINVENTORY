/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.common.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.tmf.dsmapi.common.impl.JsonError;
import org.tmf.dsmapi.common.exceptions.BadUsageException;

@Provider
public class BadUsageExceptionMapper implements ExceptionMapper<BadUsageException> {
    @Override
    public Response toResponse(BadUsageException ex) {
        JsonError error = new JsonError(ex.getType().getInfo(),ex.getMessage(), ex.getKeyValue());
        return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(error).build();
    }
}
