
package shahid.api
import internal.GlobalVariable

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CropResponse {




	@Keyword
	public static HttpResponse get(String requestUrl) throws IOException {

		final HttpGet request = new HttpGet(requestUrl);
		final HttpResponse response = new DefaultHttpClient().execute(request);
		return response;
	}

	@Keyword
	public static JsonNode getAsJson(String requestUrl) throws Exception {

		final HttpResponse httpResponse = get(requestUrl);
		final int statusCode = httpResponse.getStatusLine().getStatusCode();
		final String statusDesc = httpResponse.getStatusLine().getReasonPhrase();
		final String statusSummary = statusCode == 200? "succeeded": "failed";

		//	System.out.println("Http Request [" + requestUrl + "] has " + statusSummary + " (" + statusCode + " - " + statusDesc + ")");

		if (statusCode != 200) {
			// TODO
		}

		final InputStreamReader responseReader = new InputStreamReader(httpResponse.getEntity().getContent());
		final JsonNode resultNode = new ObjectMapper().readTree(responseReader);

		try {
			responseReader.close();
		} catch (IOException e) {
		}

		return resultNode;
	}

	@Keyword
	def public static List getIdsList(String Type) {
		
		
				//			String jsonString = "{\"pageNumber\":0,\"pageSize\":30,\"productType\":\"ASSET\",\"productSubType\":\"" + Type + "\",\"sorts\":[{\"order\":\"DESC\",\"type\":\"SORTDATE\"}]}";
				//
				//		}
				//
				//		else {
				String jsonString = "{\"pageNumber\":0,\"pageSize\":30,\"productType\":\"ASSET\",\"productSubType\":\"" + Type + "\",\"sorts\":[{\"order\":\"DESC\",\"type\":\"SORTDATE\"}]}";
		
		
				try {
					jsonString = URLEncoder.encode(jsonString, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				String requestUrl
		
				if (Type == "MOVIE"){
					 requestUrl =GlobalVariable.endpointV2+"product/filter?filter=%7B%22pageNumber%22%3A0%2C%22pageSize%22%3A30%2C%22productType%22%3A%22MOVIE%22%2C%22sorts%22%3A%5B%7B%22order%22%3A%22DESC%22%2C%22type%22%3A%22SORTDATE%22%7D%5D%7D"
				}
				else {
					 requestUrl = GlobalVariable.endpointV2+"product/filter?filter=" + jsonString;
				}
				final List<String> ids = new ArrayList<String>();
		
		
				try {
					 JsonNode response = getAsJson(requestUrl);
					 println "response:: "+response
					final JsonNode productList = response.get("productList");
					final JsonNode productsList = productList.get("products");
					final Iterator<JsonNode> products = productsList.elements();
					while (products.hasNext()) {
						final JsonNode product = products.next();
						final String id = product.get("id").toString();
						ids.add(id);
						ids.size()
										System.out.println(id);
		
		
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		
				return ids;

		


	}

}



