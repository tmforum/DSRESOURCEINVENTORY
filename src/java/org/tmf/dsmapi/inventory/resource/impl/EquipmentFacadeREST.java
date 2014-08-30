/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.inventory.resource.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.codehaus.jackson.node.ObjectNode;
import org.tmf.dsmapi.inventory.resource.model.Equipment;
import org.tmf.dsmapi.common.exceptions.BadUsageException;
import org.tmf.dsmapi.common.impl.FacadeRestUtil;
import org.tmf.dsmapi.common.impl.PATCH;
import com.wordnik.swagger.annotations.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import javax.ws.rs.HEAD;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.tmf.dsmapi.common.impl.JsonRequest;
import org.tmf.dsmapi.common.model.Graph;
import org.tmf.dsmapi.common.model.GraphTask;
import org.tmf.dsmapi.common.model.Href;
import org.tmf.dsmapi.common.model.JsonPatch;
import org.tmf.dsmapi.inventory.resource.model.Resource;
import org.tmf.dsmapi.inventory.resource.model.Link;

/**
 *
 * @author pierregauthier
 */
@Stateless
@Api(value = "/inventory/resource/equipment", description = "Used to retrieve and manage Equipment in inventory.")
@Path("/inventory/resource/equipment")
public class EquipmentFacadeREST {

    @EJB
    private EquipmentFacade manager;

    public EquipmentFacadeREST() {
    }

    @GET
    @ApiOperation(value = "Retrieve Equipment", notes = "Retrieve Equipment using option filter.", response = Equipment.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid Filter"),
        @ApiResponse(code = 500, message = "Internal Server Error")
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
        List<Equipment> resultList = findByCriteria(criteria);

        Response response;
        if (fieldSet.isEmpty() || fieldSet.contains(FacadeRestUtil.ALL_FIELDS)) {
            response = Response.ok(resultList).build();
        } else {
            fieldSet.add(FacadeRestUtil.ID_FIELD);
            List<ObjectNode> nodeList = new ArrayList<ObjectNode>();
            for (Equipment productOffering : resultList) {
                ObjectNode node = FacadeRestUtil.createNodeViewWithFields(productOffering, fieldSet);
                nodeList.add(node);
            }
            response = Response.ok(nodeList).build();
        }
        return response;
    }

    @POST
    @ApiOperation(value = "Create Equipment", notes = "Creates equipment given the passed in representation.", response = Equipment.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create(
            @ApiParam(value = "Equipment to be created.", required = true) Equipment entity,
            @Context UriInfo uriInfo) {
        entity.setType(entity.getClass().getSimpleName());
        entity.setId(null);
        manager.create(entity);
        entity.setHref(uriInfo.getAbsolutePath().toString() + "/" + entity.getId());
        entity.setId(entity.getId());
        Response response = Response.ok(entity).build();
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
    public Response getHTTPHeadersForList(
            @ApiParam(value = "Query Specification", required = false) @QueryParam("_s") String _s,
            @ApiParam(value = "Field Specification", required = false) @QueryParam("fields") String fields,
            @Context UriInfo info) throws BadUsageException {
        // search criteria
        MultivaluedMap<String, String> criteria = info.getQueryParameters();

        List<Equipment> resultList = findByCriteria(criteria);

        Response response;
        ResponseBuilder responseBuilder = Response.noContent();
        String start = new String();
        if (resultList.size() == 0) {
            start = "0";
        } else {
            start = "1";
        }
        responseBuilder.header("Content-Range", "items " + start + "-" + resultList.size() + "/" + manager.count());
        response = responseBuilder.build();
        return response;
    }

    @GET
    @ApiOperation(value = "Retrieve equipment by ID", notes = "Retrieves a specific equipment by ID.", response = Equipment.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Path("/{id}")
    @Produces({"application/json"})
    public Response findWithFields(
            @ApiParam(value = "Equipment ID", required = true) @PathParam("id") String id,
            @ApiParam(value = "Field Specification", required = false) @QueryParam("fields") String fields,
            @Context UriInfo info) {
        // fields to filter view
        Set<String> fieldSet = FacadeRestUtil.getFieldSet(info.getQueryParameters());

        Equipment p = manager.find(id);
        Response response;
        // if troubleTicket exists
        if (p != null) {
            // 200
            if (fieldSet.isEmpty() || fieldSet.contains(FacadeRestUtil.ALL_FIELDS)) {
                response = Response.ok(p).build();
            } else {
                fieldSet.add(FacadeRestUtil.ID_FIELD);
                ObjectNode node = FacadeRestUtil.createNodeViewWithFields(p, fieldSet);
                response = Response.ok(node).build();
            }
        } else {
            // 404 not found
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        return response;
    }

    @PATCH
    @ApiOperation(value = "Modify Equipment", notes = "Modify the specified equipment.", response = Equipment.class, httpMethod = "PATCH")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Path("/{id}")
    @Consumes({"application/json+patch"})
    @Produces({"application/json"})
    public Response edit(@ApiParam(value = "Equipment ID", required = true) @PathParam("id") String id,
    JsonPatch patch) {
        Response response = null;
        Equipment entity = manager.find(id);
        if (entity != null) {
            // 200
            manager.edit(entity);
            response = Response.ok(entity).build();
        } else {
            // 404 not found
            response = Response.status(404).build();
        }
        return response;
    }

    @DELETE
    @ApiOperation(value = "Delete the specified Equipment", notes = "Delete the specified equipment.")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Path("/{id}")
    public Response remove(@ApiParam(value = "Equipment ID", required = true) @PathParam("id") String id) {
        Response response = null;
       try {
            manager.remove(manager.find(id));
            response = Response.noContent().build();
        } catch (Exception ex) {
            response = Response.status(404).build();            
        }
        return response;
    }

    private List<Equipment> findByCriteria(MultivaluedMap<String, String> criteria) throws BadUsageException {
        List<Equipment> resultList = null;
        if (criteria != null && !criteria.isEmpty()) {
            resultList = manager.findByCriteria(criteria, Equipment.class);
        } else {
            resultList = manager.findAll();
        }
        return resultList;
    }

    /**
     *
     * @param entity
     * @return
     */
    @POST
    @ApiOperation(value = "Creates a request for a graph based on the idetified equipment.", notes = "Causes the creation of the specified graph.", response = Graph.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Path("/{id}/graph")
    public Response createGraph(@ApiParam(value = "Equipment ID", required = true) @PathParam("id") String id,
            @ApiParam(value = "The definition of the graph to be created.", required = true) GraphTask graphTask) {
        Response response = null;
        Equipment p = manager.find(id);
        if (p == null) {
            response = Response.status(404).build();
        } else {
            Field f = null;
            Class<?> c = p.getClass();
            Graph entity = new Graph();
            for (int count = 0; count < graphTask.getAssociationAndRole().length; count++) {
                //try
                {
                    Href objects[] = null;
                    try {
                        String attributeName = graphTask.getAssociationAndRole()[count].getAttribute();
                        f = c.getDeclaredField(attributeName);
                    } catch (Exception ex) {
                        response = Response.status(Response.Status.BAD_REQUEST).build();
                        return response;
                    }
                    f.setAccessible(true);
                    entity.assoication = new Graph.Assoication[2];
                    try {
                        objects = Href[].class.cast(f.get(p));
                    } catch (Exception ex) {
                        response = Response.status(Response.Status.BAD_REQUEST).build();
                        return response;
                    }
                    for (int icount = 0; icount < 2; icount++) {
                        Href obj = (Href) objects[icount];
                        entity.assoication[icount] = entity.new Assoication();
                        entity.assoication[icount].name = graphTask.getAssociationAndRole()[count].getAttribute();
                        entity.assoication[icount].role = obj.getRole();
                        entity.assoication[icount].aEnd = "http://localhost:8080/DSResourceInventory/webresources/inventory/resource/topologicalLink/" + id;
                        entity.assoication[icount].zEnd = obj.getHref();
                    }
                } //catch (Exception ex) {
                //    // throw client error here
                //}

            }

           // entity.assoication = new Graph.Assoication[2];
            entity.data = new Resource[3];
            entity.data[0] = p;
            for (int count = 0; count < entity.assoication.length; count++) {
                String uri = entity.assoication[count].zEnd;
                JsonRequest jsonRequest = new JsonRequest(uri, Equipment.class);
                Equipment the_object = (Equipment) jsonRequest.getObject();
                entity.data[count + 1] = the_object;
            }
            response = Response.ok(entity).build();

        }
        return response;
    }
    
    @HEAD
    @ApiOperation(value = "Retrieve the HTTP Header", notes = "Retrieve the HTTP header that would have been returned by the coresponding GET.")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "No Data"),
        @ApiResponse(code = 400, message = "Invalid Filter"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Path("/{id}")
    @Produces({"application/json"})
    public Response getHTTPHeadersForInstance(
            @ApiParam(value = "Query Specification", required = false) @QueryParam("_s") String _s,
            @ApiParam(value = "Field Specification", required = false) @QueryParam("fields") String fields,
            @Context UriInfo info) throws BadUsageException {
        // search criteria
        MultivaluedMap<String, String> criteria = info.getQueryParameters();

        List<Equipment> resultList = findByCriteria(criteria);

        Response response;
        ResponseBuilder responseBuilder = Response.noContent();
        String start = new String();
        if (resultList.size() == 0) {
            start = "0";
        } else {
            start = "1";
        }
        responseBuilder.header("Content-Range", "items " + start + "-" + resultList.size() + "/" + manager.count());
        response = responseBuilder.build();
        return response;
    }
}
