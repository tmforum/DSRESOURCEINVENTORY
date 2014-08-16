/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tmf.org.dsmapi.common.impl;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import tmf.org.dsmapi.inventory.resource.model.Tpe;

public class JsonRequest {

    private WebResource webResource;
    private Client client;
    private Class wantedClass;

    public JsonRequest(String uri, Class wantedClass) {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(uri);
    }

   public Object getObject() throws UniformInterfaceException {
        Tpe tpe =  webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(Tpe.class);
        return tpe;
    }

    public void close() {
        client.destroy();
    }
}
