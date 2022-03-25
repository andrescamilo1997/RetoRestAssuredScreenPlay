package co.com.sofka.question.pagePlaceHolders;

import co.com.sofka.models.pagePlaceHolders.ModelPagePlaceHolders;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetCommentsQuestionPagePlaceHolders implements Question<ModelPagePlaceHolders[]> {

    @Override
    public ModelPagePlaceHolders[] answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(ModelPagePlaceHolders[].class);
    }
}
