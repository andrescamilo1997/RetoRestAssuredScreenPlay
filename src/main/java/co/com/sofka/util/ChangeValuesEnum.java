package co.com.sofka.util;

public enum ChangeValuesEnum {
    NAME      (   "[NAME]"   ),
    EMAIL     (   "[EMAIL]"  ),
    BODY      (   "[BODY]"   ),
    JOB       (   "[JOB]"    );

    private final String value;
    ChangeValuesEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
