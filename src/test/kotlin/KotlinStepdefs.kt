import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import cucumber.api.java8.En
import org.junit.Assert

class KotlinStepdefs : En {

    init {
        val webAutomation = WebAutomation()
        lateinit var transitive: String

        When("the user navigates to Google") {
            webAutomation.navigateTo()
        }

        Then("the user should see the Google search input") {
            val elem = webAutomation.getElement(CommonElements.searchInput)
            Assert.assertEquals("Search",elem.getAttribute("title"))
            webAutomation.driver.quit()
        }

        When("the config loads {string}") { query: String ->

        }

        Then("the config string should equal {string}") { query: String ->
            Assert.assertEquals(query,transitive)
        }

    }

    object CommonElements {
        private val config = ConfigFactory.load().getConfig("elements")
        val searchInput: Config = config.getConfig("input.search")
    }

}