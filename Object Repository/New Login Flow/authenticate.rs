<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>authenticate</name>
   <tag></tag>
   <elementGuidId>5ae8676f-987d-4680-aa62-a89348a11269</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\&quot;gigyaInfo\&quot;:{\&quot;UID\&quot;:\&quot;71093401\&quot;,\&quot;UIDSignature\&quot;:\&quot;WMNPfjkqs0wn6W2AnFKByRwKJsI\u003d\&quot;,\&quot;signatureTimestamp\&quot;:\&quot;1583146838\&quot;,\&quot;profile\&quot;:{\&quot;email\&quot;:\&quot;automationuser10@mbc.net\&quot;},\&quot;user\&quot;:{\&quot;firstName\&quot;:\&quot;Shahid\&quot;,\&quot;lastName\&quot;:\&quot;Automation\&quot;,\&quot;gender\&quot;:\&quot;m\&quot;}},\&quot;isNewUser\&quot;:false,\&quot;captchaToken\&quot;:\&quot;c2hhaGlkLWF1dGgta2V5LXRva2Vu\&quot;,\&quot;deviceSerial\&quot;:\&quot;D4A1951C-E662-4556-8DCB-6BDCA140B64E\&quot;,\&quot;deviceType\&quot;:\&quot;Mobile\&quot;,\&quot;physicalDeviceType\&quot;:\&quot;IOS\&quot;,\&quot;label\&quot;:\&quot;MBCâ€™s iPhone\&quot;}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Connection</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>AWS4-HMAC-SHA256 Credential=AKIAI6X4TYCIXM2B7MUQ/20200224/us-east-1/execute-api/aws4_request, SignedHeaders=accept;content-type;host;profile;x-amz-date;x-api-key, Signature=2e20438d0091123f9c58fed181d874398b8de4bcd1badcd9a2478f21e07f527b</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>profile</name>
      <type>Main</type>
      <value>{&quot;id&quot;:&quot;9ceb2530-5739-11ea-9227-ab892a551c3d&quot;,&quot;master&quot;:true}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>User-Agent</name>
      <type>Main</type>
      <value>Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.116 Safari/537.36</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>x-amz-date</name>
      <type>Main</type>
      <value>20200216T124940Z</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>x-api-key</name>
      <type>Main</type>
      <value>2RRtuMHx95aNI1Kvtn2rChEuwsCogUd4samGPjLh</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Origin</name>
      <type>Main</type>
      <value>https://shahid.mbc.net</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Sec-Fetch-Site</name>
      <type>Main</type>
      <value>cross-site</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Sec-Fetch-Mode</name>
      <type>Main</type>
      <value>cors</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Referer</name>
      <type>Main</type>
      <value>https://shahid.mbc.net/ar/widgets/login-password</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept-Encoding</name>
      <type>Main</type>
      <value>gzip, deflate, br</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept-Language</name>
      <type>Main</type>
      <value>en,en-US;q=0.9,de-DE;q=0.8,de;q=0.7</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://api2.shahid.net/proxy/v2/usersservice/authenticate?t=1582571696420</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
