/*-
 * #%L
 * alfresco-tas-restapi
 * %%
 * Copyright (C) 2005 - 2022 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software. 
 * If the software was purchased under a paid Alfresco license, the terms of 
 * the paid license agreement will prevail.  Otherwise, the software is 
 * provided under the following open source license terms:
 * 
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */
package org.alfresco.rest.model;

import java.util.Objects;

import org.alfresco.rest.core.IRestModel;
import org.alfresco.rest.core.assertion.ModelAssertion;
import org.alfresco.utility.model.TestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Generated by 'Kristian.Dimitrov@hyland.com' on '2022-07-13 15:53' from 'Alfresco Content Services REST API' swagger file 
 * Generated from 'Alfresco Content Services REST API' swagger file
 * Base Path {@linkplain /alfresco/api/-default-/public/alfresco/versions/1}
 */
public class RestSimpleConditionDefinitionModel extends TestModel implements IRestModel<RestSimpleConditionDefinitionModel>
{
    @Override
    public ModelAssertion<RestSimpleConditionDefinitionModel> assertThat()
    {
        return new ModelAssertion<RestSimpleConditionDefinitionModel>(this);
    }

    @Override
    public ModelAssertion<RestSimpleConditionDefinitionModel> and()
    {
        return assertThat();
    }

    @JsonProperty(value = "entry")
    RestSimpleConditionDefinitionModel model;

    @Override
    public RestSimpleConditionDefinitionModel onModel()
    {
        return model;
    }

    /**
    The name of the property to compare.

This should be either a property (e.g. "cm:name") or one of the keywords from this list:
* size (the size of the content for a node)
* mimetype (the mimetype of the content for a node)
* encoding (the encoding of the content for a node)
* category (a category for the node)
* tag (a tag that the node has)
* aspect (an aspect that the node has)

For multi-valued properties the condition is satisfied if any of the values match the condition.

    */	        

    @JsonProperty(required = true)    
    private String field;	    
    /**
    The method to compare the property against the parameter.

Depending on the type of the property then different comparators are available:
* All types: equals
* text: contains, startsWith, endsWith
* int/long/float/double/date: greaterThan, lessThan, greaterThanOrEqual, lessThanOrEqual
* type: instanceOf

Where a property is multivalued then the condition is true if it is satisfied by any of the values.

    */	        

    @JsonProperty(required = true)    
    private String comparator;	    
    /**
    The value to compare the field against
    */	        

    @JsonProperty(required = true)    
    private String parameter;	    

    public String getField()
    {
        return this.field;
    }

    public void setField(String field)
    {
        this.field = field;
    }				

    public String getComparator()
    {
        return this.comparator;
    }

    public void setComparator(String comparator)
    {
        this.comparator = comparator;
    }				

    public String getParameter()
    {
        return this.parameter;
    }

    public void setParameter(String parameter)
    {
        this.parameter = parameter;
    }

    @Override
    public String toString()
    {
        return "RestSimpleConditionDefinitionModel{" + "field='" + field + '\'' + ", comparator='" + comparator + '\'' + ", parameter='" + parameter + '\'' + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RestSimpleConditionDefinitionModel that = (RestSimpleConditionDefinitionModel) o;
        return Objects.equals(field, that.field) && Objects.equals(comparator, that.comparator) && Objects.equals(parameter, that.parameter);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(field, comparator, parameter);
    }
}
 
