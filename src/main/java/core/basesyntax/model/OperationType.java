package core.basesyntax.model;

import java.util.Arrays;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String name;

    OperationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static OperationType getOperationType(String name) {
        return Arrays.stream(OperationType.values())
                .filter(n -> n.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Operation " + name + " doesn`t exist"));
    }
}
