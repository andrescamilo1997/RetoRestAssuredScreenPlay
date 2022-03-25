package co.com.sofka.task.pagePlaceHolders;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class DoPetitionGet implements Task {
    private static String resource;


    public DoPetitionGet usingTheResources(String resource) {
        DoPetitionGet.resource = resource;
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

    public static DoPetitionGet usingTheResources(){
        return new DoPetitionGet();
    }
}
