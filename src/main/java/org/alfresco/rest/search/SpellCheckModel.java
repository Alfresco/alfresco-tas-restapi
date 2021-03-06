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

import java.util.List;

import org.alfresco.rest.core.IRestModel;
import org.alfresco.rest.core.assertion.ModelAssertion;
import org.alfresco.utility.model.TestModel;
/**
 * Object that represents the spell check model response.
 * @author Michael Suzuki
 *
 */
public class SpellCheckModel extends TestModel implements IRestModel<SpellCheckModel>
{
    
    private String type;
    
    private List<String> suggestions;

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public List<String> getSuggestions()
    {
        return suggestions;
    }

    public void setSuggestions(List<String> suggestions)
    {
        this.suggestions = suggestions;
    }

    @Override
    public ModelAssertion<SpellCheckModel> and()
    {
        return assertThat();
    }

    @Override
    public ModelAssertion<SpellCheckModel> assertThat()
    {
        return new ModelAssertion<SpellCheckModel>(this);
    }

    @Override
    public SpellCheckModel onModel()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
