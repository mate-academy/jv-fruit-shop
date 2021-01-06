package core.basesyntax.strategy.operation;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String text;

    Operation(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Operation fromString(String text) {
        for (Operation operation : Operation.values()) {
            if (operation.getText().equalsIgnoreCase(text)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}
