package core.basesyntax.service.filereader;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.interfaces.TransactionTypeFinder;

public class TransactionTypeFinderImpl implements TransactionTypeFinder {
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
