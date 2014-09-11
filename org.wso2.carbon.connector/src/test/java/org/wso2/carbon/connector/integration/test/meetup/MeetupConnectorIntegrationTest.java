/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.carbon.connector.integration.test.meetup;

import org.apache.axis2.context.ConfigurationContext;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.carbon.automation.api.clients.proxy.admin.ProxyServiceAdminClient;
import org.wso2.carbon.automation.api.clients.utils.AuthenticateStub;
import org.wso2.carbon.automation.utils.axis2client.ConfigurationContextProvider;
import org.wso2.carbon.connector.integration.test.common.ConnectorIntegrationUtil;
import org.wso2.carbon.esb.ESBIntegrationTest;
import org.wso2.carbon.mediation.library.stub.MediationLibraryAdminServiceStub;
import org.wso2.carbon.mediation.library.stub.upload.MediationLibraryUploaderStub;

import javax.activation.DataHandler;
import java.net.URL;
import java.util.Properties;

public class MeetupConnectorIntegrationTest extends ESBIntegrationTest {


    protected static final String CONNECTOR_NAME = "meetup";

    protected MediationLibraryUploaderStub mediationLibUploadStub;

    protected MediationLibraryAdminServiceStub adminServiceStub;

    protected ProxyServiceAdminClient proxyAdmin;

    protected String repoLocation;

    protected String meetupConnectorFileName = CONNECTOR_NAME + ".zip";

    protected Properties meetupConnectorProperties;

    protected String pathToProxiesDirectory;

    protected String pathToRequestsDirectory;


    @BeforeClass(alwaysRun = true)
    public void setEnvironment() throws Exception {

        super.init();

        ConfigurationContextProvider configurationContextProvider = ConfigurationContextProvider.getInstance();
        ConfigurationContext cc = configurationContextProvider.getConfigurationContext();
        mediationLibUploadStub =
                new MediationLibraryUploaderStub(cc, esbServer.getBackEndUrl() + "MediationLibraryUploader");
        AuthenticateStub.authenticateStub("admin", "admin", mediationLibUploadStub);

        adminServiceStub =
                new MediationLibraryAdminServiceStub(cc, esbServer.getBackEndUrl() + "MediationLibraryAdminService");

        AuthenticateStub.authenticateStub("admin", "admin", adminServiceStub);

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            repoLocation = System.getProperty("connector_repo").replace("/", "\\");
        } else {
            repoLocation = System.getProperty("connector_repo").replace("/", "/");
        }
        proxyAdmin = new ProxyServiceAdminClient(esbServer.getBackEndUrl(), esbServer.getSessionCookie());

        ConnectorIntegrationUtil.uploadConnector(repoLocation, mediationLibUploadStub, meetupConnectorFileName);
        log.info("Sleeping for " + 15000 / 1000 + " seconds while waiting for synapse import");
        Thread.sleep(15000);

        adminServiceStub.updateStatus("{org.wso2.carbon.connector}" + CONNECTOR_NAME, CONNECTOR_NAME,
                "org.wso2.carbon.connector", "enabled");

        meetupConnectorProperties = ConnectorIntegrationUtil.getConnectorConfigProperties(CONNECTOR_NAME);

        pathToProxiesDirectory = repoLocation + meetupConnectorProperties.getProperty("proxyDirectoryRelativePath");
        pathToRequestsDirectory = repoLocation + meetupConnectorProperties.getProperty("requestDirectoryRelativePath");

    }

    @Override
    protected void cleanup() throws Exception {
        axis2Client.destroy();
    }


    @Test(enabled = false, groups = { "wso2.esb" }, description = "meetup {getOpenEvents} integration test")
    public void testGetOpenEventsWithRequiredParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getOpenEvents_mandatory.txt";
        String methodName = "meetup_get_open_events";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
               meetupConnectorProperties.getProperty("key"),
//                meetupConnectorProperties.getProperty("category"),
//                meetupConnectorProperties.getProperty("city"),
//                meetupConnectorProperties.getProperty("country"),
//                meetupConnectorProperties.getProperty("lat"),
//                meetupConnectorProperties.getProperty("lon"),
//                meetupConnectorProperties.getProperty("state"),
//                meetupConnectorProperties.getProperty("text"),
//                meetupConnectorProperties.getProperty("topic"),
                meetupConnectorProperties.getProperty("zip")
                );
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            //int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            //Assert.assertTrue(responseHeader == 200);
            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            //Assert.assertTrue(jsonObject.has("results"));
            //System.out.println("--------------@@@@@@@@---------");
            //System.out.println(jsonObject);

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);

            Assert.assertTrue(responseHeader == 200);



        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

}
