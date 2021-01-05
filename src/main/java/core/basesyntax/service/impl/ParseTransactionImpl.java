package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParseTransactionDto;

public class ParseTransactionImpl implements ParseTransactionDto {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public TransactionDto parseDateFromFile(String[] transaction) {
        TransactionDto currentTransaction = new TransactionDto();
        currentTransaction.setOperation(Operation.fromString(transaction[OPERATION_INDEX]));
        currentTransaction.setFruit(new Fruit(transaction[FRUIT_INDEX]));
        currentTransaction.setQuantity(Integer.parseInt(transaction[QUANTITY_INDEX]));
        return currentTransaction;
    }
}
