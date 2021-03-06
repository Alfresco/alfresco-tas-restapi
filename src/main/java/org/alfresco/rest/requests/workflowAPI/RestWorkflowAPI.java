package org.alfresco.rest.requests.workflowAPI;

import javax.json.JsonObject;

import org.alfresco.dataprep.CMISUtil.Priority;
import org.alfresco.rest.core.RestWrapper;
import org.alfresco.rest.model.RestDeploymentModel;
import org.alfresco.rest.model.RestDeploymentModelsCollection;
import org.alfresco.rest.model.RestProcessDefinitionModel;
import org.alfresco.rest.model.RestProcessDefinitionModelsCollection;
import org.alfresco.rest.model.RestProcessModel;
import org.alfresco.rest.model.RestProcessModelsCollection;
import org.alfresco.rest.model.RestTaskModelsCollection;
import org.alfresco.rest.requests.Deployments;
import org.alfresco.rest.requests.ModelRequest;
import org.alfresco.rest.requests.ProcessDefinitions;
import org.alfresco.rest.requests.Processes;
import org.alfresco.rest.requests.Task;
import org.alfresco.utility.model.ProcessModel;
import org.alfresco.utility.model.TaskModel;
import org.alfresco.utility.model.UserModel;

import io.restassured.RestAssured;

/**
 * Defines the entire Rest Workflow API
 * {@link https://api-explorer.alfresco.com/api-explorer/} select "Workflow API"
 */
public class RestWorkflowAPI extends ModelRequest<RestWorkflowAPI>
{
    public RestWorkflowAPI(RestWrapper restWrapper)
    {
        super(restWrapper);
        RestAssured.basePath = "alfresco/api/-default-/public/workflow/versions/1";
        restWrapper.configureRequestSpec().setBasePath(RestAssured.basePath);
    }

    /**
     * Provides DSL on all REST calls under <code>/processes/{processId}/...</code> API path
     * 
     * @return {@link RestProcessModel}
     */
    public RestProcessModel addProcess(String processDefinitionKey, UserModel assignee, boolean sendEmailNotifications, Priority priority) throws Exception
    {
        return new Processes(restWrapper).addProcess(processDefinitionKey, assignee, sendEmailNotifications, priority);
    }
    
    /**
     * Provides DSL on all REST calls under <code>/processes/{processId}/...</code> API path
     * 
     * @return {@link RestProcessModel}
     */
    public RestProcessModel addProcessWithBody(JsonObject postBody) throws Exception
    {
        return new Processes(restWrapper).addProcessWithBody(postBody.toString());
    }

    /**
     * Provides DSL on all REST calls under <code>/tasks/{taskId}/...</code> API path
     * 
     * @return {@link Task}
     */
    public Task usingTask(TaskModel task)
    {
        return new Task(restWrapper, task);
    }

    /**
     * Provides get all process <code>/processes</code>of current user logged in
     * 
     * @return {@link RestProcessModelsCollection}
     */
    public RestProcessModelsCollection getProcesses() throws Exception
    {
        return new Processes(restWrapper).getProcesses();
    }

    /**
     * Provides all deployments of current user logged in
     * 
     * @return {@link RestDeploymentModelsCollection}
     */
    public RestDeploymentModelsCollection getDeployments() throws Exception
    {
        return new Deployments(restWrapper).getDeployments();
    }

    /**
     * Provides DSL on all REST calls under <code>/deployments/{deploymentID}</code> API path
     * 
     * @return {@link Deployments}
     */
    public Deployments usingDeployment(RestDeploymentModel deployment)
    {
        return new Deployments(deployment, restWrapper);
    }

    /**
     * Provides all ProcessDefinitions of current user logged in
     * 
     * @return {@link RestProcessDefinitionModelsCollection}
     */
    public RestProcessDefinitionModelsCollection getAllProcessDefinitions() throws Exception
    {
        return new ProcessDefinitions(restWrapper).getAllProcessDefinitions();
    }

    /**
     * Provides DSL on all REST calls under <code>/process-definition/{processDefinitionID}<code> API path
     * 
     * @return {@link ProcessDefinitions}
     */
    public ProcessDefinitions usingProcessDefinitions(RestProcessDefinitionModel processDefinition)
    {
        return new ProcessDefinitions(processDefinition, restWrapper);
    }

    /**
     * Provides DSL on all REST calls under <code>/process-definition/{processDefinitionID}</code> API path
     * 
     * @return {@link Processes}
     */
    public Processes usingProcess(ProcessModel processModel) throws Exception
    {
        return new Processes(processModel, restWrapper);
    }

    /**
     * Provides all tasks of the current user
     * 
     * @return {@link RestTaskModelsCollection}
     */
    public RestTaskModelsCollection getTasks() throws Exception
    {
        return new Task(restWrapper, null).getTasks();
    }
}