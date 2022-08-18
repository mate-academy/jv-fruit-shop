package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final int LINES_TO_SKIP = 1;
    private static final int ACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getTransactions(List<String> transactions) {
        return transactions.stream()
                .skip(LINES_TO_SKIP)
                .map(this::getTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction getTransaction(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] strings = line.split(",");
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE
                .getOperationByFirstLetter(strings[ACTION_INDEX]));
        fruitTransaction.setFruit(strings[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(strings[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
