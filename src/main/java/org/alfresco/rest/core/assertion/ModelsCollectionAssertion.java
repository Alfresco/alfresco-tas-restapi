package org.alfresco.rest.core.assertion;

import static org.alfresco.utility.report.log.Step.STEP;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.alfresco.rest.core.IRestModelsCollection;
import org.alfresco.utility.exception.TestConfigurationException;
import org.alfresco.utility.model.Model;
import org.apache.commons.beanutils.BeanUtils;
import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Ordering;
import io.restassured.path.json.JsonPath;

/**
 * Assertion on Rest Model Collection
 * Just pass your rest model collection as constructor
 * 
 * @author Paul Brodner
 */
public class ModelsCollectionAssertion<C> 
{
  @SuppressWarnings("rawtypes")
  private IRestModelsCollection modelCollection;

  @SuppressWarnings("rawtypes")
  public ModelsCollectionAssertion(IRestModelsCollection modelCollection) 
  {
    this.modelCollection = modelCollection;
  }

  /**
   * check if "entries" list from JSON is not empty
   */
  @SuppressWarnings("unchecked")
  public C entriesListIsNotEmpty() 
  {
    STEP("REST API: Assert that entries list from response is not empty");
    Assert.assertFalse(modelCollection.isEmpty(), "Entries list from response is empty.Check the logs for more details!");
    return (C) modelCollection;
  }

  /**
   * check if "entries" list from JSON is empty
   */
  @SuppressWarnings("unchecked")
  public C entriesListIsEmpty() 
  {
    STEP("REST API: Assert that entries list from response is empty");
    Assert.assertTrue(modelCollection.isEmpty(), "Entries list from response is not empty.Check the logs for more details!");
    return (C) modelCollection;
  }

  @SuppressWarnings("unchecked")
  public C entriesListCountIs(int expectedCount)
  {
      STEP(String.format("REST API: Assert that entries list count is %d", expectedCount));
      int actualSize = modelCollection.getEntries().size();
      Assert.assertEquals(actualSize, expectedCount);
      return (C) modelCollection;
  }
  
  @SuppressWarnings("unchecked")
  public C entriesListContains(String key, String value) throws Exception 
  {    
    List<Model> modelEntries = modelCollection.getEntries();
    String fieldValue = "";
    for (Model m : modelEntries) {
      Method method = m.getClass().getMethod("onModel", new Class[] {});
      Object model = method.invoke(m, new Object[] {});
      try {
          ObjectMapper mapper = new ObjectMapper();
          String jsonInString = mapper.writeValueAsString(model);
          fieldValue = JsonPath.with(jsonInString).get(key);
         if (fieldValue != null && fieldValue.equals(value)) {
                 break;
         }
      } catch (Exception e) {
        throw new TestConfigurationException(String.format(
            "You try to assert field [%s] that doesn't exist in class: [%s]. Exception: %s, Please check your code!",
            key, getClass().getCanonicalName(), e.getMessage()));
      }
    }
    Assert.assertEquals(fieldValue, value, String.format("Entry with key: [%s] with value [%s] not found in list", key, value));
  

    return (C) modelCollection;
  }

  @SuppressWarnings("unchecked")
  public C entriesListDoesNotContain(String key, String value) throws Exception 
  {
    boolean exist = false;
    List<Model> modelEntries = modelCollection.getEntries();
    for (Model m : modelEntries) {
      Method method = m.getClass().getMethod("onModel", new Class[] {});
      Object model = method.invoke(m, new Object[] {});
      String fieldValue = "";
      try {
          ObjectMapper mapper = new ObjectMapper();
          String jsonInString = mapper.writeValueAsString(model);
          fieldValue = JsonPath.with(jsonInString).get(key);
        if (fieldValue != null && fieldValue.equals(value)) {
          exist = true;
          break;
        }
      } catch (Exception e) {
        // nothing to do
      }
    }
    Assert.assertFalse(exist,
        String.format("Entry with key: %s and value %s was found in list", key, value));

    return (C) modelCollection;
  }
  
  @SuppressWarnings("unchecked")
  public C entriesListDoesNotContain(String key) throws Exception 
  {
    boolean exist = false;
    List<Model> modelEntries = modelCollection.getEntries();
    for (Model m : modelEntries) {
      Method method = m.getClass().getMethod("onModel", new Class[] {});
      Object model = method.invoke(m, new Object[] {});
      String fieldValue = "";
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = mapper.writeValueAsString(model);
      fieldValue = JsonPath.with(jsonInString).get(key);
      if (fieldValue != null) {
          exist = true;
          break;
      }
    }
    Assert.assertFalse(exist,
        String.format("Entry list contains key: %s", key));

    return (C) modelCollection;
  }
  
  @SuppressWarnings("unchecked")
  public C entriesListContains(String key) throws Exception 
  {
    boolean exist = false;
    List<Model> modelEntries = modelCollection.getEntries();
    for (Model m : modelEntries) {
      Method method = m.getClass().getMethod("onModel", new Class[] {});
      Object model = method.invoke(m, new Object[] {});
      Object fieldValue = null;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = mapper.writeValueAsString(model);
      fieldValue = JsonPath.with(jsonInString).get(key);
      if (fieldValue != null) {
          exist = true;
          break;
      }
    }
    Assert.assertTrue(exist,
        String.format("Entry list doesn't contain key: %s", key));

    return (C) modelCollection;
  }

  @SuppressWarnings("unchecked")
  public C paginationExist() 
  {
    STEP("REST API: Assert that response has pagination");
    Assert.assertNotNull(modelCollection.getPagination(), "Pagination is was not found in the response");
    return (C) modelCollection;
  }

  /**
   * Check one field from pagination json body
   * 
   * @param field
   * @return
   */  
  @SuppressWarnings("rawtypes")
  public PaginationAssertionVerbs paginationField(String field) 
  {
    return new PaginationAssertionVerbs<C>(modelCollection, field, modelCollection.getPagination());
  }
  
  /**
   * check is the entries are ordered ASC by a specific field
   * 
   * @param field from json response
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public C entriesListIsSortedAscBy(String field) throws Exception
  {
      List<Model> modelEntries = modelCollection.getEntries();
      List<String> fieldValues = new ArrayList<String>();
      for(Model m: modelEntries)
      {
          Method method = m.getClass().getMethod("onModel", new Class[] {});
          Object model = method.invoke(m, new Object[] {});
          String fieldValue = "";
          try {
              fieldValue = BeanUtils.getProperty(model, field);
              fieldValues.add(fieldValue);
          } 
          catch (Exception e) 
          {
              // nothing to do
          }    
      } 
      Assert.assertTrue(Ordering.natural().isOrdered(fieldValues), String.format("Entries are not ordered ASC by %s", field));
      return (C) modelCollection;
  }
  
  /**
   * check is the entries are ordered DESC by a specific field
   * 
   * @param field from json response
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public C entriesListIsSortedDescBy(String field) throws Exception
  {
      List<Model> modelEntries = modelCollection.getEntries();
      List<String> fieldValues = new ArrayList<String>();
      for(Model m: modelEntries)
      {
          Method method = m.getClass().getMethod("onModel", new Class[] {});
          Object model = method.invoke(m, new Object[] {});
          String fieldValue = "";
          try {
              fieldValue = BeanUtils.getProperty(model, field);
              fieldValues.add(fieldValue);
          } 
          catch (Exception e) 
          {
              // nothing to do
          }    
      } 
      Assert.assertTrue(Ordering.natural().reverse().isOrdered(fieldValues), String.format("Entries are not ordered DESC by %s", field));
      return (C) modelCollection;
  }
}
