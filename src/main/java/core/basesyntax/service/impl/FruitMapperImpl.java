package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitMapperImpl implements FruitMapper {
    private static final String OPERATION_FRUIT_AMOUNT_SEPARATOR = ",";
    private static final int INDEX_FOR_OPERATION = 0;
    private static final int INDEX_FOR_FRUIT = 1;
    private static final int INDEX_FOR_QUANTITY = 2;

    @Override
    public List<FruitTransaction> mapLinesIntoTransactions(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            FruitTransaction transaction = new FruitTransaction();
            String[] operationFruitAmount = line.split(OPERATION_FRUIT_AMOUNT_SEPARATOR);
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .getOperationByCode(operationFruitAmount[INDEX_FOR_OPERATION]);
            String fruit = operationFruitAmount[INDEX_FOR_FRUIT];
            int quantity = Integer.parseInt(operationFruitAmount[INDEX_FOR_QUANTITY]);
            transaction.setOperation(operation);
            transaction.setFruit(fruit);
            transaction.setQuantity(quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
