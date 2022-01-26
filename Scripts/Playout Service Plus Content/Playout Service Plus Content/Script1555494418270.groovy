import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.apache.http.HttpResponse as HttpResponse
import shahid.api.Result as Result
import shahid.api.Patch as Patch
import shahid.api.SubmitFail as SubmitFail


res7 = WS.sendRequest(findTestObject('null'))

code = res7.getStatusCode()

if (code != 200) {
	WebUI.delay(7)

	res8 = WS.sendRequest(findTestObject('null'))
	code2 = res8.getStatusCode()
	if (code2 != 200) {
		def responsebody = res8.getResponseBodyContent().toString()
		
			String statuscode = res8.getStatusCode().toString()
		
			String apiname = 'Playout Service Plus Content'
		
			String URL = "curl -X GET \
  https://api2.shahid.net/proxy/v2/playout/url/333538 \
  -H 'Accept: application/json' \
  -H 'Accept-Language: en-US,en;q=0.5' \
  -H 'Authorization: AWS4-HMAC-SHA256 Credential=AKIAI6X4TYCIXM2B7MUQ/20190417/us-east-1/execute-api/aws4_request, SignedHeaders=accept;browser_name;browser_version;host;os_version;shahid_os;token;x-amz-date;x-api-key, Signature=08a75b05ae01a013eef11990fd66c48b8141073ee57f0d8342c394e20596b2d7' \
  -H 'BROWSER_NAME: FIREFOX' \
  -H 'BROWSER_VERSION: 66.0' \
  -H 'Connection: keep-alive' \
  -H 'Content-Type: application/json' \
  -H 'OS_VERSION: 10' \
  -H 'Origin: https://shahid.mbc.net' \
  -H 'Postman-Token: 2fc72f48-4956-428e-8421-8b44df99fb93' \
  -H 'Referer: https://shahid.mbc.net/ar/movies/%D8%A3%D8%AE%D9%84%D8%A7%D9%82-%D8%A7%D9%84%D8%B9%D8%A8%D9%8A%D8%AF/movie-333538' \
  -H 'SHAHID_OS: WINDOWS' \
  -H 'User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0' \
  -H 'cache-control: no-cache' \
  -H 'token: eyJhbGciOiJIUzI1NiJ9.eyJjYWNoZSI6IlVzZXJfNzEwOTM0MDEiLCJ1aWQiOiJhcHIxU2hhaGlkRW5EeDRZd3NOa1hPcU5MM0tiNXoyTzgxIiwiZGlkIjoiV2ViIiwic3ViaWQiOjcxMDkzNDAxLCJzdWIiOiJzaGFoaWQtdG9rZW4tZW5jb2RlIiwiaXNzIjoic2hhaGlkLXRva2VuLWVuY29kZSIsImlhdCI6MTU1NTQ4ODc2NiwiZXhwIjoxNTg3MTExMTY2fQ.FCs-thQYMs459P1vB8J7CNtA0oZRY3qNKOjiCFO9I94' \
  -H 'x-amz-date: 20190417T081416Z' \
  -H 'x-api-key: 2RRtuMHx95aNI1Kvtn2rChEuwsCogUd4samGPjLh'"
		
			Result result = new Result()
		
			result.setApiname(apiname)
			result.setURL(URL)
			result.setStatuscode(statuscode)
			result.setResponse(responsebody)
			
			Patch.getInstance().addResult(result)
		
			WS.verifyResponseStatusCode(res8, 200)}
	
	else {
	res9 = WS.sendRequest(findTestObject('null'))
	def responsebody = "Playout Service For Plus Content Works Fine"
	
		String statuscode = res9.getStatusCode().toString()
	
		String apiname = 'Playout Service For Plus Content'
	
		String URL = "curl -X GET \
  https://api2.shahid.net/proxy/v2/playout/url/333538 \
  -H 'Accept: application/json' \
  -H 'Accept-Language: en-US,en;q=0.5' \
  -H 'Authorization: AWS4-HMAC-SHA256 Credential=AKIAI6X4TYCIXM2B7MUQ/20190417/us-east-1/execute-api/aws4_request, SignedHeaders=accept;browser_name;browser_version;host;os_version;shahid_os;token;x-amz-date;x-api-key, Signature=08a75b05ae01a013eef11990fd66c48b8141073ee57f0d8342c394e20596b2d7' \
  -H 'BROWSER_NAME: FIREFOX' \
  -H 'BROWSER_VERSION: 66.0' \
  -H 'Connection: keep-alive' \
  -H 'Content-Type: application/json' \
  -H 'OS_VERSION: 10' \
  -H 'Origin: https://shahid.mbc.net' \
  -H 'Postman-Token: 2fc72f48-4956-428e-8421-8b44df99fb93' \
  -H 'Referer: https://shahid.mbc.net/ar/movies/%D8%A3%D8%AE%D9%84%D8%A7%D9%82-%D8%A7%D9%84%D8%B9%D8%A8%D9%8A%D8%AF/movie-333538' \
  -H 'SHAHID_OS: WINDOWS' \
  -H 'User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0' \
  -H 'cache-control: no-cache' \
  -H 'token: eyJhbGciOiJIUzI1NiJ9.eyJjYWNoZSI6IlVzZXJfNzEwOTM0MDEiLCJ1aWQiOiJhcHIxU2hhaGlkRW5EeDRZd3NOa1hPcU5MM0tiNXoyTzgxIiwiZGlkIjoiV2ViIiwic3ViaWQiOjcxMDkzNDAxLCJzdWIiOiJzaGFoaWQtdG9rZW4tZW5jb2RlIiwiaXNzIjoic2hhaGlkLXRva2VuLWVuY29kZSIsImlhdCI6MTU1NTQ4ODc2NiwiZXhwIjoxNTg3MTExMTY2fQ.FCs-thQYMs459P1vB8J7CNtA0oZRY3qNKOjiCFO9I94' \
  -H 'x-amz-date: 20190417T081416Z' \
  -H 'x-api-key: 2RRtuMHx95aNI1Kvtn2rChEuwsCogUd4samGPjLh'"
	
		Result result = new Result()
	
		result.setApiname(apiname)
		result.setURL(URL)
		result.setStatuscode(statuscode)
		result.setResponse(responsebody)
		
		Patch.getInstance().addResult(result)
	
		WS.verifyResponseStatusCode(res9, 200)}
}

else {
	def responsebody = "Playout Service For Plus Content Works Fine"
	
		String statuscode = res7.getStatusCode().toString()
	
		String apiname = 'Playout Service For Plus Content'
	
		String URL = "curl -X GET \
  https://api2.shahid.net/proxy/v2/playout/url/333538 \
  -H 'Accept: application/json' \
  -H 'Accept-Language: en-US,en;q=0.5' \
  -H 'Authorization: AWS4-HMAC-SHA256 Credential=AKIAI6X4TYCIXM2B7MUQ/20190417/us-east-1/execute-api/aws4_request, SignedHeaders=accept;browser_name;browser_version;host;os_version;shahid_os;token;x-amz-date;x-api-key, Signature=08a75b05ae01a013eef11990fd66c48b8141073ee57f0d8342c394e20596b2d7' \
  -H 'BROWSER_NAME: FIREFOX' \
  -H 'BROWSER_VERSION: 66.0' \
  -H 'Connection: keep-alive' \
  -H 'Content-Type: application/json' \
  -H 'OS_VERSION: 10' \
  -H 'Origin: https://shahid.mbc.net' \
  -H 'Postman-Token: 2fc72f48-4956-428e-8421-8b44df99fb93' \
  -H 'Referer: https://shahid.mbc.net/ar/movies/%D8%A3%D8%AE%D9%84%D8%A7%D9%82-%D8%A7%D9%84%D8%B9%D8%A8%D9%8A%D8%AF/movie-333538' \
  -H 'SHAHID_OS: WINDOWS' \
  -H 'User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0' \
  -H 'cache-control: no-cache' \
  -H 'token: eyJhbGciOiJIUzI1NiJ9.eyJjYWNoZSI6IlVzZXJfNzEwOTM0MDEiLCJ1aWQiOiJhcHIxU2hhaGlkRW5EeDRZd3NOa1hPcU5MM0tiNXoyTzgxIiwiZGlkIjoiV2ViIiwic3ViaWQiOjcxMDkzNDAxLCJzdWIiOiJzaGFoaWQtdG9rZW4tZW5jb2RlIiwiaXNzIjoic2hhaGlkLXRva2VuLWVuY29kZSIsImlhdCI6MTU1NTQ4ODc2NiwiZXhwIjoxNTg3MTExMTY2fQ.FCs-thQYMs459P1vB8J7CNtA0oZRY3qNKOjiCFO9I94' \
  -H 'x-amz-date: 20190417T081416Z' \
  -H 'x-api-key: 2RRtuMHx95aNI1Kvtn2rChEuwsCogUd4samGPjLh'"
	
		Result result = new Result()
	
		result.setApiname(apiname)
		result.setURL(URL)
		result.setStatuscode(statuscode)
		result.setResponse(responsebody)
		
		Patch.getInstance().addResult(result)
	  
		WS.verifyResponseStatusCode(res7, 200)
}
