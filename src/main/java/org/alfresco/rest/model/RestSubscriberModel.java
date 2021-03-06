/*
 * Copyright 2017 Alfresco Software, Ltd. All rights reserved.
 * License rights for this program may be obtained from Alfresco Software, Ltd.
 * pursuant to a written agreement and any use of this program without such an
 * agreement is prohibited.
 */

package org.alfresco.rest.model;

import org.alfresco.rest.core.IRestModel;
import org.alfresco.rest.core.assertion.ModelAssertion;
import org.alfresco.utility.model.TestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Base Path {@linkplain /alfresco/api/-default-/private/alfresco/versions/1}
 * 
 * @author Meenal Bhave
 *         {
 *         "entry": {
 *         "createdAt": "2017-08-11T14:18:22.765+0000",
 *         "syncService": {
 *         "id": "0",
 *         "uri": "https://localhost:9090/alfresco",
 *         "config": {
 *         "filters": {
 *         "nodeAspects": [
 *         "rma:filePlanComponent",
 *         "sf:*",
 *         "smf:*",
 *         "cm:workingcopy"
 *         ],
 *         "smartFolderNodeAspects": [
 *         "sf:*",
 *         "smf:*"
 *         ],
 *         "nodeTypesWhitelist": [
 *         "dod:filePlan",
 *         "hwf:rejectedCloudTask",
 *         "imap:imapBody",
 *         "st:site"
 *         ],
 *         "nodeTypes": [
 *         "bpm:package",
 *         "cm:systemfolder",
 *         "cm:failedThumbnail"
 *         ]
 *         },
 *         "dsyncClientVersionMin": "1.0.1",
 *         "repoInfo": {
 *         "versionLabel": "5.2.2",
 *         "edition": "Enterprise"
 *         }
 *         }
 *         },
 *         "deviceOS": "windows",
 *         "syncServiceId": "0",
 *         "id": "089e45bd-a059-41f2-885e-c51f487956d6"
 *         }
 *         }
 */
public class RestSubscriberModel extends TestModel implements IRestModel<RestSubscriberModel>
{

    public RestSubscriberModel()
    {
    }

    public RestSubscriberModel(String deviceOS, String clientVersion)
    {
        super();
        this.deviceOS = deviceOS;
        this.clientVersion = clientVersion;
    }

    @JsonProperty(value = "entry")
    RestSubscriberModel model;

    @Override
    public RestSubscriberModel onModel()
    {
        return model;
    }

    @Override
    public ModelAssertion<RestSubscriberModel> assertThat()
    {
        return new ModelAssertion<RestSubscriberModel>(this);
    }

    @Override
    public ModelAssertion<RestSubscriberModel> and()
    {
        return assertThat();
    }

    @JsonProperty(required = true)
    private String createdAt;

    @JsonProperty(required = true)
    private RestSyncServiceModel syncService;

    @JsonProperty(required = true)
    private String deviceOS;

    @JsonProperty(required = true)
    private String syncServiceId;

    @JsonProperty(required = true)
    private String id;

    @JsonProperty(required = false)
    private String clientVersion;

    public String getClientVersion()
    {
        return clientVersion;
    }

    public String getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(String createdAt)
    {
        this.createdAt = createdAt;
    }

    public RestSyncServiceModel getSyncService()
    {
        return syncService;
    }

    public void setSyncService(RestSyncServiceModel syncService)
    {
        this.syncService = syncService;
    }

    public String getDeviceOS()
    {
        return deviceOS;
    }

    public void setDeviceOS(String deviceOS)
    {
        this.deviceOS = deviceOS;
    }

    public String getSyncServiceId()
    {
        return syncServiceId;
    }

    public void setSyncServiceId(String syncServiceId)
    {
        this.syncServiceId = syncServiceId;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
