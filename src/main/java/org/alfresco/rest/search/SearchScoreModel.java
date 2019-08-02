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

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Object that represents the search score.
 * @author Michael Suzuki
 *
 */
public class SearchScoreModel extends TestModel implements IRestModel<SearchScoreModel>
{
    
    @JsonProperty(required = true)
    private float score;
    
    private List<ResponseHighLightModel> highlight;

    public float getScore()
    {
        return score;
    }

    public void setScore(float score)
    {
        this.score = score;
    }

    @Override
    public ModelAssertion<SearchScoreModel> and()
    {
        return assertThat();
    }

    @Override
    public ModelAssertion<SearchScoreModel> assertThat()
    {
        return new ModelAssertion<SearchScoreModel>(this);
    }

    @Override
    public SearchScoreModel onModel()
    {
        return this;
    }

    public List<ResponseHighLightModel> getHighlight()
    {
        return highlight;
    }

    public void setHighlight(List<ResponseHighLightModel> highlight)
    {
        this.highlight = highlight;
    }

}
