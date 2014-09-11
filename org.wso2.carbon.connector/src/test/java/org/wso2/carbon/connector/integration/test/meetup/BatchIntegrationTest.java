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
public class BatchIntegrationTest extends MeetupConnectorIntegrationTest {
    @Test(groups = { "wso2.esb" }, description = "meetup {batchRequests} integration test")
    public void testMeetupBatchRequests() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "batchRequests_mandatory.txt";
        String methodName = "meetup_batch_requests";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("access_token"),
                meetupConnectorProperties.getProperty("requests")
        );
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

            JSONArray jsonArray = ConnectorIntegrationUtil.sendRequestJSONArray(getProxyServiceURL(methodName), modifiedJsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            Assert.assertTrue(jsonObject.has("status"));
            Assert.assertTrue(jsonObject.getInt("status")==200);
            //System.out.println("--------------@@@@@@@@---------");
            //System.out.println(jsonObject);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }
}
