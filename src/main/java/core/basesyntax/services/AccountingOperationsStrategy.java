package core.basesyntax.services;

import core.basesyntax.model.TypeOperation;

public interface AccountingOperationsStrategy {
    Integer accountingOperations(TypeOperation typeOperation, Integer quantity);
}
