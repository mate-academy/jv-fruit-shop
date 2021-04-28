package core.basesyntax.model;

import core.basesyntax.exceptions.IllegalOperationException;

public enum Operation {
    P("p"), S("s"), R("r"), B("b");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation getEnum(String operation) {
        switch (operation) {
            case "p" :
                return P;
            case "s" :
                return S;
            case "r" :
                return R;
            case "b" :
                return B;
            default :
                throw new IllegalOperationException("Illegal operation " + operation);
        }
    }
}
