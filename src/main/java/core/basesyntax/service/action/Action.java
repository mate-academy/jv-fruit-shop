package core.basesyntax.service.action;

public enum Action {
    BALANCE("b"),
    PURCHASE("p"),
    SUPPLY("s"),
    RETURN("r");

    private String actionCode;

    Action(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getActionCode() {
        return this.actionCode;
    }
}
