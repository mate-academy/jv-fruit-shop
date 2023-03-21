package core.basesyntax.service.fileReader;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.interfaces.FindTransactionType;

public class FindTransactionTypeImpl implements FindTransactionType {
    @Override
    public FruitTransaction.Operation operationType(String operation) {
        for (FruitTransaction.Operation fruitOperation : FruitTransaction.Operation.values()) {
            if (fruitOperation.getCode().equals(operation)) {
                return fruitOperation;
            }
        }
        throw new RuntimeException("Operation " + operation + " do not exist");
    }
}
