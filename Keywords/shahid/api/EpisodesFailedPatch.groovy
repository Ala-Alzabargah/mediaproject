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


import java.util.ArrayList;
import java.util.List;
public class EpisodesFailedPatch {

	private static EpisodesFailedPatch instance;

	@Keyword
	private Patch2() {}

	@Keyword
	public static EpisodesFailedPatch getEpisodesFailedInstance() {

		if (instance == null) {

			instance = new EpisodesFailedPatch();
		}
		return instance;
	}

	@Keyword
	private final List<FailedResult> results = new ArrayList<FailedResult>();
	private String timestamp;

	@Keyword
	public List<FailedResult> getEpisodesFailedResults() {
		return results;
	}

	@Keyword
	public void addEpisodesFailedResult(FailedResult result2) {
		this.results.add(result2);
	}

	@Keyword
	public String getTimestamp() {
		return timestamp;
	}

	@Keyword
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
