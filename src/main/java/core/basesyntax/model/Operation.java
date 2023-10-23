package core.basesyntax.model;

import javax.lang.model.element.Element;
import java.util.Map;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;
    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation findByCode(String code) {
        for (Operation op : values()) {
            if (op.code.equals(code)) {
                return op;
            }
        }

        throw new RuntimeException("Code is not exist " + code);
    }
}
