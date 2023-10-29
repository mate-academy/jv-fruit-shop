package model;

import java.util.Arrays;

public enum ActivityType {
BALANCE("b"),
SUPPLY("s"),
PURCHASE("p"),
RETURN("r");

    private String name;

    ActivityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ActivityType getOperationTypeByName(String name) {
        return Arrays.stream(ActivityType.values())
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't find this operation type "
                        + name));
    }
}
