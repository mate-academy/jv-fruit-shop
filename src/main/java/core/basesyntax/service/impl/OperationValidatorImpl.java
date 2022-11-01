package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationValidator;
import java.util.HashMap;
import java.util.Map;

public class OperationValidatorImpl implements OperationValidator {
    private Map<String, FruitTransaction.Operation> operations = new HashMap<>();

    public OperationValidatorImpl(Map<String, FruitTransaction.Operation> operations) {
        this.operations = operations;
    }

    @Override
    public FruitTransaction.Operation validate(String operation) {
        FruitTransaction.Operation fruitTransactionOperation = operations.get(operation);
        if (fruitTransactionOperation == null) {
            throw new RuntimeException("Unknow operation");
        }
        return operations.get(operation);
    }
}
