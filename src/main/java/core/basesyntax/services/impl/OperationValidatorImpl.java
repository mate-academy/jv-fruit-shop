package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.OperationValidator;

public class OperationValidatorImpl implements OperationValidator {

    @Override
    public FruitTransaction.Operation validate(String operation) {
        switch (operation) {
            case "b" : return FruitTransaction.Operation.BALANCE;
            case "s" : return FruitTransaction.Operation.SUPPLY;
            case "p" : return FruitTransaction.Operation.PURCHASE;
            case "r" : return FruitTransaction.Operation.RETURN;
            default: throw new RuntimeException("Unknow operation");
        }
    }
}
