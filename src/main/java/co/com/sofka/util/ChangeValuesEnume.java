package co.com.sofka.util;

public enum ChangeValuesEnume {
    NAME      ("[NAME]"  ),
    EMAIL     ("[EMAIL]" ),
    BODY      ("[BODY]"  ),
    LAST_NAME ("[LASTNAME]"),
    JOB       ("[JOB]");

    private final String value;
    ChangeValuesEnume(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
