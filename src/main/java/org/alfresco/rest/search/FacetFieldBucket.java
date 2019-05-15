/*
 * Copyright (C) 2017 Alfresco Software Limited.
 *
 * This file is part of Alfresco
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
 */
package org.alfresco.rest.search;

import org.alfresco.rest.core.IRestModel;
import org.alfresco.rest.core.assertion.ModelAssertion;
import org.alfresco.utility.model.TestModel;

/**
 * Pojo to represent facet field bucket response.
 *         {"count":1,"label":"small"},
 **/
public class FacetFieldBucket extends TestModel implements IRestModel<FacetFieldBucket>
{
    
    private String  label;
    private String  display;
    private String filterQuery;
    private int  count;
    
    
    public FacetFieldBucket() {}

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getDisplay()
    {
        return display;
    }

    public void setDisplay(String display)
    {
        this.display = display;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public String getFilterQuery()
    {
        return filterQuery;
    }

    public void setFilterQuery(String filterQuery)
    {
        this.filterQuery = filterQuery;
    }

    @Override
    public ModelAssertion<FacetFieldBucket> and()
    {
        return assertThat();
    }

    @Override
    public ModelAssertion<FacetFieldBucket> assertThat()
    {
        return new ModelAssertion<FacetFieldBucket>(this);
    }

    @Override
    public FacetFieldBucket onModel()
    {
        // TODO Auto-generated method stub
        return null;
    }


}
