package core.basesyntax.service.impl;

import core.basesyntax.exceptions.IncorrectOperationException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.ParserService;

public class ParserServiceImpl implements ParserService {
    @Override
    public FruitTransaction parseToTransaction(String line) {
        String[] transactionElements = line.split(",");
        OperationType operationType = findOperationType(transactionElements[0]);
        int quantity = Integer.parseInt(transactionElements[2]);
        Fruit fruit = new Fruit(transactionElements[1], quantity);
        return new FruitTransaction(operationType, fruit);
    }

    private OperationType findOperationType(String operationLetter) {
        for (OperationType operation : OperationType.values()) {
            if (operation.getOperation().equals(operationLetter)) {
                return operation;
            }
        }
        throw new IncorrectOperationException(operationLetter);
    }
}
