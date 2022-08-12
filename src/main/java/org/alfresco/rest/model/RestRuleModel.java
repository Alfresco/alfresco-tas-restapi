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

import java.util.List;
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
public class RestRuleModel extends TestModel implements IRestModel<RestRuleModel>
{
    @Override
    public ModelAssertion<RestRuleModel> assertThat()
    {
        return new ModelAssertion<RestRuleModel>(this);
    }

    @Override
    public ModelAssertion<RestRuleModel> and()
    {
        return assertThat();
    }

    @JsonProperty(value = "entry")
    RestRuleModel model;

    @Override
    public RestRuleModel onModel()
    {
        return model;
    }

    /**
    Identifier for the rule
    */	        

    @JsonProperty(required = true)    
    private String id;	    
    /**
    Name of the rule
    */	        

    @JsonProperty(required = true)    
    private String name;	    
    /**
    Description of the rule
    */	        

    private String description;	    
    /**
    Whether the rule is enabled
    */	        

    private boolean enabled;	    
    /**
    Whether the rule also applies to subfolders
    */	        

    private boolean cascade;	    
    /**
    Whether the rule should be run in the background
    */	        

    private boolean asynchronous;	    
    /**
    If the rule should be run in the background then an optional error script can be referenced
    */	        

    private String errorScript;	    
    /** True if the rule set is linked to, or if the rule is inheritable and the rule set is inherited by a folder with inheriting enabled. */
    @JsonProperty
    private Boolean isShared;

    /**
    The set of triggers that cause the rule to be activated.
* inbound - The rule should be activated when an item enters the folder
* update - The rule should be activated when an item within the folder is updated
* outbound - The rule should be activated when an item leaves the folder or is deleted

    */	        

    private List<String> triggers;	    
    /**
    The conditions that determine whether the actions will be executed for a rule.

A condition should contain at least one entry in compositeConditions or simpleConditions.

If the field is omitted then the rule will apply to all nodes.

    */	        

    private RestCompositeConditionDefinitionModel conditions;	    
    /**
    The actions for the rule
    */	        

    @JsonProperty(required = true)    
    private List<RestActionBodyExecTemplateModel> actions;	    

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }				

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }				

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }				

    public boolean getEnabled()
    {
        return this.enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }				

    public boolean getCascade()
    {
        return this.cascade;
    }

    public void setCascade(boolean cascade)
    {
        this.cascade = cascade;
    }				

    public boolean getAsynchronous()
    {
        return this.asynchronous;
    }

    public void setAsynchronous(boolean asynchronous)
    {
        this.asynchronous = asynchronous;
    }				

    public String getErrorScript()
    {
        return this.errorScript;
    }

    public void setErrorScript(String errorScript)
    {
        this.errorScript = errorScript;
    }				

    public Boolean getIsShared()
    {
        return this.isShared;
    }

    public void setIsShared(Boolean shared)
    {
        this.isShared = shared;
    }				

    public List<String> getTriggers()
    {
        return this.triggers;
    }

    public void setTriggers(List<String> triggers)
    {
        this.triggers = triggers;
    }				

    public RestCompositeConditionDefinitionModel getConditions()
    {
        return this.conditions;
    }

    public void setConditions(RestCompositeConditionDefinitionModel conditions)
    {
        this.conditions = conditions;
    }				

    public List<RestActionBodyExecTemplateModel> getActions()
    {
        return this.actions;
    }

    public void setActions(List<RestActionBodyExecTemplateModel> actions)
    {
        this.actions = actions;
    }

    @Override
    public String toString()
    {
        return "RestRuleModel{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", description='" + description + '\'' + ", enabled=" + enabled + ", cascade=" + cascade
            + ", asynchronous=" + asynchronous + ", errorScript='" + errorScript + '\'' + ", isShared=" + isShared + ", triggers=" + triggers + ", conditions=" + conditions
            + ", actions=" + actions + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RestRuleModel ruleModel = (RestRuleModel) o;
        return enabled == ruleModel.enabled && cascade == ruleModel.cascade && asynchronous == ruleModel.asynchronous && Objects.equals(id, ruleModel.id) && name.equals(
            ruleModel.name) && Objects.equals(description, ruleModel.description) && Objects.equals(errorScript, ruleModel.errorScript) && Objects.equals(
            isShared, ruleModel.isShared) && Objects.equals(triggers, ruleModel.triggers) && Objects.equals(conditions, ruleModel.conditions) && actions.equals(ruleModel.actions);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, description, enabled, cascade, asynchronous, errorScript, isShared, triggers, conditions, actions);
    }
}
 
