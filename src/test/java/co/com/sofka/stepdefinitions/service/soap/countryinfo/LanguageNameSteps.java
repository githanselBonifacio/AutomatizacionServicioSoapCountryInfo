package co.com.sofka.stepdefinitions.service.soap.countryinfo;

import co.com.sofka.ServiceSetup;
import co.com.sofka.util.service.soap.countryinfo.Patch;
import co.com.sofka.util.service.soap.countryinfo.Response;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.questions.ResturnSoapServiceResponse.resturnSoapServiceResponse;
import static co.com.sofka.tasks.DoPost.doPost;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.containsString;

public class LanguageNameSteps extends ServiceSetup {
    private static final Logger logger = LogManager.getLogger(LanguageNameSteps.class);
    @When("el usuario ejecute la petición con código {string}  para buscar el nombre de un lenguaje")
    public void elUsuarioEjecuteLaPeticionConCodigoParaBuscarElNombreDeUnLenguaje(String codeLanguage) {
        try {
            super.setup();
            actor.attemptsTo(
                    doPost()
                            .withTheResource(RESOURCE)
                            .andTheHeaders(super.headers())
                            .andTheBodyRequest(BodyPetition.bodyRequest(
                                    Patch.lANGUAGE_NAME_REQUEST.getValue(),codeLanguage))
            );
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            logger.warn("error petición\n"+e.getMessage());
        }
    }

    @Then("el usuario debería obtener el lenguaje {string}")
    public void elUsuarioDeberiaObtenerElLenguaje(String response) {
        try {
            actor.should(
                    seeThatResponse("El código de rspuesta HTTP debe ser: ",
                            resp -> resp.statusCode(HttpStatus.SC_OK)),
                    seeThat("La ciudad capital es: ",
                            resturnSoapServiceResponse(),
                            containsString(BodyPetition.bodyResponse(
                                    Response.LANGUAGE_NAME_RESPONSE.getValue(),response)))
            );
        }catch (AssertionError e){
            Assertions.fail(e.getMessage());
            logger.warn("Error en la validación\n"+e);
        }
    }
    @Then("el sistema no encontrará ningun lenguaje y la respuesta será {string}")
    public void elSistemaNoEncontraraNingunLenguajeYLaRespuestaSera(String response) {
        try {
            actor.should(
                    seeThatResponse("El código de rspuesta HTTP debe ser: ",
                            resp -> resp.statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)),
                    seeThat("Respuesta del servidor: ",
                            resturnSoapServiceResponse(),
                            containsString(BodyPetition.bodyResponse(
                                    Response.ERROR_SERVER_RESPONSE.getValue(),response)))
            );
        }catch (AssertionError e) {
            Assertions.fail(e.getMessage());
            logger.warn("Error en la validación\n"+e);
        }
    }
}
