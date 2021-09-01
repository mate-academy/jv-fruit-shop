package core.basesyntax.services;

import core.basesyntax.model.TypeOperation;

public class AccountingOperationsStrategyImpl implements AccountingOperationsStrategy {
    @Override
    public Integer accountingOperations(TypeOperation typeOperation, Integer quantity) {
        Integer operation = 0;
        switch (typeOperation) {
            case BALANCE:
            case SUPPLY:
            case RETURN:
                operation = quantity;
                break;
            case PURCHASE:
                operation = - quantity;
                break;
            default:
                break;
        }
        return operation;
    }
}
