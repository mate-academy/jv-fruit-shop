package core.basesyntax.service.impl;

import core.basesyntax.dao.TransactionDaoCsvImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseCsvService;

import java.util.List;

public class ParseCsvServiceImpl implements ParseCsvService {
    public static final int INDEX_OF_OPERATION = 0;
    public static final int INDEX_OF_FRUIT = 1;
    public static final int INDEX_OF_QUANTITY = 2;
    private final TransactionDaoCsvImpl transactionDaoCsvImpl = new TransactionDaoCsvImpl();

    @Override
    public void getTransactions(List<String> csvStrings) {
        csvStrings.stream()
                .map(this::parseTransaction)
                .forEach(transactionDaoCsvImpl::add);
    }

    private FruitTransaction parseTransaction(String csvLine) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] fields = csvLine.split(",");
        fruitTransaction.setOperation(FruitTransaction.Operation.getOperation(fields[INDEX_OF_OPERATION]));
        fruitTransaction.setFruit(fields[INDEX_OF_FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[INDEX_OF_QUANTITY]));
        return fruitTransaction;
    }
}
