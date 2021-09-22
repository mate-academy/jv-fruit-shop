package core.basesyntax.service.operationtypes;

import java.util.HashMap;
import java.util.Map;

public enum Operations {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");

    private static final Map<String, Operations> typesMap = new HashMap<>();

    static {
        for (Operations type : Operations.values()) {
            typesMap.put(type.getType(), type);
        }
    }

    private String type;

    Operations(String s) {
        this.type = s;
    }

    public static Operations get(String type) {
        return typesMap.get(type);
    }

    public String getType() {
        return type;
    }
}

