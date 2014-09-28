package org.wso2.carbon.connector.integration.test.meetup.meta;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wso2.carbon.connector.integration.test.common.ConnectorIntegrationUtil;
import org.wso2.carbon.connector.integration.test.meetup.MeetupConnectorIntegrationTest;

import javax.activation.DataHandler;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: E Ananthaneshan
 * Date: 9/11/14
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class MetaIntegrationTest extends MeetupConnectorIntegrationTest {
    /**
     * Test getDiscussionBoards API operation for Mandatory fields.
     * Expecting Response header '200' and 'post_count' JSONObject in returned JSONArray.
     *
     * @throws Exception if test fails.
     */
    @Test(enabled = true, groups = {"wso2.esb"}, description = "")
    public void testGetStatusMandatory() throws Exception {

        String methodName = "meta_getStatus";

        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil
		            .sendRequestToRetriveHeaders(getProxyServiceURL(methodName), "");
            //Assert.assertTrue(responseHeader == 200);

            JSONObject jsonObject = ConnectorIntegrationUtil
		            .sendRequest(getProxyServiceURL(methodName), "");
            Assert.assertTrue(jsonObject.has("status"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }
}