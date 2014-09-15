package org.wso2.carbon.connector.integration.test.meetup.topics;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wso2.carbon.connector.integration.test.common.ConnectorIntegrationUtil;
import org.wso2.carbon.connector.integration.test.meetup.MeetupConnectorIntegrationTest;

import javax.activation.DataHandler;
import java.net.URL;

/**
 * Created by inshaf on 9/11/14.
 */
public class TopicsIntegrationTest extends MeetupConnectorIntegrationTest {




    @Test(groups = { "wso2.esb" }, description = "meetup {getTopics} integration test")
    public void testGetTopicsWithNegativeParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "topics_getTopics_negative.txt";
        String methodName = "topics_get_topics";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString);
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 401);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    @Test(groups = { "wso2.esb" }, description = "meetup {getTopics} integration test")
    public void testGetTopicsWithOptionalParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "topics_getTopics_optional.txt";
        String methodName = "topics_get_topics";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(jsonObject.has("results"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {getTopicCategories} integration test")
    public void testGetTopicCategoriesWithNegativeParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "topics_getTopicCategories_negative.txt";
        String methodName = "topics_get_topic_categories";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));



        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 401);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {getTopicCategories} integration test")
    public void testGetTopicCategoriesWithOptionalParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "topics_getTopicCategories_optional.txt";
        String methodName = "topics_get_topic_categories";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(jsonObject.has("results"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {getRecommendGroupTopics} integration test")
    public void testGetRecommendGroupTopicsWithRequiredParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "topics_getRecommendGroupTopics_mandatory.txt";
        String methodName = "topics_get_recommended_group_topics";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            JSONArray jsonObjectArray = ConnectorIntegrationUtil.sendRequestJSONArray(getProxyServiceURL(methodName), modifiedJsonString);
            JSONObject jsonObject = (JSONObject) jsonObjectArray.get(0);
            Assert.assertTrue(jsonObject.has("id"));

            //JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            //Assert.assertTrue(jsonObject.has("id"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {getRecommendGroupTopics} integration test")
    public void testGetRecommendGroupTopicsWithNegativeParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "topics_getRecommendGroupTopics_negative.txt";
        String methodName = "topics_get_recommended_group_topics";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString);
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 401);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {getRecommendGroupTopics} integration test")
    public void testGetRecommendGroupTopicsWithOptionalParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "topics_getRecommendGroupTopics_optional.txt";
        String methodName = "topics_get_recommended_group_topics";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            JSONArray jsonObjectArray = ConnectorIntegrationUtil.sendRequestJSONArray(getProxyServiceURL(methodName), modifiedJsonString);
            JSONObject jsonObject = (JSONObject) jsonObjectArray.get(0);
            Assert.assertTrue(jsonObject.has("id"));
            //JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
           // Assert.assertTrue(jsonObject.has("id"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }




}
