import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.BASE_URL)

WebUI.click(findTestObject('Page/Login/Button/btn_login'))

WebUI.setText(findTestObject('Page/Login/InputField/input_Username_j_username'), GlobalVariable.USER_NAME)

WebUI.setEncryptedText(findTestObject('Page/Login/InputField/input_Password_j_password'), GlobalVariable.PASSWORD)

WebUI.click(findTestObject('Page/Login/Button/btn_submit'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_My Expenses'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_My Inbox 0'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Submitted Expenses 0'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Approved Expenses 0'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Rejected Expenses 0'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Closed Expenses 1'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Approver List'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Approver Inbox 0'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Finance List'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Finance Inbox 0'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_All Expenses History (1)'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Setup Categories'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Import Categories'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Info'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Joget Resources'))

WebUI.closeBrowser()

