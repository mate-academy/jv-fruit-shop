package core.basesyntax.service.implementation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final String SEPARATOR = ",";

    @Override
    public FruitTransaction createFruitTransaction(String inputLine) {
        String[] inputLineElements = inputLine.split(SEPARATOR);
        FruitTransaction.Operation operation = FruitTransaction.Operation
                .getOperationByCode(inputLineElements[0]);
        String fruit = inputLineElements[1];
        int quantity = Integer.parseInt(inputLineElements[2]);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
