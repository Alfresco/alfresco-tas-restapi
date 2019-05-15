/*
 * Copyright (C) 2018 Alfresco Software Limited.
 * This file is part of Alfresco
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 */
package org.alfresco.rest.requests.search;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import org.alfresco.rest.core.RestRequest;
import org.alfresco.rest.core.RestWrapper;
import org.alfresco.rest.model.RestTextResponse;
import org.alfresco.rest.requests.ModelRequest;
import org.springframework.http.HttpMethod;

/**
 * Wrapper for solr API.
 * 
 * @author Meenal Bhave
 */
public class SolrAPI extends ModelRequest<SolrAPI>
{
    public SolrAPI(RestWrapper restWrapper)
    {  
        super(restWrapper);
        RestAssured.basePath = "solr/alfresco";
        
        restWrapper.configureSolrEndPoint();
        restWrapper.configureRequestSpec().setBasePath(RestAssured.basePath);
    }

    public RestTextResponse getConfig() throws Exception
    {
        RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "config?{parameters}", restWrapper.getParameters());
        return restWrapper.processTextResponse(request);
    }

    public RestTextResponse getConfigOverlay() throws Exception
    {
        RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "config/overlay?{parameters}", restWrapper.getParameters());
        return restWrapper.processTextResponse(request);
    }

    public RestTextResponse getConfigParams() throws Exception
    {
        RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "config/params?{parameters}", restWrapper.getParameters());
        return restWrapper.processTextResponse(request);
    }

    public RestTextResponse postConfig(String queryBody) throws Exception
    {
        RestRequest request = RestRequest.requestWithBody(HttpMethod.POST, queryBody, "config");
        return restWrapper.processTextResponse(request);
    }

    public RestTextResponse getSelectQuery() throws Exception
    {
        List<Header> headers = new ArrayList<Header>();
        headers.add(new Header("Content-Type", "application/xml"));
        Headers header = new Headers(headers);
        restWrapper.setResponseHeaders(header);
        restWrapper.configureRequestSpec().setUrlEncodingEnabled(false);
        RestRequest request = RestRequest.simpleRequest(HttpMethod.GET, "select?q={parameters}", restWrapper.getParameters());
        return restWrapper.processTextResponse(request);
    }
}
