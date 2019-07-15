import com.typesafe.config.Config
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

class WebAutomation {

    val driver = ChromeDriver()

    fun navigateTo(url: String? = "https://www.google.com") {
        driver.get(url)
    }

    fun getElement(selector: Config): WebElement {
        return driver.findElement(selector.getBySelector())
    }

    private fun Config.getBySelector(): By {
        this.hasPath("by").let {
            val selector = this.getString("selector")
            val by = this.getString("by")
            return when(this.getString("by").toLowerCase()) {
                "css" -> By.cssSelector(selector)
                else -> {
                    throw Exception("No such selector found for: $by")
                }
            }
        }
    }

}


