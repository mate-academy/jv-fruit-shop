package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessingServiceImpl implements DataProcessingService {
    private static final String COMMA = ",";
    private static final int OPERATION_ELEMENT = 0;
    private static final int FRUIT_ELEMENT = 1;
    private static final int QUANTITY_ELEMENT = 2;
    private OperationStrategy operationStrategy;

    public DataProcessingServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransaction(List<String> data) {
        List<FruitTransaction> transactions = getTransactions(data);
        transactions
                .forEach(t -> operationStrategy.getOperationHandler(t.getOperation())
                        .updateQuantity(t));

    }

    private List<FruitTransaction> getTransactions(List<String> data) {
        return data.stream()
                .skip(1)
                .map(this::getFromRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromRow(String line) {
        FruitTransaction transaction = new FruitTransaction();
        String[] rowData = line.split(COMMA);
        transaction.setOperation(transaction.getOperationByLetter(rowData[OPERATION_ELEMENT]
                .trim()));
        transaction.setFruit(rowData[FRUIT_ELEMENT].trim());
        transaction.setQuantity(Integer.parseInt(rowData[QUANTITY_ELEMENT].trim()));
        return transaction;
    }
}
