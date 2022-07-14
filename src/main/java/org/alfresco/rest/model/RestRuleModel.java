package org.alfresco.rest.model;

import java.util.List;

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
    /**
    Whether the rule has been shared with more than one folder
    */	        

    @JsonProperty(required = true)    
    private boolean shared;	    
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

    public boolean getShared()
    {
        return this.shared;
    }

    public void setShared(boolean shared)
    {
        this.shared = shared;
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
}
 
