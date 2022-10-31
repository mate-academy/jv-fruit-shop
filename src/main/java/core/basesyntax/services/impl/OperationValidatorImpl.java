package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.OperationValidator;

public class OperationValidatorImpl implements OperationValidator {
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";

    @Override
    public FruitTransaction.Operation validate(String operation) {
        switch (operation) {
            case BALANCE : return FruitTransaction.Operation.BALANCE;
            case SUPPLY : return FruitTransaction.Operation.SUPPLY;
            case PURCHASE : return FruitTransaction.Operation.PURCHASE;
            case RETURN : return FruitTransaction.Operation.RETURN;
            default: throw new RuntimeException("Unknow operation");
        }
    }
}
