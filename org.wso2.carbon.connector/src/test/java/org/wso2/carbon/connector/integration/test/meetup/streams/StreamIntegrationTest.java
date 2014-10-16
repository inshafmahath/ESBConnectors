package org.wso2.carbon.connector.integration.test.meetup.streams;

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
public class StreamIntegrationTest extends MeetupConnectorIntegrationTest {




    @Test(enabled = false, groups = { "wso2.esb" }, description = "meetup {getStreamOpenEvents} integration test")
    public void testStreamGetOpenVenuesWithOptionalParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "streams_get_open_venues_optional.txt";
        String methodName = "streams_get_open_venues";

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


}
