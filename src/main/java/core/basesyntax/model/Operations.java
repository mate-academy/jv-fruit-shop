package core.basesyntax.model;

public enum Operations {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operations;

    Operations(String operation) {
        this.operations = operation;
    }

    public String getOperation() {
        return operations;
    }
}
