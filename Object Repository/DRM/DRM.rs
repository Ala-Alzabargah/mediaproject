<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>DRM</name>
   <tag></tag>
   <elementGuidId>db2266a9-26cb-4e4a-a16e-335cf58c38a8</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>User-Agent</name>
      <type>Main</type>
      <value>Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0</value>
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
      <name>Accept-Language</name>
      <type>Main</type>
      <value>en-US,en;q=0.5</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Referer</name>
      <type>Main</type>
      <value>https://shahid.mbc.net/ar/movies/%D8%A3%D8%AE%D9%84%D8%A7%D9%82-%D8%A7%D9%84%D8%B9%D8%A8%D9%8A%D8%AF/movie-333538</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>SHAHID_OS</name>
      <type>Main</type>
      <value>WINDOWS</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>OS_VERSION</name>
      <type>Main</type>
      <value>10</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>BROWSER_NAME</name>
      <type>Main</type>
      <value>FIREFOX</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>BROWSER_VERSION</name>
      <type>Main</type>
      <value>66.0</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>token</name>
      <type>Main</type>
      <value>eyJhbGciOiJIUzI1NiJ9.eyJjYWNoZSI6IlVzZXJfNzEwOTM0MDEiLCJ1aWQiOiJhcHIxU2hhaGlkRW5EeDRZd3NOa1hPcU5MM0tiNXoyTzgxIiwiZGlkIjoiV2ViIiwic3ViaWQiOiI3MTA5MzQwMSIsInN1YiI6InNoYWhpZC10b2tlbi1lbmNvZGUiLCJpc3MiOiJzaGFoaWQtdG9rZW4tZW5jb2RlIiwiaWF0IjoxNTc1NjMzNzUxLCJleHAiOjE2MDcyNTYxNTF9.6lQUygZdkV8Y_FQbKkiZUIC6BI6vciDruKlAl5F_NHg </value>
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
      <name>x-amz-date</name>
      <type>Main</type>
      <value>20190417T081418Z</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>AWS4-HMAC-SHA256 Credential=AKIAI6X4TYCIXM2B7MUQ/20190417/us-east-1/execute-api/aws4_request, SignedHeaders=accept;browser_name;browser_version;host;os_version;shahid_os;token;x-amz-date;x-api-key, Signature=1cf074cbed88c654a450fc4e05b1043997dc375207dc2939334acce6189218a8</value>
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
      <name>Origin</name>
      <type>Main</type>
      <value>https://shahid.mbc.net</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Connection</name>
      <type>Main</type>
      <value>keep-alive</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://api2.shahid.net/proxy/v2/drm?request=%7B%22assetId%22%3A333538%7D</restUrl>
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
