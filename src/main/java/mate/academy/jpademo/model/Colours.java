package mate.academy.jpademo.model;

public enum  Colours {
    RED("\u001B[31m"),
    END("\u001B[0m");

    private String code;

    Colours(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
