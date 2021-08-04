package co.com.rappi.certification.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature/rest_service.feature",
        glue = "co/com/rappi/certification/stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class RestService {
}
