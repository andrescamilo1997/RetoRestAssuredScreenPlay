package co.com.sofka.question.pageReqRes;

import co.com.sofka.models.pageReqRes.UserModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetUserQuestionPageReqRes implements Question {


    @Override
    public UserModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UserModel.class);
    }
}
