package core.basesyntax.model;

public enum Action {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Action(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Action fromCode(String code) {
        for (Action action : values()) {
            if (action.getCode().equals(code)) {
                return action;
            }
        }
        throw new IllegalArgumentException("Invalid operation code: " + code);
    }
}

