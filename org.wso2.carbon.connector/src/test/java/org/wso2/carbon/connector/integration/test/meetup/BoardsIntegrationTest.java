package org.wso2.carbon.connector.integration.test.meetup;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wso2.carbon.connector.integration.test.common.ConnectorIntegrationUtil;

import javax.activation.DataHandler;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: ananthaneshan
 * Date: 9/11/14
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class BoardsIntegrationTest extends MeetupConnectorIntegrationTest {
    /**
     * Test getDiscussionBoards API operation for Mandatory fields.
     * Expecting Response header '200' and 'post_count' JSONObject in returned JSONArray.
     *
     * @throws Exception if test fails.
     */
    @Test(enabled = false, groups = {"wso2.esb"}, description = "Boards's getDiscussionBoards operation integration test for Mandatory fields")
    public void testGetDiscussionBoardsMandatory() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "boards_getDiscussionBoards_mandatory.txt";
        String methodName = "boards_getBoard";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("access_token"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

            JSONArray jsonArray = ConnectorIntegrationUtil.sendRequestJSONArray(getProxyServiceURL(methodName), modifiedJsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            Assert.assertTrue(jsonObject.has("post_count"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    /**
     * Test getDiscussionBoards API operation for negative scenario.
     * Expecting '401' request header and 'errors' element in returned JSONObject.
     *
     * @throws Exception if test fails.
     */
    @Test(enabled = false, groups = {"wso2.esb"}, description = "Board's getDiscussionBoards operation integration test for negative scenario.")
    public void testGetDiscussionBoardsNegative() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "boards_getDiscussionBoards_negative.txt";
        String methodName = "boards_getBoard";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        /*String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("access_token"),
                meetupConnectorProperties.getProperty("urlname")
        );*/
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue(responseHeader == 401);

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue(jsonObject.has("errors"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    /**
     * Test getDiscussions API operation for Mandatory fields.
     * Expecting Response header '200' and 'id' JSONObject in returned JSONArray.
     *
     * @throws Exception if test fails.
     */
    @Test(enabled = false, groups = {"wso2.esb"}, description = "Board's getDiscussions operation integration test for Mandatory fields")
    public void testGetDiscussionsMandatory() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "boards_getDiscussions_mandatory.txt";
        String methodName = "boards_getDiscussions";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("access_token"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

            JSONArray jsonArray = ConnectorIntegrationUtil.sendRequestJSONArray(getProxyServiceURL(methodName), modifiedJsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            Assert.assertTrue(jsonObject.has("id"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    /**
     * Test getDiscussions API operation for negative scenario.
     * Expecting Response header '401' and 'errors' JSONObject in returned JSONArray.
     *
     * @throws Exception if test fails.
     */
    @Test(enabled = false, groups = {"wso2.esb"}, description = "Board's getDiscussions operation integration test for negative scenario")
    public void testGetDiscussionsNegative() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "boards_getDiscussions_negative.txt";
        String methodName = "boards_getDiscussions";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        /*String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("access_token"));*/
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue(responseHeader == 401);

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue(jsonObject.has("errors"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    /**
     * Test getDiscussionPosts API operation for Mandatory fields.
     * Expecting Response header '200' and 'id' JSONObject in returned JSONArray.
     *
     * @throws Exception if test fails.
     */
    @Test(enabled = false, groups = {"wso2.esb"}, description = "Board's getDiscussionPosts operation integration test for Mandatory fields")
    public void testGetDiscussionPostsMandatory() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "boards_getDiscussionPosts_mandatory.txt";
        String methodName = "boards_getDiscussionPosts";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("access_token"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

            JSONArray jsonArray = ConnectorIntegrationUtil.sendRequestJSONArray(getProxyServiceURL(methodName), modifiedJsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            Assert.assertTrue(jsonObject.has("id"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    /**
     * Test getDiscussionPosts API operation for negative scenario.
     * Expecting Response header '401' and 'errors' JSONObject in returned JSONArray.
     *
     * @throws Exception if test fails.
     */
    @Test(enabled = false, groups = {"wso2.esb"}, description = "Board's getDiscussionPosts operation integration test for negative scenario")
    public void testGetDiscussionPostsNegative() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "boards_getDiscussionPosts_negative.txt";
        String methodName = "boards_getDiscussionPosts";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        /*String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("access_token"));*/
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue(responseHeader == 401);

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue(jsonObject.has("errors"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }
}