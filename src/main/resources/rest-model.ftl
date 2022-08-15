package org.alfresco.rest.model;

import java.util.List;

import org.alfresco.rest.core.IRestModel;
import org.alfresco.utility.model.TestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Generated by '${author}' on '${date}' from '${yamlTitle}' swagger file 
 * Generated from '${yamlTitle}' swagger file
 * Base Path {@linkplain ${yamlBasePath}}
 */
public class ${name} extends TestModel implements IRestModel<${name}>
{
    @JsonProperty(value = "entry")
    ${name} model;

    @Override
    public ${name} onModel()
    {
        return model;
    }

<#if properties??>	
<#list properties as p>	
	<#if p.getDescription()??>
    /**
    ${p.getDescription()}
    */	        
	</#if>

	<#if p.isRequired()==true>    
    @JsonProperty(required = true)    
	</#if>
    private ${p.getType()} ${p.getName()};	    
</#list>
</#if>
<#if properties??>	
<#list properties as p>

    public ${p.getType()} get${p.getNameCapitalized()}()
    {
        return this.${p.getName()};
    }

    public void set${p.getNameCapitalized()}(${p.getType()} ${p.getName()})
    {
        this.${p.getName()} = ${p.getName()};
    }				
</#list>
</#if>
}
 
