package co.com.sofka.stepDefinition.pagePlaceHolders.setting;

import net.serenitybdd.screenplay.Actor;

public class Settings {
    protected static final String BRING_JSON_FORMAT = System.getProperty("user.dir")
            + "\\src\\test\\resources\\files\\pagePlaceHolders\\comments_page.json";
    protected static final String URL_BASE = "https://jsonplaceholder.typicode.com";
    protected static final String RESOURCE = "/comments";
    protected final Actor actor = Actor.named("Tester");
    protected String bodyRequest;

}
