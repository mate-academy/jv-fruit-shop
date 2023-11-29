package core.basesyntax.action;

public enum Action {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");

    private String code;
    Action(String code) {
        this.code = code;
    }
}
