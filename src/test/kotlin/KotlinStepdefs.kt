import com.typesafe.config.ConfigFactory
import cucumber.api.java8.En
import org.junit.Assert
import org.openqa.selenium.By

class KotlinStepdefs : En {

    init {
        val config = ConfigFactory.load().getConfig("elements")
        //val webAutomation = WebAutomation()
        lateinit var transitive: String

//        data class CommonElements(
//            val searchInput: String = config.getString("input.search")
//        )

//        When("the user does the thing") {
//            webAutomation.navigateTo()
//        }
//        Then("the user should see the thing") {
//            val elem = webAutomation.getElement(
//                By.cssSelector("*[name='q']")
//            )
//            Assert.assertEquals("Search",elem.getAttribute("title"))
//        }

        When("the config loads {string}") { query: String ->
            transitive = config.getString(query)
        }

        Then("the config string should equal {string}") { query: String ->
            Assert.assertEquals(query,transitive)
        }
    }

}