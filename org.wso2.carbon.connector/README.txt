Product: Integration tests for WSO2 ESB Meetup connector
Pre-requisites:

- Maven 3.x
- Java 1.6 or above

Tested Platform: 

- MAC OX Version 10.9
- WSO2 ESB 4.8.1
		  
STEPS:

1. Make sure the ESB 4.8.1 zip file with latest patches available at "Integration_Test\products\esb\4.8.1\modules\distribution\target\".

2. Copy Meetup connector zip file (meetup.zip) to the location "Integration_Test\products\esb\4.8.1\modules\integration\connectors\repository\"

3. Add following code block, just after the listeners block (Remove or comment all the other test blocks) in following file - "Integration_Test\products\esb\4.8.1\modules\integration\connectors\src\test\resources\testng.xml"

	<test name="Meetup-Connector-Test" preserve-order="true" verbose="2">
            <packages>


                <package name="org.wso2.carbon.connector.integration.test.meetup.batch"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.boards"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.categories"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.cities"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.dashboard"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.events"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.meta"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.notification"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.oembed"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.photos"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.profiles"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.rsvps"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.streams"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.topics"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.venues"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.feed"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.group"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.members"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.everywhere.community"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.everywhere.comments"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.everywhere.event"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.everywhere.eventseed"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.everywhere.rsvps"/>
                <package name="org.wso2.carbon.connector.integration.test.meetup.everywhere.containers"/>

            </packages>
        </test>


4. Copy proxy files to following location "Integration_Test\products\esb\4.8.1\modules\integration\connectors\src\test\resources\artifacts\ESB\config\proxies\meetup\"

5. Copy request files to following "Integration_Test\products\esb\4.8.1\modules\integration\connectors\src\test\resources\artifacts\ESB\config\restRequests\meetup\" 

6. Edit the "meetup.properties" at Integration_Test\products\esb\4.8.1\modules\integration\connectors\src\test\resources\artifacts\ESB\connector\config using valid and relevant data. Parameters to be changed are mentioned below.
	Following methods can be used to get authentication to access meetup API

	-Using API Keys
            Meetup API methods can be accessed using a API key. The request's authorization will be based on the owner's key. Use following steps to get an API key.
            Create a meetup user account.
            Navigate to http://www.meetup.com/ and set up your account
            To view your API key, navigate to https://secure.meetup.com/meetup_api/key/
         note: You'll need to provide this key when consuming API methods. You can reset your API key whenever you want.



    -OAuth 2 requests over HTTPS

        -Requesting Authorization:
            https://secure.meetup.com/oauth2/authorize?client_id=YOUR_CONSUMER_KEY&response_type=code&redirect_uri=YOUR_CONSUMER_REDIRECT_URI

        -Requesting Access Token :
            Have your server make an HTTP application/x-www-form-urlencoded encoded POST request for an access token with the following format:
            https://secure.meetup.com/oauth2/access
            with the body of the request being :
            client_id=YOUR_CONSUMER_KEY&client_secret=YOUR_CONSUMER_SECRET&grant_type=authorization_code&redirect_uri=SAME_REDIRECT_URI_USED_FOR_PREVIOUS_STEP&code=CODE_YOU_RECEIVED_FROM_THE_AUTHORIZATION_RESPONSE

        -Refreshing Token:
            https://secure.meetup.com/oauth2/access
            with the body of the request being (line breaks are for readability)
            client_id=YOUR_CONSUMER_KEY&client_secret=YOUR_CONSUMER_SECRET&grant_type=refresh_token&refresh_token=REFRESH_TOKEN_YOU_RECEIVED_FROM_ACCESS_RESPONSE
		
7. Following data set can be used for the first testsuite run.

		proxyDirectoryRelativePath=/../src/test/resources/artifacts/ESB/config/proxies/meetup/
        requestDirectoryRelativePath=/../src/test/resources/artifacts/ESB/config/restRequests/meetup/
        key=315264654774266436d5a5653204017
        access_token=455259fe4c9ef0cda9b56302bc2e8cba
        apiUrl=https://api.meetup.com
        apiVersion=2
        member_id=166092422
        bio=I'm steady
        Account Details:
		    username: dsilvawso2@gmail.com
		    password: Pathfinder92@feb
8. Navigate to "Integration_Test\products\esb\4.8.1\modules\integration\connectors\” and run the following command.
     $ mvn clean install
