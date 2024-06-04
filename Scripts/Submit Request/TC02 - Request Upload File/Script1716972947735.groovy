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
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar

'Memanggil Method Controller'
def controller = new Controller()

'Inisialisasi Penampung Nilai Object'
String getDate = controller.getCurrentDate()

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.BASE_URL)

'Pemanggilan method login dengan global parameter username'
controller.login(GlobalVariable.USER_NAME)

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_My Expenses'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Menu/a_Submitted Expenses 0'))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Request/Button/button_Create A New Expense Claim'))

'Pemanggilan Function getCurrentDate'
WebUI.setText(findTestObject('Object Repository/Page/Expenses-Claim-App/Request/InputField/input__title'), 'Transportation ' + 
    getDate)

WebUI.setText(findTestObject('Page/Expenses-Claim-App/Request/InputField/input_Remark_remark'), 'Expenses Claim')

WebUI.selectOptionByValue(findTestObject('Page/Expenses-Claim-App/Request/DropDown/dropdown_select_approver'), 'AD49270723', 
    true)

WebUI.click(findTestObject('Page/Expenses-Claim-App/Request/Button/input__assignmentComplete'))

WebUI.mouseOver(findTestObject('Page/Expenses-Claim-App/Request/Button/input__assignmentComplete'))

WebUI.doubleClick(findTestObject('Page/Expenses-Claim-App/Request/Button/td_segitiga_kebalik_category'))

WebUI.setText(findTestObject('Page/Expenses-Claim-App/Request/InputField/textarea_category-expense'), 'Transportation', 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Page/Expenses-Claim-App/Request/InputField/textarea_category-expense'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Page/Expenses-Claim-App/Request/Button/td_segitiga_kebalik_date'))

WebUI.waitForElementClickable(findTestObject('Page/Expenses-Claim-App/Request/Button/btn_pika_next'), 15, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page/Expenses-Claim-App/Request/Button/btn_pika_next'), FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Page/Expenses-Claim-App/Request/DropDown/dropdown_bulan'), 'May', false, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Page/Expenses-Claim-App/Request/DropDown/dropdown_tahun'), '2024', false, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page/Expenses-Claim-App/Request/Hari/button_19'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page/Expenses-Claim-App/Request/Button/klik_purpose'))

WebUI.setText(findTestObject('Page/Expenses-Claim-App/Request/InputField/set_purpose'), 'Claim Expenses')

WebUI.click(findTestObject('Page/Expenses-Claim-App/Request/Button/klik_amount'))

WebUI.setText(findTestObject('Page/Expenses-Claim-App/Request/InputField/set_Amount'), '300000')

WebUI.sendKeys(findTestObject('Page/Expenses-Claim-App/Request/InputField/set_Amount'), Keys.chord(Keys.ENTER))

'Memanggil Controller Dengan Object Upload File'
controller.robotUploadFile('Page/Expenses-Claim-App/Request/Button/upload_file')

WebUI.click(findTestObject('Object Repository/Page/Expenses-Claim-App/Request/Button/input__assignmentComplete'))

WebUI.closeBrowser()

