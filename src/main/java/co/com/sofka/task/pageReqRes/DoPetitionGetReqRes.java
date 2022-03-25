package co.com.sofka.task.pageReqRes;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class DoPetitionGetReqRes implements Task {
    private static String resource;


    public DoPetitionGetReqRes usingTheResources(String resource) {
        DoPetitionGetReqRes.resource = resource;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(resource)
                        .with(
                                requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                                        .log()
                                        .all()
                        )
        );

    }

    public static DoPetitionGetReqRes usingTheResources(){
        return new DoPetitionGetReqRes();
    }
}
