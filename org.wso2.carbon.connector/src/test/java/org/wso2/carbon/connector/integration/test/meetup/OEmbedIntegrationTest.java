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
 * User: E Ananthaneshan
 * Date: 9/11/14
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class OEmbedIntegrationTest extends MeetupConnectorIntegrationTest {
    /**
     * Test getDiscussionBoards API operation for Mandatory fields.
     * Expecting Response header '200' and 'post_count' JSONObject in returned JSONArray.
     *
     * @throws Exception if test fails.
     */
    @Test(enabled = false, groups = {"wso2.esb"}, description = "Testing getNotifications API method")
    public void testOEmbedMandatory() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "oembed_getOEmbed_mandatory.txt";
        String methodName = "oembed_getOEmbed";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue(responseHeader == 200);

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), jsonString);

            Assert.assertTrue(jsonObject.has("title"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

}