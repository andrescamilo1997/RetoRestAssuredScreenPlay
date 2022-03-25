package co.com.sofka.task.pageReqRes;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class DoPetitionPutReqRes implements Task {
    private String resource;
    private String bodyRequest;

    public DoPetitionPutReqRes usingTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    public DoPetitionPutReqRes andBodyRequest(String bodyRequest) {
        this.bodyRequest = bodyRequest;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(resource)
                        .with(requestSpecification -> requestSpecification.relaxedHTTPSValidation()
                                .contentType(ContentType.JSON)
                                .body(bodyRequest)
                        )
        );

    }

    public static DoPetitionPutReqRes DoPetitionPutReqRes(){
        return new DoPetitionPutReqRes();
    }
}
