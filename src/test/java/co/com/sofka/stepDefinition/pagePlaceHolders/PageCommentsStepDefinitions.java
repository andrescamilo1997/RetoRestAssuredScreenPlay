package co.com.sofka.stepDefinition.pagePlaceHolders;

import co.com.sofka.models.pagePlaceHolders.ModelPagePlaceHolders;
import co.com.sofka.question.pagePlaceHolders.GetCommentsQuestionPagePlaceHolders;
import co.com.sofka.stepDefinition.pagePlaceHolders.setting.Settings;
import co.com.sofka.util.ChangeCharacter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import static co.com.sofka.task.pagePlaceHolders.DoPetitionPost.DoPetitionPost;
import static co.com.sofka.task.pagePlaceHolders.DoPetitionGet.usingTheResources;
import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static co.com.sofka.util.Log4jValues.USER_DIR;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class PageCommentsStepDefinitions extends Settings {
    private static final Logger LOGGER = Logger.getLogger(PageCommentsStepDefinitions.class);
    //GET
    @Given("Necesito poder ver todos los comentarios en mi pagina")
    public void necesitoPoderVerTodosLosComentariosEnMiPagina() {
        actor.whoCan(
                CallAnApi.at(URL_BASE)
        );
    }

    @When("cuango haga la peticion")
    public void cuangoHagaLaPeticion() {
        actor.attemptsTo(
                usingTheResources().usingTheResources(RESOURCE)
        );
    }

    @Then("Me da como reultado un codigo de mensaje de OK, una lista en la que puedan verse los comentarios")
    public void meDaComoReultadoUnCodigoDeMensajeDeOKUnaListaEnLaQuePuedanVerseLosComentarios() {
        ModelPagePlaceHolders[] modelForTheComments = new GetCommentsQuestionPagePlaceHolders()
                .answeredBy(actor);
        actor.should(
                seeThatResponse(
                        "Las respuesta debe ser: "+ HttpStatus.SC_OK,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK)
                ),
                seeThat("El primer id es: ",
                        validatableResponse -> modelForTheComments[0].getId(),
                        equalTo(1))
        );

    }


    //POST
    @Given("Como usuario me gustaria pode agregar un comentario el cual tendra {string} {string} {string}")
    public void comoUsuarioMeGustariaPodeAgregarUnComentarioElCualTendra(String name, String email, String body) {
        PropertyConfigurator.configure(USER_DIR.getValue() + LOG4J_PROPERTIES_FILE_PATH.getValue());
        actor.can(CallAnApi.at(USER_DIR.getValue() + LOG4J_PROPERTIES_FILE_PATH.getValue()));
        actor.can(CallAnApi.at(URL_BASE));
        bodyRequest = new ChangeCharacter(name,email,body, BRING_JSON_FORMAT).defineBodyRequest();

        LOGGER.info(bodyRequest);
    }

    @When("cuando haga la peticion")
    public void cuandoHagaLaPeticion() {
        actor.attemptsTo(
                DoPetitionPost()
                        .usingTheResource(RESOURCE)
                        .andBodyRequest(bodyRequest)
        );
    }

    @Then("Me da como reultado un codigo de mensaje de creado, el id asignado del comentario creado")
    public void meDaComoReultadoUnCodigoDeMensajeDeCreadoElIdAsignadoDelComentarioCreado() {
        LastResponse.received().answeredBy(actor).prettyPrint();
        actor.should(
                seeThatResponse(
                        "El código de respuesta debe ser: " + HttpStatus.SC_CREATED,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_CREATED)
                )
        );

    }

}
