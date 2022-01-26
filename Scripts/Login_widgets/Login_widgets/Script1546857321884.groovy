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


res26 = WS.sendRequest(findTestObject('null'))

code = res26.getStatusCode()

if (code != 200) {
    WebUI.delay(7)

    res27 = WS.sendRequest(findTestObject('null'))
	code2 = res27.getStatusCode()
	if (code2 != 200) {
		def responsebody = res27.getResponseBodyContent().toString()
		
			String statuscode = res27.getStatusCode().toString()
		
			String apiname = 'Login-widgets'
		
			String URL = "curl -X GET \
  'https://shahid.mbc.net/ar/widgets/#/login' \
  -H 'cache-control: no-cache'"
		
			Result result = new Result()
		
			result.setApiname(apiname)
			result.setURL(URL)
			result.setStatuscode(statuscode)
			result.setResponse(responsebody)
			
			Patch.getInstance().addResult(result)
		
			WS.verifyResponseStatusCode(res27, 200)}
	
	else {
	res28 = WS.sendRequest(findTestObject('null'))
	def responsebody = "Login-widgets API Executed Successfully"
	
		String statuscode = res28.getStatusCode().toString()
	
		String apiname = 'Login-widgets'
	
		String URL = "curl -X GET \
  'https://shahid.mbc.net/ar/widgets/#/login' \
  -H 'cache-control: no-cache'"
	
		Result result = new Result()
	
		result.setApiname(apiname)
		result.setURL(URL)
		result.setStatuscode(statuscode)
		result.setResponse(responsebody)
		
		Patch.getInstance().addResult(result)
	
		WS.verifyResponseStatusCode(res28, 200)}
}

else {
	def responsebody = "Login-widgets API Executed Successfully"
	
		String statuscode = res26.getStatusCode().toString()
	
		String apiname = 'Login-widgets'
	
		String URL = "curl -X GET \
  'https://shahid.mbc.net/ar/widgets/#/login' \
  -H 'cache-control: no-cache'"
	
		Result result = new Result()
	
		result.setApiname(apiname)
		result.setURL(URL)
		result.setStatuscode(statuscode)
		result.setResponse(responsebody)
		
		Patch.getInstance().addResult(result)
      
		WS.verifyResponseStatusCode(res26, 200)
}
