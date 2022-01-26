<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>accountsLogin</name>
   <tag></tag>
   <elementGuidId>8697ccff-9f2e-4a88-b134-88d1bae64cda</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;contentType&quot;: &quot;application/x-www-form-urlencoded&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;,
  &quot;parameters&quot;: [
    {
      &quot;name&quot;: &quot;loginID&quot;,
      &quot;value&quot;: &quot;AutomationUser20@mbc.net&quot;
    },
    {
      &quot;name&quot;: &quot;password&quot;,
      &quot;value&quot;: &quot;1234567&quot;
    },
    {
      &quot;name&quot;: &quot;sessionExpiration&quot;,
      &quot;value&quot;: &quot;&quot;
    },
    {
      &quot;name&quot;: &quot;targetEnv&quot;,
      &quot;value&quot;: &quot;jssdk&quot;
    },
    {
      &quot;name&quot;: &quot;include&quot;,
      &quot;value&quot;: &quot;profile,data&quot;
    },
    {
      &quot;name&quot;: &quot;includeUserInfo&quot;,
      &quot;value&quot;: &quot;true&quot;
    },
    {
      &quot;name&quot;: &quot;lang&quot;,
      &quot;value&quot;: &quot;en&quot;
    },
    {
      &quot;name&quot;: &quot;APIKey&quot;,
      &quot;value&quot;: &quot;3_Pm0x4fe9XSy6gv04PewESwqZ_HLgUCbXwWWPHCbGmUGFbW1xyHa42dFt0XTVay0T&quot;
    },
    {
      &quot;name&quot;: &quot;sdk&quot;,
      &quot;value&quot;: &quot;js_latest&quot;
    },
    {
      &quot;name&quot;: &quot;authMode&quot;,
      &quot;value&quot;: &quot;cookie&quot;
    },
    {
      &quot;name&quot;: &quot;pageURL&quot;,
      &quot;value&quot;: &quot;https://shahid.mbc.net/ar/widgets/login&quot;
    },
    {
      &quot;name&quot;: &quot;format&quot;,
      &quot;value&quot;: &quot;jsonp&quot;
    },
    {
      &quot;name&quot;: &quot;callback&quot;,
      &quot;value&quot;: &quot;gigya.callback&quot;
    },
    {
      &quot;name&quot;: &quot;context&quot;,
      &quot;value&quot;: &quot;R3901635850&quot;
    },
    {
      &quot;name&quot;: &quot;utf8&quot;,
      &quot;value&quot;: &quot;\u0026#x2713;&quot;
    }
  ]
}</httpBodyContent>
   <httpBodyType>x-www-form-urlencoded</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/x-www-form-urlencoded</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://login.mbc.net/accounts.login?context=R3901635850&amp;saveResponseID=R3901635850</restUrl>
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
