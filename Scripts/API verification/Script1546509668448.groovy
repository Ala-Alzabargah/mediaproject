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



//################################ List of production Url ##########################

String editorialRequest = 'https://api2.shahid.net/proxy/v2/editorial?request=%7B%22id%22%3A%22_Accedo-GCC_content_011%22%2C%22pageNumber%22%3A0%2C%22pageSize%22%3A10%7D'
String staticPage = 'https://shahid.net/ar/applications'
String newLogin = 'https://shahid.mbc.net/ar/widgets/#/login'
String mobileAppJson = 'https://api.shahid.net/mobileapps.json?v2'
String login = 'https://shahid.mbc.net/static/shahid/widget/widgets.html?widget=login&env=prod&redirect='
String appGrid = 'https://shahid.mbc.net/appgrid/status?'
String search = 'https://api2.shahid.net/proxy/v2/search/quick?request=%7B%22name%22%3A%22%D8%A8%D8%A7%D8%A8%20%D8%A7%D9%84%D8%AD%D8%A7%D8%B1%D8%A9%22%2C%22pageNumber%22%3A0%2C%22pageSize%22%3A4%7D'
String tvPairing = 'https://api.shahid.net/api//v2/user/paring/generateDeviceRendezvous/?hash=b2wMCTHpSmyxGqQjJFOycRmLSex%2BBpTK%2Fooxy6vHaqs%3D&apiKey=sh%40hid0nlin3'
String apiPing = 'https://api2.shahid.net/proxy/v2/ping/?39aa4ce2-0616-0eb8-0b5b-a5e23d8cd93d=shahid&_=1522001913671?dsds'
String accedooEditorial= 'https://api2.shahid.net/proxy/v2/editorial?request=%7B%22id%22%3A%22_Accedo-WW_content_015%22%2C%22pageNumber%22%3A0%2C%22pageSize%22%3A10%7D'
String playOutService299412 = 'https://api2.shahid.net/proxy/v2/playout/url/78100'
String validLogin = 'https://api2.shahid.net/proxy/v2/users/login?q=1546429302421'
String registerationPage = 'https://api2.shahid.net/proxy/v2/users/login?q=1546429302421'
String homePage = 'https://shahid.mbc.net/ar/'
String playPlus = 'https://api.shahid.net/api/v2/media/311867/sam?hash=b2wMCTHpSmyxGqQjJFOycRmLSex%2BBpTK%2Fooxy6vHaqs%3D&apiKey=sh%40hid0nlin3'
String appGridMeta = 'https://api.shahid.net/api/v2/media/311867/sam?hash=b2wMCTHpSmyxGqQjJFOycRmLSex%2BBpTK%2Fooxy6vHaqs%3D&apiKey=sh%40hid0nlin3'
String appGridAsset = 'https://shahid.mbc.net/appgrid/asset?'
String playerPage = 'https://shahid.mbc.net/ar/shows/%D8%B5%D8%A8%D8%A7%D8%AD-%D8%A7%D9%84%D8%AE%D9%8A%D8%B1-%D9%8A%D8%A7-%D8%B9%D8%B1%D8%A8-%D8%A7%D9%84%D9%85%D9%88%D8%B3%D9%85-2017-%D8%A7%D9%84%D8%AD%D9%84%D9%82%D8%A9-210/episode-285648'
String vikimap = 'https://shahid.mbc.net/vikimap/entry/595c8706a0e8450006cde667'

//#########################################################################################################
//###### Verifiy Url , Expected Response Code , Number of Attempts before failure ###############################


CustomKeywords.'VerifyCode.test2'(editorialRequest, '200', 2)
CustomKeywords.'VerifyCode.test2'(staticPage, '200', 2)
CustomKeywords.'VerifyCode.test2'(newLogin, '200', 2)
CustomKeywords.'VerifyCode.test2'(mobileAppJson, '200', 2)
CustomKeywords.'VerifyCode.test2'(login, '200', 2)
CustomKeywords.'VerifyCode.test2'(appGrid, '200', 2)
CustomKeywords.'VerifyCode.test2'(search, '200', 2)
//CustomKeywords.'VerifyCode.test2'(tvPairing, '200', 2)
CustomKeywords.'VerifyCode.test2'(apiPing, '200', 2)
CustomKeywords.'VerifyCode.test2'(accedooEditorial, '200', 2)
CustomKeywords.'VerifyCode.test2'(playOutService299412, '200', 2)
//CustomKeywords.'VerifyCode.test2'(validLogin, '200', 2)
CustomKeywords.'VerifyCode.test2'(registerationPage, '200', 2)
CustomKeywords.'VerifyCode.test2'(homePage, '200', 2)
CustomKeywords.'VerifyCode.test2'(playPlus, '200', 2)
CustomKeywords.'VerifyCode.test2'(appGridMeta, '300', 2)
CustomKeywords.'VerifyCode.test2'(appGridAsset, '300', 2)
CustomKeywords.'VerifyCode.test2'(vikimap, '200', 2)

//########################################################






