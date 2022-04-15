package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseFruitTransaction(List<String> transaction) {
        return transaction.stream()
                .skip(1L)
                .map(this::convertToTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction convertToTransaction(String transaction) {
        String[] splittedTransaction = transaction.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getByAbbreviation(splittedTransaction[OPERATION_INDEX]));
        fruitTransaction.setFruit(splittedTransaction[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(splittedTransaction[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
