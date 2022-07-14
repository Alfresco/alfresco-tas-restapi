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
public class RestRuleSetModel extends TestModel implements IRestModel<RestRuleSetModel>
{
    @Override
    public ModelAssertion<RestRuleSetModel> assertThat()
    {
        return new ModelAssertion<RestRuleSetModel>(this);
    }

    @Override
    public ModelAssertion<RestRuleSetModel> and()
    {
        return assertThat();
    }

    @JsonProperty(value = "entry")
    RestRuleSetModel model;

    @Override
    public RestRuleSetModel onModel()
    {
        return model;
    }

    /**
    Identifier for the rule set
    */	        

    @JsonProperty(required = true)    
    private String id;	    
    /**
    True if the rule set is shared to at least one folder
    */	        

    @JsonProperty(required = true)    
    private boolean shared;	    
    /**
    List of folder identifiers which use the rule set.

Note that any folders the user does not have access to will not appear in this list. Use **shared** instead to check existence of any link.

    */	        

    private List<String> usedBy;	    
    /**
    An ordered list of the rule ids within the rule set
    */	        

    private List<String> ruleIds;	    

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }				

    public boolean getShared()
    {
        return this.shared;
    }

    public void setShared(boolean shared)
    {
        this.shared = shared;
    }				

    public List<String> getUsedBy()
    {
        return this.usedBy;
    }

    public void setUsedBy(List<String> usedBy)
    {
        this.usedBy = usedBy;
    }				

    public List<String> getRuleIds()
    {
        return this.ruleIds;
    }

    public void setRuleIds(List<String> ruleIds)
    {
        this.ruleIds = ruleIds;
    }				
}
 
