package org.alfresco.rest.model;

import org.alfresco.rest.core.IRestModel;
import org.alfresco.rest.core.assertion.ModelAssertion;
import org.alfresco.utility.model.TestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Handles responses for GET /downloads/{downloadId} and POST /downloads rest calls
 * E.g
 * {
 *   "entry": {
 *      "filesAdded": 1,
 *      "bytesAdded": 4,
 *      "totalBytes": 4,
 *      "id": "6ab1357c-bf13-4ecc-9c6e-3af0b6a7bb34",
 *      "totalFiles": 1,
 *      "status": "DONE"
 *   }
 * }
*/

public class RestDownloadsModel extends TestModel implements IRestModel<RestDownloadsModel>
{
    @Override
    public ModelAssertion<RestDownloadsModel> assertThat()
    {
        return new ModelAssertion<RestDownloadsModel>(this);
    }

    @Override
    public ModelAssertion<RestDownloadsModel> and()
    {
        return assertThat();
    }

    @JsonProperty(value = "entry")
    RestDownloadsModel model;

    @Override
    public RestDownloadsModel onModel()
    {
        return model;
    }

    @JsonProperty(required = true)
    private String filesAdded;

    @JsonProperty(required = true)
    private String bytesAdded;

    @JsonProperty(required = true)
    private String totalBytes;

    @JsonProperty(required = true)
    private String id;

    @JsonProperty(required = true)
    private String totalFiles;

    @JsonProperty(required = true)
    private String status;

    public RestDownloadsModel getModel()
    {
        return model;
    }

    public void setModel(RestDownloadsModel model)
    {
        this.model = model;
    }

    public String getFilesAdded()
    {
        return filesAdded;
    }

    public void setFilesAdded(String filesAdded)
    {
        this.filesAdded = filesAdded;
    }

    public String getBytesAdded()
    {
        return bytesAdded;
    }

    public void setBytesAdded(String bytesAdded)
    {
        this.bytesAdded = bytesAdded;
    }

    public String getTotalBytes()
    {
        return totalBytes;
    }

    public void setTotalBytes(String totalBytes)
    {
        this.totalBytes = totalBytes;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTotalFiles()
    {
        return totalFiles;
    }

    public void setTotalFiles(String totalFiles)
    {
        this.totalFiles = totalFiles;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}

