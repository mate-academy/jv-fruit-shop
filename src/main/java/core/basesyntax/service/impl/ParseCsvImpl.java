package core.basesyntax.service.impl;

import core.basesyntax.dao.TransactionsDao;
import core.basesyntax.dao.TransactionsDaoCsvImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseCsv;
import java.util.List;

public class ParseCsvImpl implements ParseCsv {
    public static final int INDEX_OF_OPERATION = 0;
    public static final int INDEX_OF_FRUIT = 1;
    public static final int INDEX_OF_QUANTITY = 2;
    private final TransactionsDao transactionsDao = new TransactionsDaoCsvImpl();

    @Override
    public void getTransactions(List<String> csvStrings) {
        csvStrings.stream()
                .map(this::parseTransaction)
                .forEach(transactionsDao::addTransaction);
    }

    private FruitTransaction parseTransaction(String csvLine) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] fields = csvLine.split(",");
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getOperation(fields[INDEX_OF_OPERATION]));
        fruitTransaction.setFruit(fields[INDEX_OF_FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[INDEX_OF_QUANTITY]));
        return fruitTransaction;
    }
}
