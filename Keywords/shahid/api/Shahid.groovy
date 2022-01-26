package shahid.api

import java.awt.Color

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable





public class Shahid {


	@Keyword
	public String getHexColor(String colorName) {
		colorName=colorName.toUpperCase()
		String colorHex
		
		switch(colorName){
			case GlobalVariable.GREEN:
			colorHex = "#"+Integer.toHexString(Color.GREEN.getRGB()).substring(2)
			break
			case GlobalVariable.RED:
			colorHex = "#"+Integer.toHexString(Color.RED.getRGB()).substring(2)
			break
			case GlobalVariable.YELLOW:
			colorHex = "#"+Integer.toHexString(Color.YELLOW.getRGB()).substring(2)
			break
			case GlobalVariable.BLUE:
			colorHex = "#"+Integer.toHexString(Color.BLUE.getRGB()).substring(2)
			break
			default:
			KeywordUtil.markFailed(colorName+" it's an invalid color")
			break
		}
		
		
		
	
		return colorHex
	}


	@Keyword
	def SendRequest(String URL) {
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
		TestObjectProperty header13 = new TestObjectProperty("token", ConditionType.EQUALS, "eyJhbGciOiJIUzI1NiJ9.eyJjYWNoZSI6IlVzZXJfNzEwOTM0MDEiLCJ1aWQiOiJhcHIxU2hhaGlkRW5EeDRZd3NOa1hPcU5MM0tiNXoyTzgxIiwiZGlkIjoiV2ViIiwic3ViaWQiOjcxMDkzNDAxLCJzdWIiOiJzaGFoaWQtdG9rZW4tZW5jb2RlIiwiaXNzIjoic2hhaGlkLXRva2VuLWVuY29kZSIsImlhdCI6MTU1NTQ4ODc2NiwiZXhwIjoxNTg3MTExMTY2fQ.FCs-thQYMs459P1vB8J7CNtA0oZRY3qNKOjiCFO9I94")

		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header5, header6, header7, header8, header9, header10, header11, header12, header13)

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod(requestMethod)

		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}

	@Keyword
	def ValidLogin () {
		String endpoint = 'https://api2.shahid.net/proxy/v2/users/login?q=1546429302421&Accept=application/json,%20text/plain,%20%2A/%2A&Accept-Language=ar-AE&Referer=https://shahid.mbc.net/ar/widgets/&Origin=https://shahid.mbc.net&Content-Type=application/json'
		String requestMethod = "POST"


		TestObjectProperty header1 = new TestObjectProperty("cache-control", ConditionType.EQUALS, "no-cache")
		TestObjectProperty header2 = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")
		TestObjectProperty header3 = new TestObjectProperty("User-Agent", ConditionType.EQUALS, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0")
		ArrayList defaultHeaders = Arrays.asList(header1, header2 , header3)
		String body = '{"email": "AutomationUser20@mbc.net", "password":"7654321","userHashedValue":"RkhPgXPjVXUiQVYTUPUXiUggkTYlPYQWXkiiijSXhRlVUWTShlYYRRXRWXiSSQPR","captchaAnswer":"g8n6n"}'

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("POST")
		ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}


	@Keyword
	def DRMRequest(String URL , String Token) {
		String endpoint = URL
		String requestMethod = "GET"

		TestObjectProperty header1 = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")
		TestObjectProperty header2 = new TestObjectProperty("User-Agent", ConditionType.EQUALS, "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16C101 Safari/605.1.15")
		TestObjectProperty header3 = new TestObjectProperty("Accept", ConditionType.EQUALS, "application/json, text/plain, */*")
		TestObjectProperty header4 = new TestObjectProperty("Accept-Language", ConditionType.EQUALS, "en-us")
		//	TestObjectProperty header5 = new TestObjectProperty("Referer", ConditionType.EQUALS, "https://shahid.mbc.net/ar/movies/%D8%A7%D9%84%D9%81%D9%8A%D9%84-%D8%A7%D9%84%D8%A3%D8%B2%D8%B1%D9%82-2/movie-player-389387")
		TestObjectProperty header6 = new TestObjectProperty("shahid_os", ConditionType.EQUALS, "MAC")
		//	TestObjectProperty header7 = new TestObjectProperty("OS_VERSION", ConditionType.EQUALS, "10")
		TestObjectProperty header8 = new TestObjectProperty("browser_name", ConditionType.EQUALS, "SAFARI")
		TestObjectProperty header9 = new TestObjectProperty("browser_version", ConditionType.EQUALS, "73")
		TestObjectProperty header10 = new TestObjectProperty("token", ConditionType.EQUALS, Token)
		//	TestObjectProperty header11 = new TestObjectProperty("x-api-key", ConditionType.EQUALS, "2RRtuMHx95aNI1Kvtn2rChEuwsCogUd4samGPjLh")
		//	TestObjectProperty header12 = new TestObjectProperty("x-amz-date", ConditionType.EQUALS, "20200224T191934Z")
		//	TestObjectProperty header13 = new TestObjectProperty("Authorization", ConditionType.EQUALS, "AWS4-HMAC-SHA256 Credential=AKIAI6X4TYCIXM2B7MUQ/20200224/us-east-1/execute-api/aws4_request, SignedHeaders=accept;browser_name;browser_version;host;os_version;profile;shahid_os;token;x-amz-date;x-api-key, Signature=33d9ef8b2830d9996fb31f0126259dd4c65ed4db41e38f8661fd3d8d8578ee83")
		//	TestObjectProperty header14 = new TestObjectProperty("Connection", ConditionType.EQUALS, "keep-alive")
		//	TestObjectProperty header15 = new TestObjectProperty("Origin", ConditionType.EQUALS, "https://shahid.mbc.net")
		TestObjectProperty header16 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"84996400-349f-4c8f-972a-789947771038","master":1,"age":null,"ageRestriction":false}')
		//	TestObjectProperty header17 = new TestObjectProperty("Sec-Fetch-Dest", ConditionType.EQUALS, "empty")
		TestObjectProperty header18 = new TestObjectProperty("Host", ConditionType.EQUALS, "api2.shahid.net")

		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header6, header8, header9, header10,  header16, header18)
		//	String body = '{"email": "AutomationUser20@mbc.net", "password":"1234567","userHashedValue":"RkhPgXPjVXUiQVYTUPUXiUggkTYlPYQWXkiiijSXhRlVUWTShlYYRRXRWXiSSQPR","captchaAnswer":"g8n6n"}'

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("GET")
		//ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}


	@Keyword
	def DRMV21Request(String URL , String Token , String Ssession) {
		String endpoint = URL
		String requestMethod = "GET"

		TestObjectProperty header1 = new TestObjectProperty("authority", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession )
		TestObjectProperty header3 = new TestObjectProperty("browser_name", ConditionType.EQUALS, "CHROME")
		TestObjectProperty header4 = new TestObjectProperty("os_version", ConditionType.EQUALS, "10")
		TestObjectProperty header6 = new TestObjectProperty("shahid_os", ConditionType.EQUALS, "WINDOWS")
		TestObjectProperty header7 = new TestObjectProperty("authorization", ConditionType.EQUALS, "AWS4-HMAC-SHA256 Credential=AKIAI6X4TYCIXM2B7MUQ/20200424/us-east-1/execute-api/aws4_request, SignedHeaders=accept;browser_name;browser_version;host;os_version;profile;shahid_os;token;x-amz-date;x-api-key, Signature=d3679195c3899998046db087470421c1c15642a7861786cc16a2116de6ad5abb")
		TestObjectProperty header8 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"84996400-349f-4c8f-972a-789947771038","ageRestriction":false,"master":1}')
		TestObjectProperty header9 = new TestObjectProperty("content-type", ConditionType.EQUALS, 'application/json')
		TestObjectProperty header10 = new TestObjectProperty("accept", ConditionType.EQUALS, 'application/json')
		TestObjectProperty header11 = new TestObjectProperty("user-agent", ConditionType.EQUALS, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36")
		TestObjectProperty header12 = new TestObjectProperty("browser_version", ConditionType.EQUALS, "81.0")
		TestObjectProperty header13 = new TestObjectProperty("uuid", ConditionType.EQUALS, "web")
		TestObjectProperty header14 = new TestObjectProperty("x-amz-date", ConditionType.EQUALS, "20200424T131752Z")
		TestObjectProperty header15 = new TestObjectProperty("token", ConditionType.EQUALS, Token)
		TestObjectProperty header16 = new TestObjectProperty("x-api-key", ConditionType.EQUALS, "2RRtuMHx95aNI1Kvtn2rChEuwsCogUd4samGPjLh")
		TestObjectProperty header17 = new TestObjectProperty("origin", ConditionType.EQUALS, "https://shahid.mbc.net")
		TestObjectProperty header18 = new TestObjectProperty("sec-fetch-site", ConditionType.EQUALS, "cross-site")
		TestObjectProperty header19 = new TestObjectProperty("sec-fetch-mode", ConditionType.EQUALS, "cors")
		TestObjectProperty header20 = new TestObjectProperty("sec-fetch-dest", ConditionType.EQUALS, "empty")
		TestObjectProperty header21 = new TestObjectProperty("referer", ConditionType.EQUALS, "https://shahid.mbc.net/ar/movies/%D9%87%D8%B1%D9%88%D8%A8-%D8%A5%D8%B6%D8%B7%D8%B1%D8%A7%D8%B1%D9%8A/movie-player-337854")
		TestObjectProperty header22 = new TestObjectProperty("accept-language", ConditionType.EQUALS, "en,en-US;q=0.9,de-DE;q=0.8,de;q=0.7")


		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header6, header7, header8, header9, header10, header11, header12, header13, header14, header15, header16, header17, header18, header19, header20 , header21 , header22)
		//	String body = '{"email": "AutomationUser20@mbc.net", "password":"1234567","userHashedValue":"RkhPgXPjVXUiQVYTUPUXiUggkTYlPYQWXkiiijSXhRlVUWTShlYYRRXRWXiSSQPR","captchaAnswer":"g8n6n"}'

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("GET")
		//ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}



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
		return respObj
	}


	@Keyword
	def EditorialConnectionwithAccedo (String URL ,  String Ssession) {
		String endpoint = URL
		String requestMethod = "GET"

		TestObjectProperty header1 = new TestObjectProperty("Accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession )
		TestObjectProperty header3 = new TestObjectProperty("Authorization", ConditionType.EQUALS, "AWS4-HMAC-SHA256 Credential=AKIAI6X4TYCIXM2B7MUQ/20200424/us-east-1/execute-api/aws4_request, SignedHeaders=accept;host;profile;token;x-amz-date;x-api-key, Signature=b92757ad3e77a0ed9326f605fb3ae8be4c8920c3b42a1f480e4d725a4be8a229")
		TestObjectProperty header4 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"84996400-349f-4c8f-972a-789947771038","master":true,"ageRestriction":false}')
		TestObjectProperty header5 = new TestObjectProperty("Content-Type", ConditionType.EQUALS, 'application/json')
		TestObjectProperty header6 = new TestObjectProperty("Cache-Control", ConditionType.EQUALS, 'no-cache')
		TestObjectProperty header7 = new TestObjectProperty("User-Agent", ConditionType.EQUALS, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36")
		TestObjectProperty header8 = new TestObjectProperty("UUID", ConditionType.EQUALS, "web")
		TestObjectProperty header9 = new TestObjectProperty("x-amz-date", ConditionType.EQUALS, "20200424T122101Z")
		TestObjectProperty header10 = new TestObjectProperty("x-api-key", ConditionType.EQUALS, "2RRtuMHx95aNI1Kvtn2rChEuwsCogUd4samGPjLh")
		TestObjectProperty header11 = new TestObjectProperty("Host", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header12 = new TestObjectProperty("Connection", ConditionType.EQUALS, "keep-alive")
		TestObjectProperty header13 = new TestObjectProperty("Referer", ConditionType.EQUALS, "https://shahid.mbc.net/ar/")
		TestObjectProperty header14 = new TestObjectProperty("Accept-Encoding", ConditionType.EQUALS, "application/json")


		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header6, header7, header8, header9, header10, header11, header12, header13, header14)

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("GET")
		//ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}


	@Keyword
	def Search (String URL ,  String Ssession) {
		String endpoint = URL
		String requestMethod = "GET"

		TestObjectProperty header1 = new TestObjectProperty("Accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession )
		TestObjectProperty header3 = new TestObjectProperty("Authorization", ConditionType.EQUALS, "AWS4-HMAC-SHA256 Credential=AKIAI6X4TYCIXM2B7MUQ/20200424/us-east-1/execute-api/aws4_request, SignedHeaders=accept;host;profile;token;x-amz-date;x-api-key, Signature=b92757ad3e77a0ed9326f605fb3ae8be4c8920c3b42a1f480e4d725a4be8a229")
		TestObjectProperty header4 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"84996400-349f-4c8f-972a-789947771038","master":true,"ageRestriction":false}')
		TestObjectProperty header5 = new TestObjectProperty("Content-Type", ConditionType.EQUALS, 'application/json')
		TestObjectProperty header6 = new TestObjectProperty("Cache-Control", ConditionType.EQUALS, 'no-cache')
		TestObjectProperty header7 = new TestObjectProperty("User-Agent", ConditionType.EQUALS, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36")
		TestObjectProperty header8 = new TestObjectProperty("UUID", ConditionType.EQUALS, "web")
		TestObjectProperty header9 = new TestObjectProperty("x-amz-date", ConditionType.EQUALS, "20200424T122101Z")
		TestObjectProperty header10 = new TestObjectProperty("x-api-key", ConditionType.EQUALS, "2RRtuMHx95aNI1Kvtn2rChEuwsCogUd4samGPjLh")
		TestObjectProperty header11 = new TestObjectProperty("Host", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header12 = new TestObjectProperty("Connection", ConditionType.EQUALS, "keep-alive")
		TestObjectProperty header13 = new TestObjectProperty("Referer", ConditionType.EQUALS, "https://shahid.mbc.net/ar/")
		TestObjectProperty header14 = new TestObjectProperty("Accept-Encoding", ConditionType.EQUALS, "application/json")


		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header6, header7, header8, header9, header10, header11, header12, header13, header14)

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("GET")

		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}


	@Keyword
	def userStatus (String URL ,  String Ssession) {
		String endpoint = URL
		String requestMethod = "POST"

		TestObjectProperty header1 = new TestObjectProperty("authority", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession)
		TestObjectProperty header3 = new TestObjectProperty("authorization", ConditionType.EQUALS, "AWS4-HMAC-SHA256 Credential=AKIAI6X4TYCIXM2B7MUQ/20200424/us-east-1/execute-api/aws4_request, SignedHeaders=accept;accept-language;content-type;host;profile;x-amz-date;x-api-key, Signature=dead5d2e6ed87929867fdfa6feb9c7a66b1cfe3cc473f08f331bc213858d7aab")
		TestObjectProperty header4 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"39175e90-862b-11ea-bb39-198956b4208e","master":true,"ageRestriction":false}')
		TestObjectProperty header5 = new TestObjectProperty("content-type", ConditionType.EQUALS, "application/json")
		TestObjectProperty header6 = new TestObjectProperty("accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header7 = new TestObjectProperty("user-agent", ConditionType.EQUALS, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36")
		TestObjectProperty header8 = new TestObjectProperty("uuid", ConditionType.EQUALS, "web")
		TestObjectProperty header9 = new TestObjectProperty("x-amz-date", ConditionType.EQUALS, "20200424T131718Z")
		TestObjectProperty header10 = new TestObjectProperty("x-api-key", ConditionType.EQUALS, "2RRtuMHx95aNI1Kvtn2rChEuwsCogUd4samGPjLh")
		TestObjectProperty header11 = new TestObjectProperty("origin", ConditionType.EQUALS, "https://shahid.mbc.net")
		TestObjectProperty header12 = new TestObjectProperty("sec-fetch-site", ConditionType.EQUALS, "cross-site")
		TestObjectProperty header13 = new TestObjectProperty("sec-fetch-mode", ConditionType.EQUALS, "cors")
		TestObjectProperty header14 = new TestObjectProperty("sec-fetch-dest", ConditionType.EQUALS, "empty")
		TestObjectProperty header15 = new TestObjectProperty("referer", ConditionType.EQUALS, "https://shahid.mbc.net/ar/widgets/login")
		TestObjectProperty header16 = new TestObjectProperty("accept-language", ConditionType.EQUALS, "ar")


		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header5, header6, header7, header8, header9, header10, header11, header12, header13, header15 , header16 )
		String body = '{"username":"AutomationUser10@mbc.net","captchaToken":"c2hhaGlkLWF1dGgta2V5LXRva2Vu"}'

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("POST")
		ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}





	@Keyword
	def usersService (String Token ,  String Ssession) {
		String endpoint = "https://api2.shahid.net/proxy/v2.1/usersservice?t=1587895363019&country=DE"
		String requestMethod = "GET"

		TestObjectProperty header1 = new TestObjectProperty("authority", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession )
		TestObjectProperty header3 = new TestObjectProperty("authorization", ConditionType.EQUALS, "AWS4-HMAC-SHA256 Credential=AKIAI6X4TYCIXM2B7MUQ/20200424/us-east-1/execute-api/aws4_request, SignedHeaders=accept;content-type;host;profile;x-amz-date;x-api-key, Signature=631ac8ae3688ff6756bae0ae28db2ea3ad643d35df7256fbbb7811d35f6fe467")
		TestObjectProperty header4 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"9ceb2530-5739-11ea-9227-ab892a551c3d","master":true}')
		TestObjectProperty header5 = new TestObjectProperty("content-type", ConditionType.EQUALS, "application/json")
		TestObjectProperty header6 = new TestObjectProperty("accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header7 = new TestObjectProperty("user-agent", ConditionType.EQUALS, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36")
		TestObjectProperty header8 = new TestObjectProperty("uuid", ConditionType.EQUALS, 'web')
		TestObjectProperty header9 = new TestObjectProperty("x-amz-date", ConditionType.EQUALS, '20200426T100243Z')
		TestObjectProperty header10 = new TestObjectProperty("token", ConditionType.EQUALS, Token)
		TestObjectProperty header11 = new TestObjectProperty("x-api-key", ConditionType.EQUALS, "2RRtuMHx95aNI1Kvtn2rChEuwsCogUd4samGPjLh")
		TestObjectProperty header12 = new TestObjectProperty("origin", ConditionType.EQUALS, "https://shahid.mbc.net")
		TestObjectProperty header13 = new TestObjectProperty("sec-fetch-site", ConditionType.EQUALS, "cross-site")
		TestObjectProperty header14 = new TestObjectProperty("sec-fetch-mode", ConditionType.EQUALS, "cors")
		TestObjectProperty header15 = new TestObjectProperty("sec-fetch-dest", ConditionType.EQUALS, "empty")
		TestObjectProperty header16 = new TestObjectProperty("referer", ConditionType.EQUALS, "https://shahid.mbc.net/ar/widgets/settings")
		TestObjectProperty header17 = new TestObjectProperty("accept-language", ConditionType.EQUALS, "en,en-US;q=0.9,de-DE;q=0.8,de;q=0.7")



		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header5, header6, header7, header8, header9, header10, header11, header12, header13, header14, header15, header16, header17)
		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("GET")

		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}



	@Keyword
	def tPay (String URL ,  String Ssession) {
		String endpoint = URL
		String requestMethod = "POST"

		TestObjectProperty header1 = new TestObjectProperty("authority", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession)
		TestObjectProperty header3 = new TestObjectProperty("sec-ch-ua", ConditionType.EQUALS, '" Not A;Brand";v="99", "Chromium";v="96", "Google Chrome";v="96"')
		TestObjectProperty header4 = new TestObjectProperty("language", ConditionType.EQUALS, "AR")
		TestObjectProperty header5 = new TestObjectProperty("accept-language", ConditionType.EQUALS, "ar")
		TestObjectProperty header6 = new TestObjectProperty("sec-ch-ua-mobile", ConditionType.EQUALS, '?0')
		TestObjectProperty header7 = new TestObjectProperty("user-agent", ConditionType.EQUALS, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36")
		//TestObjectProperty header8 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"54febdd8-6b8d-4806-a8b1-e3aa292c4831","ageRestriction":false,"master":1}')
		TestObjectProperty header8 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"8502edef-3f6c-4930-8008-211e9c53c955","ageRestriction":false,"master":1}')
		TestObjectProperty header9 = new TestObjectProperty("content-type", ConditionType.EQUALS, "application/json")
		TestObjectProperty header10 = new TestObjectProperty("accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header11 = new TestObjectProperty("uuid", ConditionType.EQUALS, "web")
		TestObjectProperty header12 = new TestObjectProperty("origin", ConditionType.EQUALS, "https://shahid.mbc.net")
		TestObjectProperty header13 = new TestObjectProperty("sec-fetch-site", ConditionType.EQUALS, "cross-site")
		TestObjectProperty header14 = new TestObjectProperty("sec-fetch-mode", ConditionType.EQUALS, "cors")
		TestObjectProperty header15 = new TestObjectProperty("sec-fetch-dest", ConditionType.EQUALS, "empty")
		TestObjectProperty header16 = new TestObjectProperty("referer", ConditionType.EQUALS, "https://shahid.mbc.net/")
		TestObjectProperty header17 = new TestObjectProperty("sec-ch-ua-platform", ConditionType.EQUALS, '"Windows"')



		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header5, header6, header7, header8, header9, header10, header11, header12, header13, header15 , header16,header17 )
		String body = '{"countryCode":"JOR"}'

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("POST")
		ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}




	@Keyword
	def iTuensBaseToken (String URL ,  String Ssession) {
		String endpoint = URL
		String requestMethod = "POST"

		TestObjectProperty header1 = new TestObjectProperty("authority", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession )
		TestObjectProperty header3 = new TestObjectProperty("sec-ch-ua", ConditionType.EQUALS, '" Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91"')
		TestObjectProperty header4 = new TestObjectProperty("language", ConditionType.EQUALS, "AR")
		TestObjectProperty header5 = new TestObjectProperty("accept-language", ConditionType.EQUALS, 'ar')
		TestObjectProperty header6 = new TestObjectProperty("granttype", ConditionType.EQUALS, "session")
		TestObjectProperty header7 = new TestObjectProperty("uuid", ConditionType.EQUALS, "web")
		TestObjectProperty header8 = new TestObjectProperty("subscriberid", ConditionType.EQUALS, "71093401")
		TestObjectProperty header9 = new TestObjectProperty("sec-ch-ua-mobile", ConditionType.EQUALS, "?0")
		TestObjectProperty header10 = new TestObjectProperty("authorize", ConditionType.EQUALS, "Basic YXV0b21hdGlvbnVzZXIxMEBtYmMubmV0OkIxRDQ1OEI3Nzg1OEEyQ0ZDRkUzNjI0Q0VFRTlCMDBC")
		TestObjectProperty header11 = new TestObjectProperty("user-agent", ConditionType.EQUALS, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
		TestObjectProperty header12 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"84996400-349f-4c8f-972a-789947771038","ageRestriction":false,"master":1}')
		TestObjectProperty header13 = new TestObjectProperty("content-type", ConditionType.EQUALS, "application/json")
		TestObjectProperty header14 = new TestObjectProperty("accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header15 = new TestObjectProperty("username", ConditionType.EQUALS, "automationuser10@mbc.net")
		TestObjectProperty header16 = new TestObjectProperty("country", ConditionType.EQUALS, "JOR")
		TestObjectProperty header17 = new TestObjectProperty("token", ConditionType.EQUALS, "eyJhbGciOiJIUzI1NiJ9.eyJjYWNoZSI6IlVzZXJfNzEwOTM0MDEiLCJ1aWQiOiJhcHIxU2hhaGlkRW5EeDRZd3NOa1hPcU5MM0tiNXoyTzgxIiwiZGlkIjoiV2ViIiwic3ViaWQiOiI3MTA5MzQwMSIsInN1YiI6InNoYWhpZC10b2tlbi1lbmNvZGUiLCJpc3MiOiJzaGFoaWQtdG9rZW4tZW5jb2RlIiwiaWF0IjoxNjI2MDg0NTE4LCJleHAiOjE2NTc2MjA1MTh9.w42OC8X7x5fGObOEqMuRPm2tNy1NZ6YgQJLl0fLSJPU")
		TestObjectProperty header18 = new TestObjectProperty("origin", ConditionType.EQUALS, "https://shahid.mbc.net")
		TestObjectProperty header19 = new TestObjectProperty("sec-fetch-site", ConditionType.EQUALS, "cross-site")
		TestObjectProperty header20 = new TestObjectProperty("sec-fetch-mode", ConditionType.EQUALS, "cors")
		TestObjectProperty header21 = new TestObjectProperty("sec-fetch-dest", ConditionType.EQUALS, "empty")
		TestObjectProperty header22 = new TestObjectProperty("referer", ConditionType.EQUALS, "https://shahid.mbc.net/")

		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header5 ,header6, header7, header8, header9, header10, header11, header12, header13, header14, header15, header16, header17, header18, header19, header20, header21, header22)

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("POST")
		//ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}




	@Keyword
	def iTunesActivate (String URL ,  String Ssession , String baseToken) {
		String endpoint = URL
		String requestMethod = "POST"

		TestObjectProperty header1 = new TestObjectProperty("Host", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession )
		TestObjectProperty header3 = new TestObjectProperty("content-type", ConditionType.EQUALS, "application/json;charset=utf-8")
		TestObjectProperty header4 = new TestObjectProperty("shahid-agent", ConditionType.EQUALS, "Shahid/5.4.1.3579 CFNetwork/1126 Darwin/19.5.0 (iPhone/7 iOS/13.5.1) Safari/604.1")
		TestObjectProperty header5 = new TestObjectProperty("uuid", ConditionType.EQUALS, 'web')
		TestObjectProperty header6 = new TestObjectProperty("accept", ConditionType.EQUALS, 'application/json, text/plain, */*')
		TestObjectProperty header7 = new TestObjectProperty("paymenttoken", ConditionType.EQUALS, baseToken)
		TestObjectProperty header8 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"7687fa01-6d4e-430f-9faa-52d0743bbd09","master":1}')
		//TestObjectProperty header8 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"6aaab839-2577-44ca-b198-d482393e7a4c","master":1}')
		TestObjectProperty header9 = new TestObjectProperty("subscriberid", ConditionType.EQUALS, "2e1d8d9801b045588b88fd118a9d9562")
		//TestObjectProperty header9 = new TestObjectProperty("subscriberid", ConditionType.EQUALS, "ec07edaef9994cd9a60928220e8efe08")
		TestObjectProperty header10 = new TestObjectProperty("s-country", ConditionType.EQUALS, "JO")
		TestObjectProperty header11 = new TestObjectProperty("accept-language", ConditionType.EQUALS, "ar-AE")
		TestObjectProperty header12 = new TestObjectProperty("token", ConditionType.EQUALS, "eyJhbGciOiJIUzI1NiJ9.eyJjYWNoZSI6IlVzZXJfNzEwOTM0MDEiLCJ1aWQiOiJhcHIxU2hhaGlkRW5EeDRZd3NOa1hPcU5MM0tiNXoyTzgxIiwiZGlkIjoiV2ViIiwic3ViaWQiOiI3MTA5MzQwMSIsInN1YiI6InNoYWhpZC10b2tlbi1lbmNvZGUiLCJpc3MiOiJzaGFoaWQtdG9rZW4tZW5jb2RlIiwiaWF0IjoxNjI2MDg0NTE4LCJleHAiOjE2NTc2MjA1MTh9.w42OC8X7x5fGObOEqMuRPm2tNy1NZ6YgQJLl0fLSJPU")
		TestObjectProperty header13 = new TestObjectProperty("user-agent", ConditionType.EQUALS, "Shahid/5.4.1.3579 CFNetwork/1126 Darwin/19.5.0 (iPhone/7 iOS/13.5.1) Safari/604.1")
		//	TestObjectProperty header14 = new TestObjectProperty("username", ConditionType.EQUALS, 'automationuser10@mbc.net')
		TestObjectProperty header14 = new TestObjectProperty("username", ConditionType.EQUALS, 'shahidvipmonitoring@gmail.com')

		TestObjectProperty header15 = new TestObjectProperty("country", ConditionType.EQUALS, 'JOR')


		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header5 ,header6, header7, header8, header9, header10, header11, header12, header13, header14, header15)
		String body = '{"transactionReceipt":"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","appleUsername":"newautomation1000@mbc.net","acceptTerms":true,"paymentInstrumentType":"ITunes","originalTransactionId":"1000000599163826"}'
		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("POST")
		ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}


	@Keyword
	def EditorialAllHerosCarousel (String URL ,  String Ssession) {
		String endpoint = URL
		String requestMethod = "GET"

		TestObjectProperty header1 = new TestObjectProperty("Accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession )
		TestObjectProperty header3 = new TestObjectProperty("Authorization", ConditionType.EQUALS, "AWS4-HMAC-SHA256 Credential=AKIAI6X4TYCIXM2B7MUQ/20200424/us-east-1/execute-api/aws4_request, SignedHeaders=accept;host;profile;token;x-amz-date;x-api-key, Signature=b92757ad3e77a0ed9326f605fb3ae8be4c8920c3b42a1f480e4d725a4be8a229")
		TestObjectProperty header4 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"84996400-349f-4c8f-972a-789947771038","master":true,"ageRestriction":false}')
		TestObjectProperty header5 = new TestObjectProperty("Content-Type", ConditionType.EQUALS, 'application/json')
		TestObjectProperty header6 = new TestObjectProperty("Cache-Control", ConditionType.EQUALS, 'no-cache')
		TestObjectProperty header7 = new TestObjectProperty("User-Agent", ConditionType.EQUALS, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36")
		TestObjectProperty header8 = new TestObjectProperty("UUID", ConditionType.EQUALS, "web")
		TestObjectProperty header9 = new TestObjectProperty("x-amz-date", ConditionType.EQUALS, "20200424T122101Z")
		TestObjectProperty header10 = new TestObjectProperty("x-api-key", ConditionType.EQUALS, "2RRtuMHx95aNI1Kvtn2rChEuwsCogUd4samGPjLh")
		TestObjectProperty header11 = new TestObjectProperty("Host", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header12 = new TestObjectProperty("Connection", ConditionType.EQUALS, "keep-alive")
		TestObjectProperty header13 = new TestObjectProperty("Referer", ConditionType.EQUALS, "https://shahid.mbc.net/ar/")
		TestObjectProperty header14 = new TestObjectProperty("Accept-Encoding", ConditionType.EQUALS, "application/json")


		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header6, header7, header8, header9, header10, header11, header12, header13, header14)

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("GET")
		//ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}

	@Keyword
	def PlayoutService (String URL ,  String Ssession) {
		String endpoint = URL
		String requestMethod = "GET"

		TestObjectProperty header1 = new TestObjectProperty("authority", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession )
		TestObjectProperty header3 = new TestObjectProperty("sec-ch-ua", ConditionType.EQUALS, '" Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91"')
		TestObjectProperty header4 = new TestObjectProperty("language", ConditionType.EQUALS, "AR")
		TestObjectProperty header5 = new TestObjectProperty("browser_name", ConditionType.EQUALS, 'CHROME')
		TestObjectProperty header6 = new TestObjectProperty("os_version", ConditionType.EQUALS, '10')
		TestObjectProperty header7 = new TestObjectProperty("shahid_os", ConditionType.EQUALS, "WINDOWS")
		TestObjectProperty header8 = new TestObjectProperty("user-agent", ConditionType.EQUALS, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36")
		TestObjectProperty header9 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"962a9240-d3f6-11eb-a87e-c1114e29462b","master":true,"ageRestriction":false}')
		TestObjectProperty header10 = new TestObjectProperty("content-type", ConditionType.EQUALS, "application/json")
		TestObjectProperty header11 = new TestObjectProperty("accept-language", ConditionType.EQUALS, "ar")
		TestObjectProperty header12 = new TestObjectProperty("accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header13 = new TestObjectProperty("sec-ch-ua-mobile", ConditionType.EQUALS, "?0")
		TestObjectProperty header14 = new TestObjectProperty("browser_version", ConditionType.EQUALS, "91.0")
		TestObjectProperty header15 = new TestObjectProperty("uuid", ConditionType.EQUALS, "web")
		TestObjectProperty header16 = new TestObjectProperty("token", ConditionType.EQUALS, "undefined")
		TestObjectProperty header17 = new TestObjectProperty("origin", ConditionType.EQUALS, "https://shahid.mbc.net")
		TestObjectProperty header18 = new TestObjectProperty("sec-fetch-site", ConditionType.EQUALS, "cross-site")
		TestObjectProperty header19 = new TestObjectProperty("sec-fetch-mode", ConditionType.EQUALS, "cors")
		TestObjectProperty header20 = new TestObjectProperty("sec-fetch-dest", ConditionType.EQUALS, "empty")
		TestObjectProperty header21 = new TestObjectProperty("referer", ConditionType.EQUALS, "https://shahid.mbc.net/")



		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header6, header7, header8, header9, header10, header11, header12, header13, header14, header15, header16, header17, header18, header19, header20, header21)

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("GET")
		//ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}



	@Keyword
	def ValidateLogin (String URL ,  String Ssession) {
		String endpoint = URL
		String requestMethod = "POST"


		TestObjectProperty header1 = new TestObjectProperty("Host", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession)
		TestObjectProperty header3 = new TestObjectProperty("content-type", ConditionType.EQUALS, "application/json")
		TestObjectProperty header4 = new TestObjectProperty("uuid", ConditionType.EQUALS, "web")
		TestObjectProperty header5 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"f69b7750-4540-11ec-bea0-3f81fdea667f","master":true,"ageRestriction":false}')
		TestObjectProperty header6 = new TestObjectProperty("accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header7 = new TestObjectProperty("accept-language", ConditionType.EQUALS, "en")
		TestObjectProperty header8 = new TestObjectProperty("origin", ConditionType.EQUALS, "https://shahid.mbc.net")
		TestObjectProperty header9 = new TestObjectProperty("language", ConditionType.EQUALS, "EN")
		TestObjectProperty header10 = new TestObjectProperty("user-agent", ConditionType.EQUALS, "Shahid/7.3.0.3706 CFNetwork/1312 Darwin/21.0.0 (iPhone XS Max iOS/15.0.1) Safari/604.1")
		TestObjectProperty header11 = new TestObjectProperty("referer", ConditionType.EQUALS, "https://shahid.mbc.net")


		ArrayList defaultHeaders = Arrays.asList(header1, header2 , header3 ,header4 , header5 , header6 , header7 , header8 , header9 , header10 , header11)
		String body = '{"email":"automationuser10@mbc.net","password":"VMTiFd9d+PVzKArAbFrl0w==","subscribeToNewsLetter":false,"terms":true,"deviceSerial":"0BDD8EDD-CDA0-4DDA-968C-F3F3542D9940","deviceType":"Mobile","physicalDeviceType":"IOS","label":"iPhone Xs Max","isNewUser":false,"captchaToken":"c2hhaGlkLWF1dGgta2V5LXRva2Vu","isEmailVerified":false,"isEmailVerifiedZerobounce":false}'

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("POST")
		ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}


	@Keyword
	def Personalization (String URL ,  String Ssession , String Token) {
		String endpoint = URL
		String requestMethod = "GET"

		TestObjectProperty header1 = new TestObjectProperty("authority", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession )
		TestObjectProperty header3 = new TestObjectProperty("sec-ch-ua", ConditionType.EQUALS, '" Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91"')
		TestObjectProperty header4 = new TestObjectProperty("language", ConditionType.EQUALS, "AR")
		TestObjectProperty header5 = new TestObjectProperty("accept-language", ConditionType.EQUALS, 'ar')
		TestObjectProperty header6 = new TestObjectProperty("sec-ch-ua-mobile", ConditionType.EQUALS, '?0')
		TestObjectProperty header7 = new TestObjectProperty("user-agent", ConditionType.EQUALS, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
		TestObjectProperty header8 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"195a3af9-e27c-482b-9846-468fb22cbdf4","ageRestriction":false,"master":1}')
		TestObjectProperty header9 = new TestObjectProperty("content-type", ConditionType.EQUALS, "application/json")
		TestObjectProperty header10 = new TestObjectProperty("accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header11 = new TestObjectProperty("uuid", ConditionType.EQUALS, "web")
		TestObjectProperty header12 = new TestObjectProperty("token", ConditionType.EQUALS, Token)
		TestObjectProperty header13 = new TestObjectProperty("origin", ConditionType.EQUALS, "https://shahid.mbc.net")
		TestObjectProperty header14 = new TestObjectProperty("sec-fetch-site", ConditionType.EQUALS, "cross-site")
		TestObjectProperty header15 = new TestObjectProperty("sec-fetch-mode", ConditionType.EQUALS, "cors")
		TestObjectProperty header16 = new TestObjectProperty("sec-fetch-dest", ConditionType.EQUALS, "empty")
		TestObjectProperty header17 = new TestObjectProperty("referer", ConditionType.EQUALS, "https://shahid.mbc.net/")


		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header6, header7, header8, header9, header10, header11, header12, header13, header14)

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("GET")
		//ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}




	@Keyword
	def pricingPlan (String URL ,  String Ssession , String Token) {
		String endpoint = URL
		String requestMethod = "POST"

		TestObjectProperty header1 = new TestObjectProperty("authority", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession)
		TestObjectProperty header3 = new TestObjectProperty("sec-ch-ua", ConditionType.EQUALS, '"Chromium";v="92", " Not A;Brand";v="99", "Google Chrome";v="92"')
		TestObjectProperty header4 = new TestObjectProperty("language", ConditionType.EQUALS, "AR")
		TestObjectProperty header5 = new TestObjectProperty("accept-language", ConditionType.EQUALS, "ar")
		TestObjectProperty header6 = new TestObjectProperty("sec-ch-ua-mobile", ConditionType.EQUALS, '?0')
		TestObjectProperty header7 = new TestObjectProperty("user-agent", ConditionType.EQUALS, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36")
		TestObjectProperty header8 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"5570e975-379e-434c-b66a-a756d16537fd","ageRestriction":false,"master":1}')
		TestObjectProperty header9 = new TestObjectProperty("content-type", ConditionType.EQUALS, "application/json")
		TestObjectProperty header10 = new TestObjectProperty("accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header11 = new TestObjectProperty("uuid", ConditionType.EQUALS, "web")
		TestObjectProperty header12 = new TestObjectProperty("origin", ConditionType.EQUALS, "https://shahid.mbc.net")
		TestObjectProperty header13 = new TestObjectProperty("sec-fetch-site", ConditionType.EQUALS, "cross-site")
		TestObjectProperty header14 = new TestObjectProperty("sec-fetch-mode", ConditionType.EQUALS, "cors")
		TestObjectProperty header15 = new TestObjectProperty("sec-fetch-dest", ConditionType.EQUALS, "empty")
		TestObjectProperty header16 = new TestObjectProperty("referer", ConditionType.EQUALS, "https://shahid.mbc.net/")
		TestObjectProperty header17 = new TestObjectProperty("subscriberid", ConditionType.EQUALS, "7b145781a56043dca1ab60c9476014e8")
		TestObjectProperty header18 = new TestObjectProperty("accept-session", ConditionType.EQUALS, "6D267D6876A0F41D041AD20298918738")
		TestObjectProperty header19 = new TestObjectProperty("username", ConditionType.EQUALS, "anas.ajlouni1@gmail.com")
		TestObjectProperty header20 = new TestObjectProperty("country", ConditionType.EQUALS, "JOR")
		TestObjectProperty header21 = new TestObjectProperty("pragma", ConditionType.EQUALS, "no-cache")
		TestObjectProperty header22 = new TestObjectProperty("cache-control", ConditionType.EQUALS, "no-cache")
		TestObjectProperty header23 = new TestObjectProperty("sec-ch-ua-platform", ConditionType.EQUALS,"macOS")
		TestObjectProperty header24 = new TestObjectProperty("sec-ch-ua-mobile", ConditionType.EQUALS,"?0")
		TestObjectProperty header25 = new TestObjectProperty("token", ConditionType.EQUALS,Token)



		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header5, header6, header7, header8, header9, header10, header11, header12, header13, header15 , header16, header17, header18, header19, header20 ,header21,header22,header23,header24,header25)
		String body = '{"numberOfDay":7,"freeTrialEnabled":false,"packageName":"monthly","paymentInstrumentType":"CreditCard","subscriptionItems":{"freePricingPlanIds":[null],"paidPricingPlanId":"c1","productId":"JOR_B2C_SHAHID_VIP_1M"}}'

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("POST")
		ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}


	@Keyword
	def continueWatching (String URL ,  String Ssession , String Token) {
		String endpoint = URL
		String requestMethod = "GET"

		TestObjectProperty header1 = new TestObjectProperty("authority", ConditionType.EQUALS, "api2.shahid.net")
		TestObjectProperty header2 = new TestObjectProperty("s-session", ConditionType.EQUALS, Ssession )
		TestObjectProperty header3 = new TestObjectProperty("sec-ch-ua", ConditionType.EQUALS, '"Chromium";v="92", " Not A;Brand";v="99", "Google Chrome";v="92"')
		TestObjectProperty header4 = new TestObjectProperty("language", ConditionType.EQUALS, "AR")
		TestObjectProperty header5 = new TestObjectProperty("accept-language", ConditionType.EQUALS, 'ar')
		TestObjectProperty header6 = new TestObjectProperty("sec-ch-ua-mobile", ConditionType.EQUALS, '?0')
		TestObjectProperty header7 = new TestObjectProperty("user-agent", ConditionType.EQUALS, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
		TestObjectProperty header8 = new TestObjectProperty("profile", ConditionType.EQUALS, '{"id":"195a3af9-e27c-482b-9846-468fb22cbdf4","ageRestriction":false,"master":1}')
		TestObjectProperty header9 = new TestObjectProperty("content-type", ConditionType.EQUALS, "application/json")
		TestObjectProperty header10 = new TestObjectProperty("accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header11 = new TestObjectProperty("uuid", ConditionType.EQUALS, "web")
		TestObjectProperty header12 = new TestObjectProperty("token", ConditionType.EQUALS, Token)
		TestObjectProperty header13 = new TestObjectProperty("origin", ConditionType.EQUALS, "https://shahid.mbc.net")
		TestObjectProperty header14 = new TestObjectProperty("sec-fetch-site", ConditionType.EQUALS, "cross-site")
		TestObjectProperty header15 = new TestObjectProperty("sec-fetch-mode", ConditionType.EQUALS, "cors")
		TestObjectProperty header16 = new TestObjectProperty("sec-fetch-dest", ConditionType.EQUALS, "empty")
		TestObjectProperty header17 = new TestObjectProperty("referer", ConditionType.EQUALS, "https://shahid.mbc.net/")


		ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header6, header7, header8, header9, header10, header11, header12, header13, header14)

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("GET")
		//ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}

	@Keyword
	def evergentStatus (String URL) {
		String endpoint = URL
		String requestMethod = "POST"

		TestObjectProperty header1 = new TestObjectProperty("accept", ConditionType.EQUALS, "application/json")
		TestObjectProperty header2 = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")

		ArrayList defaultHeaders = Arrays.asList(header1, header2 )
		String body = '{"SearchAccountV2RequestMessage": {"channelPartnerID": "SHAHID","apiKey": "ga9medLeRadFSwBa","spAccountID": "2e1d8d9801b045588b88fd118a9d9562"}}'

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("POST")
		ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}
}
