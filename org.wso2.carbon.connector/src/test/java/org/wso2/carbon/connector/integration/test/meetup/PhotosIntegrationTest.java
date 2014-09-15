package org.wso2.carbon.connector.integration.test.meetup;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wso2.carbon.connector.integration.test.common.ConnectorIntegrationUtil;

import javax.activation.DataHandler;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: E Ananthaneshan
 * Date: 9/11/14
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhotosIntegrationTest extends MeetupConnectorIntegrationTest {
    /**
     * Test getDiscussionBoards API operation for Mandatory fields.
     * Expecting Response header '200' and 'post_count' JSONObject in returned JSONArray.
     *
     * @throws Exception if test fails.
     */
    @Test(enabled = false, groups = {"wso2.esb"}, description = "Testing getNotifications API method")
    public void testPhotoCommentsMandatory() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "photos_getPhotoComments_mandatory.txt";
        String methodName = "photos_getPhotoComments";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);

            Assert.assertTrue(jsonObject.has("results"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

}