import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.nio.file.Files as Files
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths
import javax.imageio.ImageIO as ImageIO
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import ru.yandex.qatools.ashot.AShot as AShot
import ru.yandex.qatools.ashot.Screenshot as Screenshot
import ru.yandex.qatools.ashot.shooting.ShootingStrategies as ShootingStrategies

// take screenshot of entire web page
WebUI.openBrowser('')

// set display size similar to iPhone 5.5 extended
WebUI.setViewPortSize(1024, 768)

def topPageUrl = 'https://dev.b6orgeng.net/component-library/colors'

WebUI.navigateToUrl(topPageUrl)

// this verification will PASS
WebUI.verifyElementPresent(findTestObject('JetBlue Component Library Objects/Components/colors component/Page_JetBlue  Component Library/h1_Colors'), 
    10, FailureHandling.CONTINUE_ON_FAILURE)

// take screenshot and save a PNG file into Reports dir
Path projectDir = Paths.get(RunConfiguration.getProjectDir())

Path reportDir = projectDir.resolve('Screenshots')

Files.createDirectories(reportDir)

Path pngFile = reportDir.resolve('expected_colors_component_entire_page_screenshot.png')

WebDriver driver = DriverFactory.getWebDriver()

//WebUI.takeScreenshot(pngFile.toString(), FailureHandling.STOP_ON_FAILURE)
takeEntirePage(driver, pngFile.toFile(), 500)

WebUI.closeBrowser()

void takeEntirePage(WebDriver webDriver, File file, Integer timeout = 300) {
    Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(timeout)).takeScreenshot(webDriver)

    ImageIO.write(screenshot.getImage(), 'PNG', file)
}

