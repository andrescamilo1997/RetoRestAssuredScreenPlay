package co.com.sofka.util;


import static co.com.sofka.util.ChangeValuesEnume.*;
import static co.com.sofka.util.ReadFiles.readFile;

public class ChangeCharacter {
    private static String name;
    private static String email;
    private static String body;
    private static String Job;
    private static String BRING_JSON_FORMAT;

    public  ChangeCharacter(String name, String email, String body, String bringJsonFormat) {
        this.name = name;
        this.email = email;
        this.body = body;
        this.BRING_JSON_FORMAT = bringJsonFormat;
    }

    public  ChangeCharacter(String name, String Job, String bringJsonFormat) {
        this.name = name;
        this.Job = Job;
        this.BRING_JSON_FORMAT = bringJsonFormat;
    }

    public String defineBodyRequest(){
        return readFile(BRING_JSON_FORMAT)
                .replace(NAME.getValue(), name)
                .replace(EMAIL.getValue(), email)
                .replace(BODY.getValue(), body);
    }
    public String defineBodyRequestPut(){
        return readFile(BRING_JSON_FORMAT)
                .replace(NAME.getValue(), name)
                .replace(JOB.getValue(), Job);
    }


}
