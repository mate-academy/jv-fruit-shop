package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int TITLE_LINE_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> get(List<String> inputData) {
        inputData.remove(TITLE_LINE_INDEX);
        return inputData.stream()
                .map(this::getTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction getTransaction(String lineFromFile) {
        String[] transaction = lineFromFile.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(fruitTransaction
                .getOperationByLetter(transaction[OPERATION_INDEX]));
        fruitTransaction.setFruit(transaction[FRUIT_NAME_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(transaction[FRUIT_QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
