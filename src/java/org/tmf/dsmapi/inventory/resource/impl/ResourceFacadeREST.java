/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.inventory.resource.impl;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.codehaus.jackson.node.ObjectNode;
import org.tmf.dsmapi.inventory.resource.model.Resource;
import org.tmf.dsmapi.common.exceptions.BadUsageException;
import org.tmf.dsmapi.common.impl.FacadeRestUtil;
import org.tmf.dsmapi.inventory.resource.model.Link;

/**
 *
 * @author pierregauthier
 */
@Stateless
@Api(value = "/inventory/resource", description = "Used to query resource inventory.  This method is polymorphic all will return resources of all types.")
@Path("/inventory/resource")
public class ResourceFacadeREST {

    @EJB
    private ResourceFacade manager;

    public ResourceFacadeREST() {
    }

    @GET
    @ApiOperation(value = "Retrieve Resources", notes = "Retrieve resources using option filter.", response = Resource.class)
    @ApiResponses(value = {
    @ApiResponse(code = 400, message = "Invalid Filter") 
    })
    @Produces({"application/json"})
    public Response findByCriteriaWithFields(
            @ApiParam(value = "Query Specification", required = false) @QueryParam("_s") String _s,
            @ApiParam(value = "Field Specification", required = false) @QueryParam("fields") String fields,
            @Context UriInfo info) throws BadUsageException {

        // search criteria
        MultivaluedMap<String, String> criteria = info.getQueryParameters();
        // fields to filter view
        Set<String> fieldSet = FacadeRestUtil.getFieldSet(criteria);
        if (criteria.containsKey("_s"))
        {
            String[] stuff = criteria.getFirst("_s").split("=");
            String query = new String("");
            for (int count = 1;count<stuff.length;count++)
            {
                query += "=";
                query += stuff[count];
            }
            criteria.clear();
            criteria.add(stuff[0],query);
        }
        List<Resource> resultList = findByCriteria(criteria);

        Response response;
        if (fieldSet.isEmpty() || fieldSet.contains(FacadeRestUtil.ALL_FIELDS)) {
            response = Response.ok(resultList).build();
        } else {
            fieldSet.add(FacadeRestUtil.ID_FIELD);
            List<ObjectNode> nodeList = new ArrayList<ObjectNode>();
            for (Resource productOffering : resultList) {
                ObjectNode node = FacadeRestUtil.createNodeViewWithFields(productOffering, fieldSet);
                nodeList.add(node);
            }
            response = Response.ok(nodeList).build();
        }
        return response;
    }

    @HEAD
    @ApiOperation(value = "Retrieve the HTTP Header", notes = "Retrieve the HTTP header that would have been returned by the coresponding GET.")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "No Data"),
        @ApiResponse(code = 400, message = "Invalid Filter"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Produces({"application/json"})
    public Response getHTTPHeaders(
            @ApiParam(value = "Query Specification", required = false) @QueryParam("_s") String _s,
            @ApiParam(value = "Field Specification", required = false) @QueryParam("fields") String fields,
            @Context UriInfo info) throws BadUsageException {
        // search criteria
        MultivaluedMap<String, String> criteria = info.getQueryParameters();

        List<Resource> resultList = findByCriteria(criteria);

        Response response;
        Response.ResponseBuilder responseBuilder = Response.noContent();
        String start = new String();
        if (resultList.size() == 0) {
            start = "0";
        } else {
            start = "1";
        }
        responseBuilder.header("Content-Range", "items" + start + "-" + resultList.size() + "/" + manager.count());
        response = responseBuilder.build();
        return response;
    }
    
    private List<Resource> findByCriteria(MultivaluedMap<String, String> criteria) throws BadUsageException {
        List<Resource> resultList = null;
        if (criteria != null && !criteria.isEmpty()) {
            resultList = manager.findByCriteria(criteria, Resource.class);
        } else {
            resultList = manager.findAll();
        }
        return resultList;
    }
}
