package core.basesyntax.handlers;

import core.basesyntax.exceptions.IllegalOperationException;

public enum Operations {
    P("p"), S("s"), R("r"), B("b");

    private final String operation;

    Operations(String operation) {
        this.operation = operation;
    }

    public static Operations getEnum(String operation) {
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
                throw new IllegalOperationException("Illegal operation" + operation);
        }
    }
}
