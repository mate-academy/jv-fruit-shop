package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitTransaction;

public class FruitTransactionImpl implements FruitTransaction {
    private static final String BALANCE_LITERAL = "b";
    private static final String SUPPLY_LITERAL = "s";
    private static final String PURCHASE_LITERAL = "p";
    private static final String RETURN_LITERAL = "r";

    public Operation getOperation(String s) {
        if (s == null) {
            throw new RuntimeException("Argument cannot be null");
        }
        switch (s) {
            case BALANCE_LITERAL:
                return Operation.BALANCE;
            case SUPPLY_LITERAL:
                return Operation.SUPPLY;
            case PURCHASE_LITERAL:
                return Operation.PURCHASE;
            case RETURN_LITERAL:
                return Operation.RETURN;
            default:
                throw new RuntimeException("Operation type not supported: " + s);
        }
    }
}
