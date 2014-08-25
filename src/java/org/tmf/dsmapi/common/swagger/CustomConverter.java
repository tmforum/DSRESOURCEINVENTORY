/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.common.swagger;

import com.wordnik.swagger.converter.SwaggerSchemaConverter;
import com.wordnik.swagger.model.Model;
import com.wordnik.swagger.model.ModelProperty;
import scala.collection.mutable.LinkedHashMap;
import scala.collection.immutable.Map;
import scala.Option;

/**
 *
 * @author jmorey
 */
public class CustomConverter extends SwaggerSchemaConverter {
    
    @Override
    public Option<Model> read(Class<?> cls, Map <String, String> typeMap) {
        Option<Model> mod =  super.read(cls, typeMap);
        Model old = mod.get();

        LinkedHashMap<String,ModelProperty> props = old.properties();
        props = (LinkedHashMap<String, ModelProperty>) props.$minus("_persistence_shouldRefreshFetchGroup");

        Model m = new Model(old.id(),old.name(), old.qualifiedType(),props,old.description(), old.baseModel(),old.discriminator(),old.subTypes());
        Option<Model> nopt = Option.apply(m);
        return nopt;
    }

}


