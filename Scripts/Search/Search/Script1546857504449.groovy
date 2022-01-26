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



    res9 = WS.sendRequest(findTestObject('Search/Search'))
	code = res9.getStatusCode()
	if (code == 200) {
    def responsebody = "Searching Functionality Works Fine"

	String statuscode = res9.getStatusCode().toString()

	String apiname = 'Search'

	String URL = "curl -X GET \
  'https://api2.shahid.net/proxy/v2/search/quick?request=%7B%22name%22%3A%22%D8%A8%D8%A7%D8%A8%20%D8%A7%D9%84%D8%AD%D8%A7%D8%B1%D8%A9%22%2C%22pageNumber%22%3A0%2C%22pageSize%22%3A4%7D' \
  -H 'cache-control: no-cache'"

	Result result = new Result()

	result.setApiname(apiname)
	result.setURL(URL)
	result.setStatuscode(statuscode)
	result.setResponse(responsebody)
	
	Patch.getInstance().addResult(result)
    WS.verifyResponseStatusCode(res9, 200) }
	
	
	else {
		def responsebody = res9.getResponseBodyContent().toString()
		
			String statuscode = res9.getStatusCode().toString()
		
			String apiname = 'Search'
		
			String URL = "curl -X GET \
  'https://api2.shahid.net/proxy/v2/search/quick?request=%7B%22name%22%3A%22%D8%A8%D8%A7%D8%A8%20%D8%A7%D9%84%D8%AD%D8%A7%D8%B1%D8%A9%22%2C%22pageNumber%22%3A0%2C%22pageSize%22%3A4%7D' \
  -H 'cache-control: no-cache'"
		
			Result result = new Result()
		
			result.setApiname(apiname)
			result.setURL(URL)
			result.setStatuscode(statuscode)
			result.setResponse(responsebody)
			
			Patch.getInstance().addResult(result)
			WS.verifyResponseStatusCode(res9, 200)
		
		
	}
	
	
	