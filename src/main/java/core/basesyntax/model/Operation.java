package core.basesyntax.model;

import core.basesyntax.service.CantWorkWithThisFileException;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation fromCode(String operation) {
        String trim = operation.trim();
        for (Operation o : Operation.values()) {
            if (o.getCode().equals(trim)) {
                return o;
            }
        }
        throw new CantWorkWithThisFileException("We dont have this operation: " + operation);
    }
}
