package org.wso2.carbon.connector.integration.test.meetup;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wso2.carbon.connector.integration.test.common.ConnectorIntegrationUtil;

import javax.activation.DataHandler;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: ananthaneshan
 * Date: 9/12/14
 * Time: 3:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class DashboardIntegrationTest extends MeetupConnectorIntegrationTest {
    /**
     * Test getDashboard API operation.
     * Expecting Response header '200' and 'results' JSONObject in returned JSONArray. A dashboard of aggregated Meetup information for the authorized member.
     *
     * @throws Exception if test fails.
     */
    @Test(enabled = false, groups = {"wso2.esb"}, description = "Test getDashboard API operation.")
    public void testGetDashboardMandatory() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "dashboard_getDashboard_mandatory.txt";
        String methodName = "dashboard_getDashboard";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("access_token"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));
        System.out.println(modifiedJsonString + "********************************************************************");
        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(jsonObject.has("status"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    /**
     * Test getDashboard API operation for negative scenario.
     * Expecting Response header '401' and 'errors' JSONObject in returned JSONArray. This operation does not require Authentication token.
     *
     * @throws Exception if test fails.
     */
    @Test(enabled = false, groups = {"wso2.esb"}, description = "Test getDashboard API operation for negative scenario.")
    public void testGetDashboardNegative() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "dashboard_getDashboard_negative.txt";
        String methodName = "dashboard_getDashboard";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue(responseHeader == 401);

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue(jsonObject.has("details"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }
}
