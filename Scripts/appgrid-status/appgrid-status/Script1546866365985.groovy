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



    res32 = WS.sendRequest(findTestObject('null'))

	code = res32.getStatusCode()
	if (code == 200) { 
		
	def responsebody = "Appgrid-Status API Executed Successfully"

	String statuscode = res32.getStatusCode().toString()

	String apiname = 'Appgrid-Status'

	String URL = "curl -X GET \
  https://shahid.mbc.net/appgrid/status \
  -H 'cache-control: no-cache,no-cache'"

	Result result = new Result()

	result.setApiname(apiname)
	result.setURL(URL)
	result.setStatuscode(statuscode)
	result.setResponse(responsebody)
	
	Patch.getInstance().addResult(result)
	
	WS.verifyResponseStatusCode(res32, 200) }
	
	else {
		
		def responsebody = res32.getResponseBodyContent().toString()
		
			String statuscode = res32.getStatusCode().toString()
		
			String apiname = 'Appgrid-Status'
		
			String URL = 'https://shahid.mbc.net/appgrid/status?'
		
			Result result = new Result()
		
			result.setApiname(apiname)
			result.setURL(URL)
			result.setStatuscode(statuscode)
			result.setResponse(responsebody)
			
			Patch.getInstance().addResult(result)
			
			WS.verifyResponseStatusCode(res32, 200)
		
	}
