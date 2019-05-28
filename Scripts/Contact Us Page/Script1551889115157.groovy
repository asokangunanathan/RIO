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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://rangle.io/contact-us')

WebUI.click(findTestObject('Object Repository/Contactus Objects/Page_Contact us - Get in touch with/span_'))

WebUI.click(findTestObject('Object Repository/Contactus Objects/Page_Contact us - Get in touch with/span_Other'))

WebUI.setText(findTestObject('Object Repository/Contactus Objects/Page_Contact us - Get in touch with/textarea_Test'), "$msg")

WebUI.setText(findTestObject('Object Repository/Contactus Objects/Page_Contact us - Get in touch with/input_First name_first_name'), 
    "$firstName")

WebUI.setText(findTestObject('Object Repository/Contactus Objects/Page_Contact us - Get in touch with/input_Last name_last_name'), 
    "$lastName")

WebUI.setText(findTestObject('Object Repository/Contactus Objects/Page_Contact us - Get in touch with/input_Email address_email'), 
    "$emailAddress")

WebUI.click(findTestObject('Object Repository/Contactus Objects/Page_Contact us - Get in touch with/button_Get in touch'))

WebUI.verifyTextPresent('looking forward to connecting with you', false)

WebUI.closeBrowser()

