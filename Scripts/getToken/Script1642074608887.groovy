import org.json.JSONObject as JSONObject
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import shahid.api.*
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

String Ssession = new SendMediaReq().getSssesion()

println('Ssession:: ' + Ssession)

int count = 4

for (int i = 0; i < count; i++) {
    ResponseObject authenticate = WS.sendRequest(findTestObject('Object Repository/newPostmanAPIs/validateLogin', [('ssession') : Ssession]))

    println('authenticate:: ' + authenticate)

    try {
        WS.verifyResponseStatusCode(authenticate, 200)

        user = new JSONObject(authenticate.responseBodyContent)

        String token = user.get('user').get('sessionId')

        String userId = user.get('user').get('id')

        String userEmail = user.get('user').get('email')

        GlobalVariable.Token = token

        println('tokenValue::' + GlobalVariable.Token)

        GlobalVariable.userId = userId

        GlobalVariable.userEmail = userEmail

        KeywordUtil.markPassed('Response status codes match')

        break
    }
    catch (Exception e) {
        if (i < (count - 1)) {
            WebUI.delay(5)

            continue
        } else {
            statuscode = authenticate.getStatusCode()

            KeywordUtil.markFailed((('Response status code not match. Expected: ' + '200') + ' - Actual: ') + statuscode)
        }
    } 
}


