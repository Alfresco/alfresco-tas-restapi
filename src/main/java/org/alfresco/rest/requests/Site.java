package org.alfresco.rest.requests;

import java.util.List;

import org.alfresco.rest.core.JsonBodyGenerator;
import org.alfresco.rest.core.RestRequest;
import org.alfresco.rest.core.RestResponse;
import org.alfresco.rest.core.RestWrapper;
import org.alfresco.rest.exception.JsonToModelConversionException;
import org.alfresco.rest.model.RestSiteContainerModel;
import org.alfresco.rest.model.RestSiteContainerModelsCollection;
import org.alfresco.rest.model.RestSiteMemberModel;
import org.alfresco.rest.model.RestSiteMemberModelsCollection;
import org.alfresco.rest.model.RestSiteModel;
import org.alfresco.rest.model.RestSiteModelsCollection;
import org.alfresco.rest.model.RestSitePersonMembershipRequestModelsCollection;
import org.alfresco.utility.model.SiteModel;
import org.alfresco.utility.model.UserModel;
import org.springframework.http.HttpMethod;

/**
 * Declares all Rest API under the /sites path
 *
 */
public class Site extends ModelRequest<Site>
{
  private SiteModel site;
  
  public Site(SiteModel site, RestWrapper restWrapper) 
  {
    super(restWrapper);
    this.site = site;    
  }
  
  /**
   * Retrieve one site using GET call on "sites/{siteId}"
   * 
   * @return
   * @throws JsonToModelConversionException
   */
  public RestSiteModel getSite()
  {
      RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "sites/{siteId}?{parameters}", this.site.getId(), restWrapper.getParameters());
      return restWrapper.processModel(RestSiteModel.class, request);
  }
  
  /**
   * Retrieve one site using GET call on "sites/{siteId}" along with relations parameter
   * 
   * @return
   * @throws JsonToModelConversionException
   */
  public List<Object> getSiteWithRelations()
  {
      RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "sites/{siteId}?{parameters}", this.site.getId(), restWrapper.getParameters());
      return restWrapper.processRelationsJson(request);
  }

  /**
   * Retrieve 100 sites (this is the default size when maxItems is not specified) from Alfresco using GET call on TestGroup.SITES
   * 
   * @return
   * @throws JsonToModelConversionException
   */
  public RestSiteModelsCollection getSites()
  {
      RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "sites?{parameters}", restWrapper.getParameters());
      return restWrapper.processModels(RestSiteModelsCollection.class, request);
  }
  
  /**
   * Retrieve sites using GET call on "sites/{siteId}" along with relations parameter
   * 
   * @return
   * @throws JsonToModelConversionException
   */
  public List<List<Object>> getSitesWithRelations()
  {
      RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "sites?{parameters}", restWrapper.getParameters());
      return restWrapper.processSitesRelationsJson(request);
  }
  
  /**
   * Add new site member using POST call on "/sites/{siteId}/members"
   * 
   * @param person {@link UserModel}
   * @return
   * @throws JsonToModelConversionException
   */
  public RestSiteMemberModel addPerson(UserModel person)
  {
      String siteMemberBody = JsonBodyGenerator.siteMember(person);
      RestRequest request = RestRequest.requestWithBody(HttpMethod.POST, siteMemberBody, "sites/{siteId}/members?{parameters}", site.getId(), restWrapper.getParameters());
      return restWrapper.processModel(RestSiteMemberModel.class, request);
  }
  
  /**
   * Retrieve all members of a site using GET call on "sites/{siteId}/members"
   * 
   * @return
   * @throws JsonToModelConversionException
   */
  public RestSiteMemberModelsCollection getSiteMembers()
  {
      RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "sites/{siteId}/members?{parameters}", site.getId(), restWrapper.getParameters());
      return restWrapper.processModels(RestSiteMemberModelsCollection.class, request);
  }

  /**
   * Retrieve specific member of a site using GET call on "sites/{siteId}/members/{personId}"
   * 
   * @param user A model containing the username to look for.
   * @return
   * @throws JsonToModelConversionException
   */
  public RestSiteMemberModel getSiteMember(UserModel user)
  {
      RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "sites/{siteId}/members/{personId}?{parameters}", site.getId(), user.getUsername(), restWrapper.getParameters());
      return restWrapper.processModel(RestSiteMemberModel.class, request);
  }

  /**
   * Update site member role with PUT call on "sites/{siteId}/members/{personId}"
   * @param siteMember
   * @return
   * @throws JsonToModelConversionException
   */
  public RestSiteMemberModel updateSiteMember(UserModel siteMember)
  {
      String json = JsonBodyGenerator.keyValueJson("role", siteMember.getUserRole().toString());
      RestRequest request = RestRequest.requestWithBody(HttpMethod.PUT, json, "sites/{siteId}/members/{personId}", site.getId(), siteMember.getUsername());
      return restWrapper.processModel(RestSiteMemberModel.class, request);
  }

  /**
   * Delete site member with DELETE call on "sites/{siteId}/members/{personId}"
   * @param person
   */
  public void deleteSiteMember(UserModel person)
  {
      RestRequest request = RestRequest.simpleRequest(HttpMethod.DELETE, "sites/{siteId}/members/{personId}", site.getId(), person.getUsername());
      restWrapper.processEmptyModel(request);
  }

  /**
   * Retrieve all containers of a site using GET call on "sites/{siteId}/containers"
   * 
   * @return
   * @throws JsonToModelConversionException
   */
  public RestSiteContainerModelsCollection getSiteContainers()
  {
      RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "sites/{siteId}/containers?{parameters}", site.getId(), restWrapper.getParameters());
      return restWrapper.processModels(RestSiteContainerModelsCollection.class, request);
  }
  
  /**
   * Retrieve specific container of a site using GET call on "sites/{siteId}/containers/{containerId}"
   * 
   * @param container A model containing the folderId to look for.
   * @return
   * @throws JsonToModelConversionException
   */
  public RestSiteContainerModel getSiteContainer(RestSiteContainerModel container)
  {
      RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "sites/{siteId}/containers/{containerId}?{parameters}", site.getId(), container.getFolderId(), restWrapper.getParameters());
      return restWrapper.processModel(RestSiteContainerModel.class, request);
  }   
  
  /**
   * Retrieve specific container of a site using GET call on "sites/{siteId}/containers/{containerId}"
   * 
   * @param containerFolder The id of the container to look for.
   * @return
   * @throws JsonToModelConversionException
   */
  public RestSiteContainerModel getSiteContainer(String containerFolder)
  {
      RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "sites/{siteId}/containers/{containerId}?{parameters}", site.getId(), containerFolder, restWrapper.getParameters());
      return restWrapper.processModel(RestSiteContainerModel.class, request);
  }

  /**
   * Create a collaboration site
   * 
   * @return the properties of the created site
   * @throws Exception
   */
  public RestSiteModel createSite() throws Exception
  {
      RestRequest request = RestRequest.requestWithBody(HttpMethod.POST, site.toJson(), "sites?{parameters}", restWrapper.getParameters());
      return restWrapper.processModel(RestSiteModel.class, request);
  }

  /**
   * Get site membership requests by using GET /site-membership-requests
   * 
   * @return site memberships
   */
  public RestSitePersonMembershipRequestModelsCollection getSiteMemberships()
  {
      RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "site-membership-requests?{parameters}", restWrapper.getParameters());
      return restWrapper.processModels(RestSitePersonMembershipRequestModelsCollection.class, request);
  }

  /**
   * Approve a site membership request by using POST call on /sites/{siteId}/site-membership-requests/{inviteeId}/approve
   * 
   * @param siteMember
   */
  public RestResponse approveSiteMembership(UserModel siteMember)
  {
      String json = JsonBodyGenerator.keyValueJson("role", siteMember.getUserRole().toString());
      RestRequest request = RestRequest.requestWithBody(HttpMethod.POST, json, "sites/{siteId}/site-membership-requests/{inviteeId}/approve", site.getId(), siteMember.getUsername());
      return restWrapper.process(request);
  }

  /**
   * Reject a site membership request by using POST call /sites/{siteId}/site-membership-requests/{inviteeId}/reject
   * 
   * @param siteMember
   */
  public RestResponse rejectSiteMembership(UserModel siteMember)
  {
      RestRequest request = RestRequest.simpleRequest(HttpMethod.POST, "sites/{siteId}/site-membership-requests/{inviteeId}/reject", site.getId(), siteMember.getUsername());
      return restWrapper.process(request);
  }
}
