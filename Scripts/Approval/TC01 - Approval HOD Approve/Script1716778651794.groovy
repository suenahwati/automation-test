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

'Memanggil Method Contoller'
def controller = new Controller() 

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.BASE_URL)

'Pemanggilan method login dengan global variable parameter username'
controller.login(GlobalVariable.USER_NAME_APPROVAL_HOD)

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Approver List'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Approver Inbox 0'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Approval/Button/btn_link_approve_dan_verify'))

WebUI.selectOptionByValue(findTestObject('Page/Expenses-Claim-App/Approval/DropDown/dropdown_approval_status'), 'Approved by HOD', 
    false)

WebUI.setText(findTestObject('Page/Expenses-Claim-App/Approval/InputField/text_area_approver_remark'), 'ok approve')

WebUI.click(findTestObject('Page/Expenses-Claim-App/Approval/Button/button_complete_approver'))

WebUI.closeBrowser()

