package shahid.api

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable


public class SendMediaReq  {

	@Keyword
	def Authenticate (String URL ,  String Ssession) {
		String endpoint = URL
		String requestMethod = "POST"


		TestObjectProperty header1 = new TestObjectProperty("authority", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession)
		TestObjectProperty header3 = new TestObjectProperty("authorization", ConditionType.EQUALS, "AWS4-HMAC-SHA256 Credential=AKIAI6X4TYCIXM2B7MUQ/20200424/us-east-1/execute-api/aws4_request, SignedHeaders=accept;content-type;host;profile;x-amz-date;x-api-key, Signature=631ac8ae3688ff6756bae0ae28db2ea3ad643d35df7256fbbb7811d35f6fe467")
		TestObjectProperty header4 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"9ceb2530-5739-11ea-9227-ab892a551c3d","master":true}')
		TestObjectProperty header5 = new TestObjectProperty("content-type", ConditionType.EQUALS, "application/json")
		TestObjectProperty header6 = new TestObjectProperty("accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header7 = new TestObjectProperty("user-agent", ConditionType.EQUALS, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36")
		TestObjectProperty header8 = new TestObjectProperty("uuid", ConditionType.EQUALS, "web")
		TestObjectProperty header9 = new TestObjectProperty("x-amz-date", ConditionType.EQUALS, "20200424T125829Z")
		TestObjectProperty header10 = new TestObjectProperty("x-api-key", ConditionType.EQUALS, "2RRtuMHx95aNI1Kvtn2rChEuwsCogUd4samGPjLh")
		TestObjectProperty header11 = new TestObjectProperty("origin", ConditionType.EQUALS, "https://shahid.mbc.net")
		TestObjectProperty header12 = new TestObjectProperty("sec-fetch-site", ConditionType.EQUALS, "cross-site")
		TestObjectProperty header13 = new TestObjectProperty("sec-fetch-mode", ConditionType.EQUALS, "cors")
		TestObjectProperty header14 = new TestObjectProperty("sec-fetch-dest", ConditionType.EQUALS, "empty")
		TestObjectProperty header15 = new TestObjectProperty("referer", ConditionType.EQUALS, "https://shahid.mbc.net/ar/widgets/login-password")
		TestObjectProperty header16 = new TestObjectProperty("accept-language", ConditionType.EQUALS, "en,en-US;q=0.9,de-DE;q=0.8,de;q=0.7")



		ArrayList defaultHeaders = Arrays.asList(header1, header2 , header3 ,header4 , header5 , header6 , header7 , header8 , header9 , header10 , header11 , header12 , header13 , header14 , header15 , header16)
		String body = '{"gigyaInfo":{"UID":"71093401","UIDSignature":"WMNPfjkqs0wn6W2AnFKByRwKJsI=","signatureTimestamp":"1583146838","profile":{"email":"automationuser10@mbc.net"},"user":{"firstName":"Shahid","lastName":"Automation","gender":"m"}},"isNewUser":false,"captchaToken":"c2hhaGlkLWF1dGgta2V5LXRva2Vu","deviceSerial":"D4A1951C-E662-4556-8DCB-6BDCA140B64E","deviceType":"Mobile","physicalDeviceType":"IOS","label":"MBCâ€™s iPhone"}'

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("POST")
		ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		println "respObj:: "+respObj

		return respObj
	}

	@Keyword
	def getSssesion(){
		ResponseObject JWT = WS.sendRequest(findTestObject('Object Repository/Decode/web'))

		def slurper = new groovy.json.JsonSlurper()

		def result = slurper.parseText(JWT.getResponseBodyContent())

		String Ssession = result.get('jwt')
		GlobalVariable.ssession=Ssession
		return Ssession
	}

	@Keyword
	def getalalzabargahToken(String Ssession){

		ResponseObject AuthRes = WS.sendRequest(findTestObject('Object Repository/Decode/Auth-alalzabarga', [('ssessionToken') : Ssession]))

		def slurper = new groovy.json.JsonSlurper()

		def result = slurper.parseText(AuthRes.getResponseBodyContent())
		println("*********** ********* **********  "+result)
		String tokenRes = result.get('user').get('sessionId')
		String userName = result.get('user').get('userName')

		return tokenRes
	}



	@Keyword
	public ResponseObject SendRequest(String URL) {

		String Ssession = new SendMediaReq().getSssesion()


		println('tokenValue::' +  GlobalVariable.Token)


		String endpoint = URL
		String requestMethod = "GET"
		String authHeader = "AWS4-HMAC-SHA256 Credential=AKIAI6X4TYCIXM2B7MUQ/20190417/us-east-1/execute-api/aws4_request, SignedHeaders=accept;browser_name;browser_version;host;os_version;shahid_os;token;x-amz-date;x-api-key, Signature=08a75b05ae01a013eef11990fd66c48b8141073ee57f0d8342c394e20596b2d7"

		TestObjectProperty header1 = new TestObjectProperty("Authorization", ConditionType.EQUALS, authHeader)
		TestObjectProperty header2 = new TestObjectProperty("Accept-Language", ConditionType.EQUALS, "en-US,en;q=0.5")
		TestObjectProperty header3 = new TestObjectProperty("Accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header4 = new TestObjectProperty("BROWSER_NAME", ConditionType.EQUALS, "FIREFOX")
		TestObjectProperty header5 = new TestObjectProperty("BROWSER_VERSION", ConditionType.EQUALS, "66.0")
		TestObjectProperty header6 = new TestObjectProperty("Connection", ConditionType.EQUALS, "keep-alive")
		TestObjectProperty header7 = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")
		TestObjectProperty header8 = new TestObjectProperty("OS_VERSION", ConditionType.EQUALS, "10")
		TestObjectProperty header9 = new TestObjectProperty("Origin", ConditionType.EQUALS, "https://shahid.mbc.net")
		TestObjectProperty header10 = new TestObjectProperty("SHAHID_OS", ConditionType.EQUALS, "WINDOWS")
		TestObjectProperty header11 = new TestObjectProperty("User-Agent", ConditionType.EQUALS, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0")
		TestObjectProperty header12 = new TestObjectProperty("cache-control", ConditionType.EQUALS, "no-cache")
		TestObjectProperty header13 = new TestObjectProperty("token", ConditionType.EQUALS,  GlobalVariable.Token)
		TestObjectProperty header14 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession)
		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header5, header6, header7, header8, header9, header10, header11, header12, header13,header14)

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod(requestMethod)

		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}
}

