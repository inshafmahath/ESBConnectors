package org.wso2.carbon.connector.integration.test.meetup.events;

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
public class EventsIntegrationTest extends MeetupConnectorIntegrationTest {


    @Test(groups = { "wso2.esb" }, description = "meetup {getOpenEvents} integration test")
    public void testGetOpenEventsWithRequiredParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getOpenEvents_mandatory.txt";
        String methodName = "events_get_open_events";

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


    @Test(groups = { "wso2.esb" }, description = "meetup {getOpenEvents} integration test")
    public void testGetOpenEventsWithNegativeParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getOpenEvents_negative.txt";
        String methodName = "events_get_open_events";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString);
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 401);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    @Test(groups = { "wso2.esb" }, description = "meetup {getOpenEvents} integration test")
    public void testGetOpenEventsWithOptionalParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getOpenEvents_optional.txt";
        String methodName = "events_get_open_events";

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


    @Test(groups = { "wso2.esb" }, description = "meetup {getConcierge} integration test")
    public void testGetConciergeWithNegativeParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getConcierge_negative.txt";
        String methodName = "events_get_concierge";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));



        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 400);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    @Test(groups = { "wso2.esb" }, description = "meetup {getConcierge} integration test")
    public void testGetConciergeWithOptionalParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getConcierge_optional.txt";
        String methodName = "events_get_concierge";

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


    @Test(groups = { "wso2.esb" }, description = "meetup {getEvents} integration test")
    public void testGetEventsWithRequiredParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEvents_mandatory.txt";
        String methodName = "events_get_events";

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


    @Test(groups = { "wso2.esb" }, description = "meetup {getEvents} integration test")
    public void testGetEventsWithNegativeParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEvents_negative.txt";
        String methodName = "events_get_events";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString);
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 401);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    @Test(groups = { "wso2.esb" }, description = "meetup {getEvents} integration test")
    public void testGetEventsWithOptionalParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEvents_optional.txt";
        String methodName = "events_get_events";

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


    @Test(groups = { "wso2.esb" }, description = "meetup {getEventsByID} integration test")
    public void testGetEventsByIDWithRequiredParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEventsByID_mandatory.txt";
        String methodName = "events_get_event_by_id";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(jsonObject.has("visibility"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {getEventsByID} integration test")
    public void testGetEventsByIDWithNegativeParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEventsByID_negative.txt";
        String methodName = "events_get_event_by_id";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString);
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 401);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    @Test(groups = { "wso2.esb" }, description = "meetup {getEventsByID} integration test")
    public void testGetEventsByIDWithOptionalParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEventsByID_optional.txt";
        String methodName = "events_get_event_by_id";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(jsonObject.has("visibility"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {getEventComments} integration test")
    public void testGetEventCommentsWithRequiredParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEventsComments_mandatory.txt";
        String methodName = "events_get_event_comments";

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


    @Test(groups = { "wso2.esb" }, description = "meetup {getEventComments} integration test")
    public void testGetEventCommentsWithNegativeParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEventsComments_negative.txt";
        String methodName = "events_get_event_comments";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString);
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 401);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {getEventComments} integration test")
    public void testGetEventCommentsWithOptionalParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEventsComments_optional.txt";
        String methodName = "events_get_event_comments";

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


    @Test(groups = { "wso2.esb" }, description = "meetup {getEventCommentsByID} integration test")
    public void testGetEventCommentsByIDWithRequiredParameters() throws Exception   {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEventCommentByID_mandatory.txt";
        String methodName = "events_get_event_comment_by_id";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(jsonObject.has("time"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {getEventCommentsByID} integration test")
    public void testGetEventCommentsByIDWithNegativeParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEventCommentByID_negative.txt";
        String methodName = "events_get_event_comment_by_id";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString);
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 401);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {getEventCommentsByID} integration test")
    public void testGetEventCommentsByIDWithOptionalParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEventCommentByID_optional.txt";
        String methodName = "events_get_event_comment_by_id";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(jsonObject.has("time"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {getEventCommentLikes} integration test")
    public void testGetEventCommentLikesWithRequiredParameters() throws Exception   {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEventsCommentLikes_mandatory.txt";
        String methodName = "events_get_event_comment_likes";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            //System.out.println(jsonObject);
            Assert.assertTrue(jsonObject.has("results"));

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {getEventCommentLikes} integration test")
    public void testGetEventCommentLikesWithNegativeParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEventsCommentLikes_negative.txt";
        String methodName = "events_get_event_comment_likes";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString);
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 401);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {getEventRating} integration test")
    public void testGetEventRatingWithRequiredParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEventRating_mandatory.txt";
        String methodName = "events_get_event_rating";

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


    @Test(groups = { "wso2.esb" }, description = "meetup {getEventRating} integration test")
    public void testGetEventRatingWithNegativeParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEventRating_negative.txt";
        String methodName = "events_get_event_rating";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString);
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 401);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {getEventRating} integration test")
    public void testGetEventRatingWithOptionalParameters() throws Exception {

        //System.out.println("*************0");
        String jsonRequestFilePath = pathToRequestsDirectory + "events_getEventRating_optional.txt";
        String methodName = "events_get_event_rating";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
             System.out.println("*************1");
             JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
             System.out.println("*************2");

            Assert.assertTrue(jsonObject.has("results"));
            System.out.println("*************3");

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {postEventComments} integration test")
    public void testPostEventCommentsWithRequiredParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_postEventsComments_mandatory.txt";
        String methodName = "events_post_event_comments";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            String code = jsonObject.getString("code");
            System.out.println("code-"+code);
            Assert.assertEquals(code, "nonmember");

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {postEventComments} integration test")
    public void testPostEventCommentsWithNegativeParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_postEventsComments_negative.txt";
        String methodName = "events_post_event_comments";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString);
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 401);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {postEventComments} integration test")
    public void testPostEventCommentsWithOptionalParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_postEventsComments_optional.txt";
        String methodName = "events_post_event_comments";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            String code = jsonObject.getString("code");
            System.out.println("code-"+code);
            Assert.assertEquals(code, "nonmember");

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    @Test(groups = { "wso2.esb" }, description = "meetup {deleteEventCommentsByID} integration test")
    public void testDeleteEventCommentsByIDWithRequiredParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_deleteEventCommentsByID_mandatory.txt";
        String methodName = "events_delete_event_comments_by_id";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString,
                meetupConnectorProperties.getProperty("key"));
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            JSONObject jsonObject = ConnectorIntegrationUtil.sendRequest(getProxyServiceURL(methodName), modifiedJsonString);
            String code = jsonObject.getString("code");
            System.out.println("code-"+code);
            Assert.assertEquals(code, "not_authorized");

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    @Test(groups = { "wso2.esb" }, description = "meetup {deleteEventCommentsByID} integration test")
    public void testDeleteEventCommentsByIDWithNegativeParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "events_deleteEventCommentsByID_negative.txt";
        String methodName = "events_delete_event_comments_by_id";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory + methodName + ".xml";
        String modifiedJsonString = String.format(jsonString);
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {

            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 401);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


}
