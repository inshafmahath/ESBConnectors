package org.wso2.carbon.connector.integration.test.meetup.members;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wso2.carbon.connector.integration.test.common.ConnectorIntegrationUtil;
import org.wso2.carbon.connector.integration.test.meetup.MeetupConnectorIntegrationTest;

import javax.activation.DataHandler;
import java.net.URL;

/**
 */
public class MemberIntegrationTest extends MeetupConnectorIntegrationTest {


    //**************************************       MEMBERS      *********************************************************//


    //    //mantatory parameters test for find meetup_members by id

    @Test(enabled = true, groups = {"wso2.esb"}, description = "meetup {getmember_byid} integration test")
    public void testgetmember_byidMandatory() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getmember_byid-mandatory.txt";
        String methodName = "meetup_getmember_byid";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"),
                meetupConnectorProperties.getProperty("id")


        );
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);
            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(jsonObject.has("lon"));
            System.out.println("--------------@@@@@@@@---------");



        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    // ...................................negative test case for  getmember_byid ...............................................


    @Test(enabled = true, groups = {"wso2.esb"}, description = "meetup {fetchgroups}  integration test for negative scenario.")
    public void testgetmember_byidNegative() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getmember_byid_negative.txt";
        String methodName = "meetup_getmember_byid";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue (responseHeader == 400);

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue(jsonObject.has("details"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    //    //mantatory parameters test for find meetup_members

    @Test(enabled = true, groups = {"wso2.esb"}, description = "meetup {getmembers} integration test")
    public void testgetmembersMandatory() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getmembers_mandatory.txt";
        String methodName = "meetup_getmembers";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"),
                meetupConnectorProperties.getProperty("group_id"),
                meetupConnectorProperties.getProperty("group_urlname"),
                meetupConnectorProperties.getProperty("service"),
                meetupConnectorProperties.getProperty("member_id"),
                meetupConnectorProperties.getProperty("topic"),
                meetupConnectorProperties.getProperty("groupnum")


        );
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);
            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(jsonObject.has("results"));
            System.out.println("--------------@@@@@@@@---------");



        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    // ...................................negative test case for  getmembers ...............................................


    @Test(enabled = true, groups = {"wso2.esb"}, description = "meetup {getmembers}  integration test for negative scenario.")
    public void testgetmembersNegative() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getmembers_negative.txt";
        String methodName = "meetup_getmembers";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue((responseHeader == 401) || (responseHeader == 400) || (responseHeader == 404));

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), jsonString);
            // Assert.assertTrue(jsonObject.has("errors"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }



    //    / ................................ mantatory parameters test for delete_member_photo  ........... to be finished...........

    @Test(enabled = false, groups = {"wso2.esb"}, description = "meetup {delete_member_photo} integration test")
    public void testdelete_member_photoMandatory() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "delete_member_photo_mandatory.txt";
        String methodName = "meetup_delete_member_photo";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"),

                meetupConnectorProperties.getProperty("id")



        );
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 401);
            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(jsonObject.has("problem"));



        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    // ...................................negative test case for  delete_member_photo .......     to be finished  ........................................


    @Test(enabled = false, groups = {"wso2.esb"}, description = "meetup {delete_member_photo}  integration test for negative scenario.")
    public void testdelete_member_photoNegative() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "delete_member_photo_negative.txt";
        String methodName = "meetup_delete_member_photo";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue((responseHeader == 401));

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), jsonString);
            // Assert.assertTrue(jsonObject.has("errors"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }





    //    //mantatory parameters test for edit meetup_members.....  test ...........................................

    @Test(enabled = false, groups = {"wso2.esb"}, description = "meetup {edit_member} integration test")
    public void testedit_memberMandatory() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "edit_member_mandatory.txt";
        String methodName = "meetup_edit_member";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"),

                meetupConnectorProperties.getProperty("member_id"),

                meetupConnectorProperties.getProperty("bio"),
                meetupConnectorProperties.getProperty("birthday")





        );
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);
            //JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            //Assert.assertTrue(jsonObject.has("problem"));


        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


// ...................................negative test case for  edit meetup_members ...............................................


    @Test(enabled = false, groups = {"wso2.esb"}, description = "meetup {edit_member}  integration test for negative scenario.")
    public void testedit_memberNegative() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "edit_member_negative.txt";
        String methodName = "meetup_edit_member";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue (responseHeader == 404);

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), jsonString);
            Assert.assertTrue(jsonObject.has("details"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }








}
