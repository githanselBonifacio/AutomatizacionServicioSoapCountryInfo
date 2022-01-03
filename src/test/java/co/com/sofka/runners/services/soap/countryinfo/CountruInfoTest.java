package co.com.sofka.runners.services.soap.countryinfo;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/services/soap/countryinfo"},
        glue = {"co.com.sofka.stepdefinitions.service.soap.countryinfo"}
)
public class CountruInfoTest {

}
