package org.alfresco.rest.requests;

import java.util.HashMap;

import javax.json.JsonArrayBuilder;

import org.alfresco.rest.core.JsonBodyGenerator;
import org.alfresco.rest.core.RestRequest;
import org.alfresco.rest.core.RestResponse;
import org.alfresco.rest.core.RestWrapper;
import org.alfresco.rest.exception.JsonToModelConversionException;
import org.alfresco.rest.model.RestRenditionInfoModel;
import org.alfresco.rest.model.RestRenditionInfoModelCollection;
import org.alfresco.rest.model.RestSharedLinksModel;
import org.alfresco.rest.model.RestSharedLinksModelCollection;
import org.alfresco.utility.model.FileModel;
import org.springframework.http.HttpMethod;

/**
 * Declares all Rest API under the /shared-links path
 * 
 * @author Meenal Bhave
 */
public class SharedLinks extends ModelRequest<SharedLinks>
{
    public SharedLinks(RestWrapper restWrapper)
    {
        super(restWrapper);
    }

    /**
     * Retrieve sharedLinks using GET call on /shared-links
     * 
     * @return RestSharedLinksModelCollection
     * @throws JsonToModelConversionException
     */
    public RestSharedLinksModelCollection getSharedLinks() throws Exception
    {
        RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "shared-links?{parameters}", restWrapper.getParameters());
        return restWrapper.processModels(RestSharedLinksModelCollection.class, request);
    }

    /**
     * Retrieve details for a specific sharedLink using GET call on "shared-links/{sharedLinkId}"
     * 
     * @param sharedLinksModel
     * @return RestSharedLinkModel
     * @throws JsonToModelConversionException
     */
    public RestSharedLinksModel getSharedLink(RestSharedLinksModel sharedLinksModel) throws Exception
    {
        RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "shared-links/{sharedLinkId}?{parameters}", sharedLinksModel.getId(),
                restWrapper.getParameters());
        return restWrapper.processModel(RestSharedLinksModel.class, request);
    }

    /**
     * Retrieve content for a specific sharedLink using GET call on "shared-links/{sharedLinkId}/content"
     * 
     * @param sharedLinksModel
     * @return RestResponse
     * @throws Exception
     */
    public RestResponse getSharedLinkContent(RestSharedLinksModel sharedLinksModel) throws Exception
    {
        RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "shared-links/{sharedLinkId}/content?{parameters}", sharedLinksModel.getId(),
                restWrapper.getParameters());
        return restWrapper.process(request);
    }

    /**
     * Send email with a specific sharedLink using POST call on "shared-links/{sharedLinkId}/email"
     * 
     * @param sharedLinksModel
     * @param postBody
     * @return RestResponse
     * @throws Exception
     */
    public RestResponse sendSharedLinkEmail(RestSharedLinksModel sharedLinksModel, String postBody) throws Exception
    {
        RestRequest request = RestRequest.requestWithBody(HttpMethod.POST, postBody, "shared-links/{sharedLinkId}/email?{parameters}", sharedLinksModel.getId(),
                restWrapper.getParameters());
        return restWrapper.process(request);
    }

    /**
     * Retrieves Renditions for the specified sharedLink
     * 
     * @return RestRenditionInfoModelCollection
     * @throws JsonToModelConversionException
     */
    public RestRenditionInfoModelCollection getSharedLinkRenditions(RestSharedLinksModel sharedLinksModel) throws Exception
    {
        RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "shared-links/{sharedLinkId}/renditions?{parameters}", sharedLinksModel.getId(),
                restWrapper.getParameters());
        return restWrapper.processModels(RestRenditionInfoModelCollection.class, request);
    }

    /**
     * Retrieves specific Rendition for the specified sharedLink
     * 
     * @param sharedLinksModel
     * @param renditionId
     * @return RestRenditionInfoModel
     * @throws JsonToModelConversionException
     */
    public RestRenditionInfoModel getSharedLinkRendition(RestSharedLinksModel sharedLinksModel, String renditionId) throws Exception
    {
        RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "shared-links/{sharedLinkId}/renditions/{renditionId}?{parameters}",
                sharedLinksModel.getId(), renditionId, restWrapper.getParameters());
        return restWrapper.processModel(RestRenditionInfoModel.class, request);
    }

    /**
     * Retrieve rendition content for the specified sharedLink using GET call on "shared-links/{sharedLinkId}/renditions/{renditionId}/content"
     * 
     * @param sharedLinksModel
     * @param renditionId
     * @return RestRenditionInfoModel
     * @throws Exception
     */
    public RestResponse getSharedLinkRenditionContent(RestSharedLinksModel sharedLinksModel, String renditionId) throws Exception
    {
        RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "shared-links/{sharedLinkId}/renditions/{renditionId}/content?{parameters}",
                sharedLinksModel.getId(), renditionId, restWrapper.getParameters());
        return restWrapper.process(request);
    }

    /**
     * Removes SharedLink for the specified file, the sharedlink is deleted, file is unshared as a result
     * 
     * @param RestSharedLinksModel
     * @return void
     * @throws Exception
     */
    public void deleteSharedLink(RestSharedLinksModel sharedLinksModel) throws Exception
    {
        RestRequest request = RestRequest.simpleRequest(HttpMethod.DELETE, "shared-links/{sharedLinkId}", sharedLinksModel.getId());
        restWrapper.processEmptyModel(request);
    }

    /**
     * Creates SharedLink for the specified file
     * 
     * @param file
     * @return RestSharedLinksModel
     * @throws Exception
     */
    public RestSharedLinksModel createSharedLink(FileModel file) throws Exception
    {
        String postBody = JsonBodyGenerator.keyValueJson("nodeId", file.getNodeRefWithoutVersion());
        RestRequest request = RestRequest.requestWithBody(HttpMethod.POST, postBody, "shared-links?{parameters}", restWrapper.getParameters());
        return restWrapper.processModel(RestSharedLinksModel.class, request);
    }

    /**
     * Creates SharedLink for all the specified files
     * 
     * @param file list
     * @return RestSharedLinksModelCollection
     * @throws Exception
     */
    public RestSharedLinksModelCollection createSharedLinks(FileModel... files) throws Exception
    {
        JsonArrayBuilder array = JsonBodyGenerator.defineJSONArray();
        for (FileModel file : files)
        {
            array.add(JsonBodyGenerator.defineJSON().add("nodeId", file.getNodeRefWithoutVersion()));
        }
        String postBody = array.build().toString();
        RestRequest request = RestRequest.requestWithBody(HttpMethod.POST, postBody, "shared-links?{parameters}", restWrapper.getParameters());
        return restWrapper.processModels(RestSharedLinksModelCollection.class, request);

    }

    /**
     * Creates SharedLink for the specified file, with the given expiry date
     * 
     * @param file
     * @param expiryDate: format: "2027-03-23T23:00:00.000+0000";
     * @return RestSharedLinksModel
     * @throws Exception
     */
    public RestSharedLinksModel createSharedLinkWithExpiryDate(FileModel file, String expiryDate) throws Exception
    {
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("nodeId", file.getNodeRefWithoutVersion());
        body.put("expiresAt", expiryDate);
        String postBody = JsonBodyGenerator.keyValueJson(body);

        RestRequest request = RestRequest.requestWithBody(HttpMethod.POST, postBody, "shared-links?{parameters}", restWrapper.getParameters());
        return restWrapper.processModel(RestSharedLinksModel.class, request);
    }
}