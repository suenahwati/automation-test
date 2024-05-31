import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable;
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint;
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase;
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData;
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject;

import com.kms.katalon.core.annotation.Keyword;
import com.kms.katalon.core.checkpoint.Checkpoint;
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords;
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords;
import com.kms.katalon.core.model.FailureHandling;
import com.kms.katalon.core.testcase.TestCase;
import com.kms.katalon.core.testdata.TestData;
import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords;
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar


public class Controller {

	void robotUploadFile(String uploadLocator) {
		'Arahkan dengan mouse over'
		WebUI.mouseOver(findTestObject(uploadLocator))

		// set path untuk pemanggilan si file (Gambar)
		def fileImgPath = RunConfiguration.getProjectDir() + '/testImgBorr.png'

		// set path untuk pemanggilan si file (Dokumen)
		def fileDocPath = RunConfiguration.getProjectDir() + '/testDocBorr.docx'

		// rubah tanda "/" jadi "\" (Gambar)
		fileImgPath = fileImgPath.replaceAll('/', '\\\\')

		// rubah tanda "/" jadi "\" (Dokumen)
		fileDocPath = fileDocPath.replaceAll('/', '\\\\')

		copyToClipboard(fileDocPath)

		// klik Area Upload File
		WebUI.click(findTestObject(uploadLocator))

		// jeda buat nunggu dialog terbuka, cuma garekomen terus2an pake Thread.sleep()
		Thread.sleep(2000)

		'Lakukan CTRL+V'
		combinationCTRLV()

		'Lakukan Press ENTER'
		combinationENTER()
	}

	/**
	 * <b>copyToClipboard()</b>
	 * digunakan untuk melakukan salin teks ke clipboard external chrome
	 * biasanya digunakan untuk handle CTRL+F pada chrome atau dialog chooser
	 */
	void copyToClipboard(String text) {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text), null)
	}

	/**
	 * <b>combinationCTRLV()</b>
	 * digunakan untuk melakukan perintah CTRL+V (Paste) pada chrome
	 */
	void combinationCTRLV() {
		// implementasi java robot
		Robot robot = new Robot()

		// Tekan CTRL
		robot.keyPress(KeyEvent.VK_CONTROL)

		// Tekan V
		robot.keyPress(KeyEvent.VK_V)

		// Lepasin CTRL
		robot.keyRelease(KeyEvent.VK_V)

		// Lepasin V
		robot.keyRelease(KeyEvent.VK_CONTROL)
	}

	/**
	 * <b>combinationENTER()</b>
	 * digunakan untuk melakukan perintah ENTER pada chrome
	 * biasanya untuk handle external dialog atau apapun itu untuk melakukan ENTER/OK pada external dialog
	 */
	void combinationENTER() {
		// implementasi java robot
		Robot robot = new Robot()

		// Tekan Enter untuk konfirmasi
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
	}

	public String getCurrentDate() {
		'Inisialisasi Kalender'
		Calendar cal = Calendar.getInstance()

		'Ambil tanggal & waktu sekarang'
		Date currentDate = cal.time

		'Inisialisasi & membuat format tanggal ke dd-mm-yyyy HH:mm:ss'
		SimpleDateFormat dateFormat = new SimpleDateFormat('dd-MM-yyyy HH:mm:ss')

		'Menggambil tanggal hari ini dan merubah format ke dd-mm-yyyy'
		String formattedDateTime = dateFormat.format(currentDate)

		'Rubah teks : ke .'
		formattedDateTime.replaceAll(':', '.')

		return formattedDateTime
	}

	void login(String username) {
		WebUI.click(findTestObject('Page/Login/Button/btn_login'))

		WebUI.setText(findTestObject('Page/Login/InputField/input_Username_j_username'), username)

		WebUI.setEncryptedText(findTestObject('Page/Login/InputField/input_Password_j_password'), GlobalVariable.PASSWORD)

		WebUI.click(findTestObject('Page/Login/Button/btn_submit'))
	}
}