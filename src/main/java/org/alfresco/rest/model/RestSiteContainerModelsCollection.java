/*-
 * #%L
 * alfresco-tas-restapi
 * %%
 * Copyright (C) 2005 - 2022 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software. 
 * If the software was purchased under a paid Alfresco license, the terms of 
 * the paid license agreement will prevail.  Otherwise, the software is 
 * provided under the following open source license terms:
 * 
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */
package org.alfresco.rest.model;

import org.alfresco.rest.core.RestModels;

/**
 * Handle collection of <RestContainerModel>
 * Example:
 * {
 * "list": {
 * "pagination": {
 * "count": 1,
 * "hasMoreItems": false,
 * "totalItems": 1,
 * "skipCount": 0,
 * "maxItems": 100
 * },
 * "entries": [
 * {
 * "entry": {
 * "id": "d79666e2-3d77-4cbd-aa15-a1e0dcc4da1e",
 * "folderId": "documentLibrary"
 * }
 * }
 * ]
 * }
 * }
 */
public class RestSiteContainerModelsCollection extends RestModels<RestSiteContainerModel, RestSiteContainerModelsCollection>
{
}    
