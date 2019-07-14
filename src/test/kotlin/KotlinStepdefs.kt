import cucumber.api.java8.En
import org.junit.Assert
import org.openqa.selenium.By

class KotlinStepdefs : En {
    init {
        val webAutomation = WebAutomation()

        When("the user does the thing") {
            webAutomation.navigateTo()
        }
        Then("the user should see the thing") {
            val elem = webAutomation.getElement(
                By.cssSelector("*[name='q']")
            )
            Assert.assertEquals("Search",elem.getAttribute("title"))
        }
    }
}