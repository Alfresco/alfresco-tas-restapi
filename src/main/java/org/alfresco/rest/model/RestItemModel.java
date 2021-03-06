package org.alfresco.rest.model;

import org.alfresco.rest.core.IRestModel;
import org.alfresco.rest.core.assertion.ModelAssertion;
import org.alfresco.utility.model.TestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 "entry": {
          "createdAt": "2016-10-13T11:21:34.621+0000",
          "size": 19,
          "createdBy": "admin",
          "modifiedAt": "2016-10-13T11:21:38.338+0000",
          "name": "file-yCQFYpLniWAzkcR.txt",
          "modifiedBy": "User-cchKFZoNIAfZXXn",
          "id": "ffb7178f-fc11-41c9-8c40-df6523ad917f",
          "mimeType": "text/plain"
        }
 *
 */
public class RestItemModel extends TestModel implements IRestModel<RestItemModel>
{
    @JsonProperty(value = "entry")
    RestItemModel model;
 
    @JsonProperty(required = true)
    private String createdAt;
    private int size;
    private String createdBy;
    private String modifiedAt;
    private String name;
    private String modifiedBy;
    private String id;
    private String mimeType;
    
    @Override
    public RestItemModel onModel()
    {
        return model;
    }

    public String getCreatedAt()
    {
        return createdAt;
    }
    public void setCreatedAt(String createdAt)
    {
        this.createdAt = createdAt;
    }
    public int getSize()
    {
        return size;
    }
    public void setSize(int size)
    {
        this.size = size;
    }
    public String getCreatedBy()
    {
        return createdBy;
    }
    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getModifiedBy()
    {
        return modifiedBy;
    }
    public void setModifiedBy(String modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getMimeType()
    {
        return mimeType;
    }
    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }
    public String getModifiedAt()
    {
        return modifiedAt;
    }
    public void setModifiedAt(String modifiedAt)
    {
        this.modifiedAt = modifiedAt;
    }
    
    @Override
    public ModelAssertion<RestItemModel> and() 
    {      
      return assertThat();
    }
    
    @Override
    public ModelAssertion<RestItemModel> assertThat() 
    {      
      return new ModelAssertion<RestItemModel>(this);
    }
}    