import com.kms.katalon.core.annotation.AfterTestCase as AfterTestCase
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.annotation.BeforeTestCase as BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite as BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestSuite as AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext as TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext as TestSuiteContext
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.HttpBodyContent as HttpBodyContent
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import org.apache.http.HttpResponse as HttpResponse
import shahid.api.Result as Result
import shahid.api.Patch as Patch
import shahid.api.SubmitFail as SubmitFail


res7 = WS.sendRequest(findTestObject('Valid login/Valid login'))

code = res7.getStatusCode()

if (code != 200) {
	WebUI.delay(7)

	res8 = WS.sendRequest(findTestObject('Valid login/Valid login'))
	code2 = res8.getStatusCode()
	if (code2 != 200) {
		def responsebody = res8.getResponseBodyContent().toString()
		
			String statuscode = res8.getStatusCode().toString()
		
			String apiname = 'Valid-Login'
		
			String URL = "curl -X POST \n " +
"  'https://api2.shahid.net/proxy/v2/users/login?q=1546429302421&Accept=application/json,%20text/plain,%20%2A/%2A&Accept-Language=ar-AE&User-Agent=Mozilla/5.0%20%28Windows%20NT%2010.0;%20Win64;%20x64%29%20AppleWebKit/537.36%20%28KHTML,%20like%20Gecko%29%20Chrome/73.0.3683.86%20Safari/537.36&Referer=https://shahid.mbc.net/ar/widgets/&Origin=https://shahid.mbc.net&Content-Type=application/json' \n " +
"  -H 'Content-Type: application/json' \n " +
"  -H 'cache-control: no-cache,no-cache,no-cache,no-cache' \n " +
"  -d '{\"email\": \"AutomationUser20@mbc.net\", \"password\":\"1234567\",\"userHashedValue\":\"RkhPgXPjVXUiQVYTUPUXiUggkTYlPYQWXkiiijSXhRlVUWTShlYYRRXRWXiSSQPR\",\"captchaAnswer\":\"g8n6n\"}' ";
			Result result = new Result()
		
			result.setApiname(apiname)
			result.setURL(URL)
			result.setStatuscode(statuscode)
			result.setResponse(responsebody)
			
			Patch.getInstance().addResult(result)
		
			WS.verifyResponseStatusCode(res8, 200)}
	
	else {
	res9 = WS.sendRequest(findTestObject('Valid login/Valid login'))
	def responsebody = "User Logged in Successfully"
	
		String statuscode = res9.getStatusCode().toString()
	
		String apiname = 'Valid-Login'
	
		String URL = "curl -X POST \n " +
"  'https://api2.shahid.net/proxy/v2/users/login?q=1546429302421&Accept=application/json,%20text/plain,%20%2A/%2A&Accept-Language=ar-AE&User-Agent=Mozilla/5.0%20%28Windows%20NT%2010.0;%20Win64;%20x64%29%20AppleWebKit/537.36%20%28KHTML,%20like%20Gecko%29%20Chrome/73.0.3683.86%20Safari/537.36&Referer=https://shahid.mbc.net/ar/widgets/&Origin=https://shahid.mbc.net&Content-Type=application/json' \n " +
"  -H 'Content-Type: application/json' \n " +
"  -H 'cache-control: no-cache,no-cache,no-cache,no-cache' \n " +
"  -d '{\"email\": \"AutomationUser20@mbc.net\", \"password\":\"1234567\",\"userHashedValue\":\"RkhPgXPjVXUiQVYTUPUXiUggkTYlPYQWXkiiijSXhRlVUWTShlYYRRXRWXiSSQPR\",\"captchaAnswer\":\"g8n6n\"}' ";
		Result result = new Result()
	
		result.setApiname(apiname)
		result.setURL(URL)
		result.setStatuscode(statuscode)
		result.setResponse(responsebody)
		
		Patch.getInstance().addResult(result)
	
		WS.verifyResponseStatusCode(res9, 200)}
}

else {
	def responsebody = "User Logged in Successfully"
	
		String statuscode = res7.getStatusCode().toString()
	
		String apiname = 'Valid-Login'
	
		String URL = "curl -X POST \n " +
"  'https://api2.shahid.net/proxy/v2/users/login?q=1546429302421&Accept=application/json,%20text/plain,%20%2A/%2A&Accept-Language=ar-AE&User-Agent=Mozilla/5.0%20%28Windows%20NT%2010.0;%20Win64;%20x64%29%20AppleWebKit/537.36%20%28KHTML,%20like%20Gecko%29%20Chrome/73.0.3683.86%20Safari/537.36&Referer=https://shahid.mbc.net/ar/widgets/&Origin=https://shahid.mbc.net&Content-Type=application/json' \n " +
"  -H 'Content-Type: application/json' \n " +
"  -H 'cache-control: no-cache,no-cache,no-cache,no-cache' \n " +
"  -d '{\"email\": \"AutomationUser20@mbc.net\", \"password\":\"1234567\",\"userHashedValue\":\"RkhPgXPjVXUiQVYTUPUXiUggkTYlPYQWXkiiijSXhRlVUWTShlYYRRXRWXiSSQPR\",\"captchaAnswer\":\"g8n6n\"}' ";
	
		Result result = new Result()
	
		result.setApiname(apiname)
		result.setURL(URL)
		result.setStatuscode(statuscode)
		result.setResponse(responsebody)
		
		Patch.getInstance().addResult(result)
	  
		WS.verifyResponseStatusCode(res7, 200)
}
