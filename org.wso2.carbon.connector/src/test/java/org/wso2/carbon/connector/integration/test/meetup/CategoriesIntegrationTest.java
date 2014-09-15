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
 * Date: 9/12/14
 * Time: 1:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class CategoriesIntegrationTest extends MeetupConnectorIntegrationTest {
    /**
     * Test getCategories API operation.
     * Expecting Response header '200' and 'id' JSONObject in returned JSONArray.
     *
     * @throws Exception if test fails.
     */
    @Test(enabled = false, groups = {"wso2.esb"}, description = "Test getCategories API operation.")
    public void testGetCategoriesMandatory() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "categories_getCategories_mandatory.txt";
        String methodName = "categories_getCategories";

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
            Assert.assertTrue(jsonObject.has("results"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    /**
     * Test getCategories API operation for negative scenario.
     * Expecting Response header '401' and 'details' JSONObject in returned JSONArray.
     *
     * @throws Exception if test fails.
     */
    @Test(enabled = false, groups = {"wso2.esb"}, description = "Test getCategories API operation.")
    public void testGetCategoriesNegative() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "categories_getCategories_negative.txt";
        String methodName = "categories_getCategories";

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
