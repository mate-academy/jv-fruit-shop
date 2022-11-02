package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationTypeIdentifier;

public class OperationTypeIdentifierImpl implements OperationTypeIdentifier {

    @Override
    public FruitTransaction.Operation identifyOperationType(String inputOperation) {
        for (FruitTransaction.Operation operationType : FruitTransaction.Operation.values()) {
            if (operationType.getOperation().equals(inputOperation)) {
                return operationType;
            }
        }
        throw new RuntimeException("Invalid input operation type: " + inputOperation);
    }
}
