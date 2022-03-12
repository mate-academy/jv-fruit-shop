package core.basesyntax.service.impl;

import core.basesyntax.exceptions.IncorrectOperationException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import core.basesyntax.strategy.OperationStrategy;

public class FruitTransaction {
    private OperationType operationType;
    private final Fruit fruit;
    private final OperationStrategy operationStrategy;

    public FruitTransaction(String[] lineElements, OperationStrategy operationStrategy) {
        String operationLetter = lineElements[0];
        defineOperationType(operationLetter);
        fruit = new Fruit(lineElements[1], Integer.parseInt(lineElements[2]));
        this.operationStrategy = operationStrategy;
    }

    public void doTransaction() {
        operationStrategy.startOperation(operationType, fruit);
    }

    public Fruit getFruit() {
        return fruit;
    }

    private void defineOperationType(String operationLetter) {
        switch (operationLetter) {
            case "b":
                operationType = OperationType.BALANCE;
                break;
            case "s":
                operationType = OperationType.SUPPLY;
                break;
            case "p":
                operationType = OperationType.PURCHASE;
                break;
            case "r":
                operationType = OperationType.RETURN;
                break;
            default:
                throw new IncorrectOperationException(operationLetter);
        }
    }
}
