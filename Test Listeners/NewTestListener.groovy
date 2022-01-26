import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.Before

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable 

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class NewTestListener {
	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		println "testCaseContext.getTestCaseId():: "+testCaseContext.getTestCaseId()
if(!(testCaseContext.getTestCaseId().contains('sendEmailtest') || testCaseContext.getTestCaseId().contains('Result') || testCaseContext.getTestCaseId().contains('getDrmToken')||testCaseContext.getTestCaseId().contains('getiTuensBaseToken')||testCaseContext.getTestCaseId().contains('getSsession'))) {
		if(testCaseContext.getTestCaseStatus()=='FAILED') {
			GlobalVariable.failedTestCases+=1
			println"testCaseContext:: FAILED:: GlobalVariable.failedTestCases::"+GlobalVariable.failedTestCases
		}else if(testCaseContext.getTestCaseStatus()=='PASSED'){
			GlobalVariable.passedTestCases+=1
			println"testCaseContext:: PASSED:: GlobalVariable.passedTestCases::"+GlobalVariable.passedTestCases
		}
	}
	}
	
	@BeforeTestCase
	void sampleBeforeTestCase(TestCaseContext testCaseContext) {
		WebUI.callTestCase(findTestCase('getToken'), [:], FailureHandling.STOP_ON_FAILURE)
	}
	
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		WebUI.callTestCase(findTestCase('SendEmail'), [:], FailureHandling.STOP_ON_FAILURE)

	}
}