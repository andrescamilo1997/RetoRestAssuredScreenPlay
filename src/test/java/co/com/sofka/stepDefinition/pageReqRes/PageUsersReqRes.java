package co.com.sofka.stepDefinition.pageReqRes;


import co.com.sofka.models.pageReqRes.UserModel;
import co.com.sofka.question.pageReqRes.GetUserQuestionPageReqRes;
import co.com.sofka.util.ChangeCharacter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import co.com.sofka.stepDefinition.pageReqRes.setting.Settings;
import org.apache.log4j.PropertyConfigurator;

import static co.com.sofka.task.pageReqRes.DoPetitionGetReqRes.usingTheResources;
import static co.com.sofka.task.pageReqRes.DoPetitionPutReqRes.DoPetitionPutReqRes;
import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static co.com.sofka.util.Log4jValues.USER_DIR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.IsEqual.equalTo;

public class PageUsersReqRes extends Settings{
    private static final Logger LOGGER = Logger.getLogger(PageUsersReqRes.class);
    //GET

    @Given("quiero ver mi informacion registrada en la pagina")
    public void quieroVerMiInformacionRegistradaEnLaPagina() {
        actor.whoCan(
                CallAnApi.at(URL_BASE)
        );
    }
    @When("Cuando mande a llamar mis datos")
    public void cuandoMandeALlamarMisDatos() {
        actor.attemptsTo(
                usingTheResources()
                        .usingTheResources(RESOURCE)
        );
    }
    @Then("entnces me mostrara un mensaje de ok y una lista de mis datos")
    public void entncesMeMostraraUnMensajeDeOkYUnaListaDeMisDatos() {

        UserModel user = new GetUserQuestionPageReqRes().answeredBy(actor);
        LastResponse.received().answeredBy(actor).prettyPrint();
        actor.should(
                seeThatResponse(
                        "El código de respuesta debe ser: " + HttpStatus.SC_OK,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK)
                ),
                seeThat("El primer id es: ",
                        validatableResponse -> user.getData().getId(),
                        equalTo(2))
                );
    }


    //PUT
    @Given("Despues de ver mi datos me gustaria editar mi nombre a {string} y trabajo a {string}")
    public void despuesDeVerMiDatosMeGustariaEditarMiNombreASegundoNombreAYTrabajoA(String name, String Job) {
        PropertyConfigurator.configure(USER_DIR.getValue() + LOG4J_PROPERTIES_FILE_PATH.getValue());
        actor.can(CallAnApi.at(USER_DIR.getValue() + LOG4J_PROPERTIES_FILE_PATH.getValue()));
        actor.can(CallAnApi.at(URL_BASE));
        bodyRequest = new ChangeCharacter(name,Job, BRING_JSON_FORMAT).defineBodyRequestPut();

        LOGGER.info(bodyRequest);
    }

    @When("Haga la peticion de cambio")
    public void hagaLaPeticionDeCambio() {
        actor.attemptsTo(
                DoPetitionPutReqRes()
                        .usingTheResource(RESOURCE)
                        .andBodyRequest(bodyRequest)
        );
    }
    @Then("Entonces me saldra un mensaje de ok, y la lista de mis datos")
    public void entoncesMeSaldraUnMensajeDeOkYLaListaDeMisDatos() {
        LastResponse.received().answeredBy(actor).prettyPrint();
        actor.should(
                seeThatResponse(
                        "El código de respuesta debe ser: " + HttpStatus.SC_OK,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK)
                )
        );
    }

}
