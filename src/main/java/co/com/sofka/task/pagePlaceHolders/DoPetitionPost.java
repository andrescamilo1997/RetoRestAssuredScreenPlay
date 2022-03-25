package co.com.sofka.task.pagePlaceHolders;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class DoPetitionPost  implements Task {
    private String resource;
    private String bodyRequest;

    public DoPetitionPost usingTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    public DoPetitionPost andBodyRequest(String bodyRequest) {
        this.bodyRequest = bodyRequest;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(resource)
                        .with(requestSpecification -> requestSpecification.relaxedHTTPSValidation()
                                .contentType(ContentType.JSON)
                                .body(bodyRequest)
                        )
        );

    }

    public static DoPetitionPost DoPetitionPost(){
        return new DoPetitionPost();
    }
}
