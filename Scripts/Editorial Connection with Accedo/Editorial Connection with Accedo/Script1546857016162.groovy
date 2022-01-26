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



    res1 = WS.sendRequest(findTestObject('null'))
	code = res1.getStatusCode()
	if (code == 200) {
    def responsebody = "Editorial-Connection-With-Accedo API Executed Successfully"

	String statuscode = res1.getStatusCode().toString()

	String apiname = 'Editorial-Connection-With-Accedo'

	String URL = "curl -X GET \
  'https://api2.shahid.net/proxy/v2/editorial?request=%7B%22id%22%3A%22_Accedo-WW_content_015%22%2C%22pageNumber%22%3A0%2C%22pageSize%22%3A10%7D' \
  -H 'cache-control: no-cache'"
	Result result = new Result()

	result.setApiname(apiname)
	result.setURL(URL)
	result.setStatuscode(statuscode)
	result.setResponse(responsebody)
	
	Patch.getInstance().addResult(result)
	WS.verifyResponseStatusCode(res1, 200) }
	
	
	else {
		def responsebody = res1.getResponseBodyContent().toString()
		
			String statuscode = res1.getStatusCode().toString()
		
			String apiname = 'Editorial-Connection-With-Accedo'
		
			String URL = "curl -X GET \
  'https://api2.shahid.net/proxy/v2/editorial?request=%7B%22id%22%3A%22_Accedo-WW_content_015%22%2C%22pageNumber%22%3A0%2C%22pageSize%22%3A10%7D' \
  -H 'cache-control: no-cache'"
		
			Result result = new Result()
		
			result.setApiname(apiname)
			result.setURL(URL)
			result.setStatuscode(statuscode)
			result.setResponse(responsebody)
			
			Patch.getInstance().addResult(result)
			WS.verifyResponseStatusCode(res1, 200)
				
	}
	