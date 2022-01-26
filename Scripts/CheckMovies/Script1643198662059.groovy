import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import org.apache.commons.lang.StringUtils as StringUtils
import org.json.JSONObject as JSONObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import shahid.api.*

List ids = new CropResponse().getIdsList(GlobalVariable.Movies)

String statusCode
def responseBody

boolean DRM
String DRMStatusCode
def DRMresponseBody

boolean urlFlag=true

boolean DRMFlag=true

String url

for (i = 0; i < ids.size(); i++) {
    PassedResult passedResult = new PassedResult()

    FailedResult failedResult = new FailedResult()

    //Playout try
    try {
        GlobalVariable.itemPlayoutID = ids[i]
		passedResult.setAssetID(GlobalVariable.itemPlayoutID)
		failedResult.setAssetID(GlobalVariable.itemPlayoutID )

        println('******** GlobalVariable.itemPlayoutID :: ' + GlobalVariable.itemPlayoutID )

        ResponseObject PlayOut = WS.sendRequest(findTestObject('Object Repository/Decode/Playout API/Playout', [('ssession') : GlobalVariable.ssession ,('token') : GlobalVariable.Token ]))

        responseBody = PlayOut.getResponseBodyContent()

        statusCode = PlayOut.getStatusCode()

        if (WS.verifyResponseStatusCode(PlayOut, 200)) {

            jObject = new JSONObject(responseBody)

            println((('jObject::  ' + jObject) + '\n url: ') + responseBody)

            DRM = jObject.get('playout').get('drm')
			url= jObject.get('playout').get('url')
            println('******* DRM:: ' + DRM)
			println('******* url:: ' + url)
			
			//verify uri spaces
			if (url.contains(' ')) {
				failedResult.setUrlStatus('Media URL Contains Space')
				failedResult.setUrlValue(url)
				urlFlag=false
			}
			
            //verify DRM
            if (DRM) {
                ResponseObject DRMUrl = WS.sendRequest(findTestObject('Object Repository/Decode/Playout API/drm', [('ssession') : GlobalVariable.ssession]))

                DRMresponseBody = DRMUrl.getResponseBodyContent()

                DRMStatusCode = DRMUrl.getStatusCode()

                //DRM try
                try {
                    if (WS.verifyResponseStatusCode(DRMUrl, 200)) {
						
                        //Passed DRM
                        passedResult.setDRMStatus('DRM API Passed')
                        passedResult.setDRMResponse(DRMresponseBody)
                    }
                }
                //DRM catch
                catch (Exception e) {
                    //failed DRM
                    failedResult.setDRMStatus("DRM API Failed")
                    failedResult.setDRMResponse(DRMresponseBody)
					DRMFlag=false
                    KeywordUtil.markFailed('*********** e:: ' + e)
                } 
            }
			
            passedResult.setPlayoutStatus('Playout API Passed')
            passedResult.setPlayoutResponse(responseBody)
			if(urlFlag && DRMFlag) {
            passedResult.setStatus('Passed')
			MoviesPassedPatch.getMoviesPassedInstance().addMoviesPassedResult(passedResult)
			}else {
			failedResult.setStatus('Failed')
			MoviesFailedPatch.getMoviesFailedInstance().addMoviesFailedResult(failedResult)
            }

            
        }
    }
    //Playout catch
    catch (Exception e) {
        //failed playout
        failedResult.setPlayoutStatus('Playout API Failed')
        failedResult.setPlayoutResponse(responseBody)
        failedResult.setStatus('Failed')
        MoviesFailedPatch.getMoviesFailedInstance().addMoviesFailedResult(failedResult)

        KeywordUtil.markFailed('*********** e:: ' + e)
    } 
}