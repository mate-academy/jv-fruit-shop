package core.basesyntax.service.impl;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"), PURCHASE("p"), RETURN("r");
    private String type;

    OperationType(String type) {
    }
}
