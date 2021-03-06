package org.alfresco.rest.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.alfresco.rest.core.IRestModel;
import org.alfresco.rest.core.assertion.ModelAssertion;
import org.alfresco.utility.model.TestModel;

import java.util.List;

/**
 * Generated by 'gethin' on '2017-03-01 14:46' from 'Alfresco Search REST API' swagger file
 * Generated from 'Alfresco Search REST API' swagger file
 * Base Path {@linkplain /alfresco/api/-default-/public/search/versions/1}
 */
public class RestResultSetContextModel extends TestModel implements IRestModel<RestResultSetContextModel>
{
    @Override
    public ModelAssertion<RestResultSetContextModel> assertThat()
    {
        return new ModelAssertion<RestResultSetContextModel>(this);
    }

    @Override
    public ModelAssertion<RestResultSetContextModel> and()
    {
        return assertThat();
    }

    @JsonProperty(value = "entry")
    RestResultSetContextModel model;

    @Override
    public RestResultSetContextModel onModel()
    {
        return model;
    }


    private RestResponseConsistencyModel consistency;	    
    /**
    The counts from facet queries
    */	        

    private List<FacetFieldBucket> facetQueries;
    /**
    The counts from field facets
    */	        

    private List<RestResultBucketsModel> facetsFields;
    /**
    The counts from facet intervals
    */

    private List<RestGenericFacetResponseModel> facets;
    /**
    Suggested corrections

If zero results were found for the original query then a single entry of type "searchInsteadFor" will be returned.
If alternatives were found that return more results than the original query they are returned as "didYouMean" options.
The highest quality suggestion is first.

    */	        

    private SpellCheckModel spellCheck;
    
    private SearchRequest request;

    public RestResponseConsistencyModel getConsistency()
    {
        return this.consistency;
    }

    public void setConsistency(RestResponseConsistencyModel consistency)
    {
        this.consistency = consistency;
    }				

    public List<FacetFieldBucket> getFacetQueries()
    {
        return this.facetQueries;
    }

    public void setFacetQueries(List<FacetFieldBucket> facetQueries)
    {
        this.facetQueries = facetQueries;
    }				

    public List<RestResultBucketsModel> getFacetsFields()
    {
        return this.facetsFields;
    }

    public void setFacetsFields(List<RestResultBucketsModel> facetsFields)
    {
        this.facetsFields = facetsFields;
    }

    public List<RestGenericFacetResponseModel> getFacets()
    {
        return this.facets;
    }

    public void setFacets(List<RestGenericFacetResponseModel> facets)
    {
        this.facets = facets;
    }

    public SpellCheckModel getSpellCheck()
    {
        return this.spellCheck;
    }

    public void setSpellCheck(SpellCheckModel spellCheck)
    {
        this.spellCheck = spellCheck;
    }

    public SearchRequest getRequest()
    {
        return request;
    }

    public void setRequest(SearchRequest request)
    {
        this.request = request;
    }
}
 
