import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

class WebAutomation {

    private val driver = ChromeDriver()

    fun navigateTo(url: String? = "https://www.google.com") {
        driver.get(url)
    }

    fun getElement(selector: By): WebElement {
        return driver.findElement(selector)
    }

}