package co.com.sofka.util;


import static co.com.sofka.util.ChangeValuesEnum.*;
import static co.com.sofka.util.ReadFiles.readFile;

public class ChangeCharacter {
    private final String name;
    private String email;
    private String body;
    private String job;
    private final String bringJsonFormat;

    public  ChangeCharacter(String name, String email, String body, String bringJsonFormat) {
        this.name = name;
        this.email = email;
        this.body = body;
        this.bringJsonFormat = bringJsonFormat;
    }

    public  ChangeCharacter(String name, String job, String bringJsonFormat) {
        this.name = name;
        this.job = job;
        this.bringJsonFormat = bringJsonFormat;
    }

    public String defineBodyRequest(){
        return readFile(bringJsonFormat)
                .replace(NAME.getValue(), name)
                .replace(EMAIL.getValue(), email)
                .replace(BODY.getValue(), body);
    }
    public String defineBodyRequestPut(){
        return readFile(bringJsonFormat)
                .replace(NAME.getValue(), name)
                .replace(JOB.getValue(), job);
    }


}
