package core.basesyntax.action;

public enum Action {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");

    private final String code;

    Action(String code) {
        this.code = code;
    }

    public static Action getAction(String value) {
        for (Action action : Action.values()) {
            if (action.code.equals(value)) {
                return action;
            }
        }
        return null;
    }
}
