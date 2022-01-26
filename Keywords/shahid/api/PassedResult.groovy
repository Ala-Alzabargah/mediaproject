package shahid.api


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




public class PassedResult {


	private String playoutResponse='-'
	public String playoutStatus='-'
	private String assetID='-'
	private String DRMStatus='-'
	private String DRMResponse='-'
	private String status='-'
	private String urlStatus='-'
	private String urlValue='-'

	@Keyword
	public String getPlayoutResponse() {
		return playoutResponse;
	}
	@Keyword
	public void setPlayoutResponse(String playoutResponse) {

		println "playoutResponse:: "+playoutResponse
		if(playoutResponse!=null)
			this.playoutResponse = playoutResponse;
	}


	@Keyword
	public String getUrlStatus() {
		return urlStatus;
	}
	@Keyword
	public void setUrlStatus(String urlStatus) {

		println "urlStatus:: "+urlStatus
		if(urlStatus!=null)
			this.urlStatus = urlStatus;
	}

	@Keyword
	public String getUrlValue() {
		return urlValue;
	}
	@Keyword
	public void setUrlValue(String urlValue) {

		println "urlValue:: "+urlValue
		if(urlStatus!=null)
			this.urlValue = urlValue;
	}

	@Keyword
	public String setPlayoutStatus() {

		return playoutStatus;
	}
	@Keyword
	public void setPlayoutStatus(String playoutStatus) {
		println "playoutStatus:: "+playoutStatus
		if(playoutStatus!=null)
			this.playoutStatus = playoutStatus;
	}

	@Keyword
	public String getAssetID() {
		return assetID;
	}
	@Keyword
	public void setAssetID(String assetID) {
		println "assetID:: "+assetID
		if(assetID!=null)
			this.assetID = assetID;
	}



	@Keyword
	public String getDRMStatus() {
		return DRMStatus;
	}
	@Keyword
	public void setDRMStatus(String DRMStatus) {
		println "DRMStatus:: "+DRMStatus
		if(DRMStatus!=null)
			this.DRMStatus = DRMStatus;
	}

	@Keyword
	public String getStatus() {
		return status;
	}
	@Keyword
	public void setStatus(String status) {
		println "status:: "+status
		if(status!=null)
			this.status = status;
	}

	@Keyword
	public String getDRMResponse() {
		return DRMResponse;
	}
	@Keyword
	public void setDRMResponse(String DRMResponse) {

		println "DRMResponse:: "+DRMResponse
		if(DRMResponse!=null)
			this.DRMResponse = DRMResponse;
	}
}
