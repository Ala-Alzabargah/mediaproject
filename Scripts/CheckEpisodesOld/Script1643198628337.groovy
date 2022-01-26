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
import com.kms.katalon.core.testobject.ResponseObject
import org.apache.http.HttpResponse as HttpResponse
import shahid.api.Result as Result
import shahid.api.Patch as Patch
import shahid.api.SubmitFail as SubmitFail
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject
import org.json.JSONArray;
import org.json.JSONObject;
import shahid.api.*

List ids = new CropResponse().getIdsList(GlobalVariable.Episodes)


for (i = 0; i < ids.size(); i++) {


ResponseObject PlayOut = WS.sendRequest(findTestObject('Object Repository/Decode/Playout API/Playout',[('ssession') : GlobalVariable.ssession]))
responseBody =  PlayOut.getResponseBodyContent()
String responseCode = PlayOut.getStatusCode().toString()

jObject = new JSONObject(responseBody);
println "jObject = " +  jObject
JSONObject url = jObject.get("playout")

String ActualURL = url.getString("url")
boolean DRM = url.get("drm")

if(DRM){
	GlobalVariable.itemPlayoutID=ids[i]
	ResponseObject DRMUrl = WS.sendRequest(findTestObject('Object Repository/Decode/Playout API/drm',[('ssession') : GlobalVariable.ssession]))
	
	DRMresponseBody =  DRMUrl.getResponseBodyContent()
	String DRMresponseCode = DRMUrl.getStatusCode().toString()
	if (DRMresponseCode != "200")
	{
		
		Result result = new Result()
		result.setURL(DRMUrl)
		result.setStatuscode(DRMresponseCode)
		result.setResponse(DRMresponseBody)
		result.setApiname("DRM API Failed"+"\n"+"EpisodeID = "+ ids [i])
		Patch.getInstance().addResult(result)
	}
	
}



if (ActualURL.contains(" ")) {
Result result = new Result()
	result.setURL(ActualURL)
	result.setStatuscode(responseCode)
	result.setResponse(responseBody)
	result.setApiname("Media URL Contains Space"+"\n"+"EpisodeID = " + ids [i])
	Patch.getInstance().addResult(result)

}
	
	if (responseCode != "200" ){
Result result = new Result()
	result.setURL(ActualURL)
	result.setStatuscode(responseCode)
	result.setResponse(responseBody)
	result.setApiname("APi Failed"+"\n"+"EpisodeID = " + ids [i])
	Patch.getInstance().addResult(result)
	
}
	
	
}






