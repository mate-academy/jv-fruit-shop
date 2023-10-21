package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessing;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class DataProcessingImpl implements DataProcessing {
    private static final String SPLITERATOR = ",";
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_NAME_POSITION = 1;
    private static final int AMOUNT_OF_FRUIT_POSITION = 2;
    private OperationStrategy operationStrategy;

    public DataProcessingImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransaction(List<String> data) {
        List<FruitTransaction> fruitTransactions = getFruitTransactions(data);
        fruitTransactions
                .forEach(t -> operationStrategy.getOperationHandler(t.getOperation())
                        .updateStorage(t));
    }

    private List<FruitTransaction> getFruitTransactions(List<String> data) {
        return data.stream()
                .map(this::getTransactionFromRow)
                .toList();
    }

    private FruitTransaction getTransactionFromRow(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] rowWithTransaction = line.split(SPLITERATOR);
        fruitTransaction.setOperation(fruitTransaction
                .getOperationByLetter(rowWithTransaction[OPERATION_POSITION].trim()));
        fruitTransaction.setFruitName(rowWithTransaction[FRUIT_NAME_POSITION].trim());
        fruitTransaction.setAmount(Integer
                .parseInt(rowWithTransaction[AMOUNT_OF_FRUIT_POSITION].trim()));
        return fruitTransaction;
    }
}
