package org.alfresco.rest.model;

import java.util.List;

import org.alfresco.rest.core.IRestModel;
import org.alfresco.rest.core.assertion.ModelAssertion;
import org.alfresco.utility.model.TestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Generated by 'aforascu' on '2018-01-10 16:02' from 'Alfresco Content Services REST API' swagger file 
 * Generated from 'Alfresco Content Services REST API' swagger file
 * Base Path {@linkplain /alfresco/api}
 */
public class RestRepositoryInfoModel extends TestModel implements IRestModel<RestRepositoryInfoModel>
{
    @Override
    public ModelAssertion<RestRepositoryInfoModel> assertThat()
    {
        return new ModelAssertion<RestRepositoryInfoModel>(this);
    }

    @Override
    public ModelAssertion<RestRepositoryInfoModel> and()
    {
        return assertThat();
    }

    @JsonProperty(value = "entry")
    RestRepositoryInfoModel model;

    @Override
    public RestRepositoryInfoModel onModel()
    {
        return model;
    }

    @JsonProperty(required = true)
    private String id;

    @JsonProperty(required = true)    
    private String edition;	    

    @JsonProperty(required = true)    
    private RestVersionInfoModel version;	    

    @JsonProperty(required = true)    
    private RestStatusInfoModel status;	    

    private RestLicenseInfoModel license;	    

    private List<RestModuleInfoModel> modules;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getEdition()
    {
        return this.edition;
    }

    public void setEdition(String edition)
    {
        this.edition = edition;
    }				

    public RestVersionInfoModel getVersion()
    {
        return this.version;
    }

    public void setVersion(RestVersionInfoModel version)
    {
        this.version = version;
    }				

    public RestStatusInfoModel getStatus()
    {
        return this.status;
    }

    public void setStatus(RestStatusInfoModel status)
    {
        this.status = status;
    }				

    public RestLicenseInfoModel getLicense()
    {
        return this.license;
    }

    public void setLicense(RestLicenseInfoModel license)
    {
        this.license = license;
    }				

    public List<RestModuleInfoModel> getModules()
    {
        return this.modules;
    }

    public void setModules(List<RestModuleInfoModel> modules)
    {
        this.modules = modules;
    }				
}
 
