package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationTypeService;

public class OperationTypeServiceImpl implements OperationTypeService {
    @Override
    public FruitTransaction.Operation getOperationType(String operation) {
        switch (operation) {
            case "b":
                return FruitTransaction.Operation.BALANCE;
            case "s":
                return FruitTransaction.Operation.SUPPLY;
            case "p":
                return FruitTransaction.Operation.PURCHASE;
            default:
                return FruitTransaction.Operation.RETURN;
        }
    }
}
