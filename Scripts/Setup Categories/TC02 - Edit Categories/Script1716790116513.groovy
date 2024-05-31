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

'Memanggil Method Controller'
def controller = new Controller()

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.BASE_URL)

'Pemanggilan method login dengan global variable parameter username'
controller.login(GlobalVariable.USER_NAME_FINANCE)

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Setup Categories'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Setup Categories/Button/span_Setup Categories'))

WebUI.setText(findTestObject('Page/Expenses-Claim-App/Setup Categories/InputField/input_text_expenses_category_pencarian'), 
    'Meal Allowance')

WebUI.click(findTestObject('Page/Expenses-Claim-App/Setup Categories/Button/btn_show'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Setup Categories/Button/a_Edit'))

WebUI.setText(findTestObject('Page/Expenses-Claim-App/Setup Categories/InputField/input__Category'), 'Meal Allowances')

WebUI.delay(5)

WebUI.click(findTestObject('Page/Expenses-Claim-App/Setup Categories/Button/btn__save'))

WebUI.closeBrowser()

