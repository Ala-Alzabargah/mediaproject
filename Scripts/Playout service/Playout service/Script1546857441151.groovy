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
		
			String apiname = 'Playout-Service'
		
			String URL = "curl -X GET \
  https://api2.shahid.net/proxy/v2/playout/url/78100 \
  -H 'cache-control: no-cache'"
		
			Result result = new Result()
		
			result.setApiname(apiname)
			result.setURL(URL)
			result.setStatuscode(statuscode)
			result.setResponse(responsebody)
			
			Patch.getInstance().addResult(result)
		
			WS.verifyResponseStatusCode(res8, 200)}
	
	else {
	res9 = WS.sendRequest(findTestObject('null'))
	def responsebody = "Playout Service Works Fine"
	
		String statuscode = res9.getStatusCode().toString()
	
		String apiname = 'Playout-Service'
	
		String URL = "curl -X GET \
  https://api2.shahid.net/proxy/v2/playout/url/78100 \
  -H 'cache-control: no-cache'"
	
		Result result = new Result()
	
		result.setApiname(apiname)
		result.setURL(URL)
		result.setStatuscode(statuscode)
		result.setResponse(responsebody)
		
		Patch.getInstance().addResult(result)
	
		WS.verifyResponseStatusCode(res9, 200)}
}

else {
	def responsebody = "Playout Service Works Fine"
	
		String statuscode = res7.getStatusCode().toString()
	
		String apiname = 'Playout-Service'
	
		String URL = "curl -X GET \
  https://api2.shahid.net/proxy/v2/playout/url/78100 \
  -H 'cache-control: no-cache'"
	
		Result result = new Result()
	
		result.setApiname(apiname)
		result.setURL(URL)
		result.setStatuscode(statuscode)
		result.setResponse(responsebody)
		
		Patch.getInstance().addResult(result)
	  
		WS.verifyResponseStatusCode(res7, 200)
}
