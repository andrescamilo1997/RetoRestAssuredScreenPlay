package co.com.sofka.stepDefinition.pageReqRes.setting;

import net.serenitybdd.screenplay.Actor;


public class Settings {
    protected static final String BRING_JSON_FORMAT = System.getProperty("user.dir")
            + "\\src\\test\\resources\\files\\pageReqRes\\reqres_put_formar.json";
    protected static final String URL_BASE = "https://reqres.in/api";
    protected static final String RESOURCE = "/users/2";
    protected final Actor actor = Actor.named("Tester");
    protected String bodyRequest;

}
