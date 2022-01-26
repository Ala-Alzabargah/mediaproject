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
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import org.apache.http.HttpResponse as HttpResponse
import shahid.api.Result as Result
import shahid.api.Patch as Patch
import shahid.api.SubmitFail as SubmitFail
import java.io.IOException as IOException
import java.io.InputStreamReader as InputStreamReader
import java.io.UnsupportedEncodingException as UnsupportedEncodingException
import java.net.URLEncoder as URLEncoder
import java.util.ArrayList as ArrayList
import java.util.HashMap as HashMap
import java.util.Iterator as Iterator
import java.util.List as List
import java.util.Map as Map
import org.apache.commons.lang.StringUtils as StringUtils
import org.apache.http.HttpEntity as HttpEntity
import org.apache.http.NameValuePair as NameValuePair
import org.apache.http.client.HttpClient as HttpClient
import org.apache.http.client.entity.UrlEncodedFormEntity as UrlEncodedFormEntity
import org.apache.http.client.methods.HttpGet as HttpGet
import org.apache.http.client.methods.HttpPost as HttpPost
import org.apache.http.impl.client.DefaultHttpClient as DefaultHttpClient
import org.apache.http.message.BasicNameValuePair as BasicNameValuePair
import org.apache.http.util.EntityUtils as EntityUtils
import org.json.JSONException as JSONException
import org.json.JSONObject as JSONObject
import org.json.JSONArray as JSONArray
WebUI.callTestCase(findTestCase('getToken'), [:], FailureHandling.STOP_ON_FAILURE)
List ids = CustomKeywords.'shahid.api.CropResponse.getIdsList'(GlobalVariable.Movies)

for (i = 0; i < ids.size(); i++) {
    ResponseObject PlayOut = WS.sendRequest(findTestObject('Object Repository/Decode/Playout API/Playout', [('ssession') : GlobalVariable.ssession]))

    responseBody = PlayOut.getResponseBodyContent()

    String responseCode = PlayOut.getStatusCode().toString()

    jObject = new JSONObject(responseBody)

    println('jObject = ' + jObject)

    JSONObject url = jObject.get('playout')

    String ActualURL = url.getString('url')

    boolean DRM = url.get('drm')

    if (DRM) {
        GlobalVariable.itemPlayoutID = (ids[i])

        ResponseObject DRMUrl = WS.sendRequest(findTestObject('Object Repository/Decode/Playout API/drm', [('ssession') : GlobalVariable.ssession]))

        DRMresponseBody = DRMUrl.getResponseBodyContent()

        String DRMresponseCode = DRMUrl.getStatusCode().toString()

        if (DRMresponseCode != '200') {
            Result result = new Result()

            result.setURL(DRMUrl)

            result.setStatuscode(DRMresponseCode)

            result.setResponse(DRMresponseBody)

            result.setApiname((('DRM API Failed' + '\n') + 'MovieID = ') + (ID[i]))

            Patch.getInstance().addResult(result)
        }
    }
    
    if (ActualURL.contains(' ')) {
        Result result = new Result()

        result.setURL(ActualURL)

        result.setStatuscode(responseCode)

        result.setResponse(responseBody)

        result.setApiname((('Media URL Contains Space' + '\n') + 'MovieID = ') + (ids[i]))

        Patch.getInstance().addResult(result)
    }
    
    if (responseCode != '200') {
        Result result = new Result()

        result.setURL(ActualURL)

        result.setStatuscode(responseCode)

        result.setResponse(responseBody)

        result.setApiname((('APi Failed' + '\n') + 'MovieID = ') + (ids[i]))

        Patch.getInstance().addResult(result)
    }
}