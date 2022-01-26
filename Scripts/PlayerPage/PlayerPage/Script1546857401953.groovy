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



    res6 = WS.sendRequest(findTestObject('null'))
	code = res6.getStatusCode()
	if (code == 200) {
    def responsebody = "Player Page Opened Successfully"

	String statuscode = res6.getStatusCode().toString()

	String apiname = 'Player-Page'

	String URL = "curl -X GET \
  https://shahid.mbc.net/ar/shows/%D8%B5%D8%A8%D8%A7%D8%AD-%D8%A7%D9%84%D8%AE%D9%8A%D8%B1-%D9%8A%D8%A7-%D8%B9%D8%B1%D8%A8-%D8%A7%D9%84%D9%85%D9%88%D8%B3%D9%85-2017-%D8%A7%D9%84%D8%AD%D9%84%D9%82%D8%A9-210/episode-285648 \
  -H 'cache-control: no-cache'"

	Result result = new Result()

	result.setApiname(apiname)
	result.setURL(URL)
	result.setStatuscode(statuscode)
	result.setResponse(responsebody)
	
	Patch.getInstance().addResult(result)
	WS.verifyResponseStatusCode(res6, 200) }
	
	else {
		
		def responsebody = res6.getResponseBodyContent().toString()
		
			String statuscode = res6.getStatusCode().toString()
		
			String apiname = 'Player-Page'
		
			String URL = "curl -X GET \
  https://shahid.mbc.net/ar/shows/%D8%B5%D8%A8%D8%A7%D8%AD-%D8%A7%D9%84%D8%AE%D9%8A%D8%B1-%D9%8A%D8%A7-%D8%B9%D8%B1%D8%A8-%D8%A7%D9%84%D9%85%D9%88%D8%B3%D9%85-2017-%D8%A7%D9%84%D8%AD%D9%84%D9%82%D8%A9-210/episode-285648 \
  -H 'cache-control: no-cache'"
		
			Result result = new Result()
		
			result.setApiname(apiname)
			result.setURL(URL)
			result.setStatuscode(statuscode)
			result.setResponse(responsebody)
			
			Patch.getInstance().addResult(result)
			WS.verifyResponseStatusCode(res6, 200)
	}
