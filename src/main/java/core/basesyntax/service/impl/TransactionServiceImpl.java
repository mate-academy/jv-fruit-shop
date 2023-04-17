package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private static final String LINE_SEPARATOR = ",";
    private static final int FRUIT_NAME = 1;
    private static final int FRUIT_QTY = 2;
    private static final int TRANSACTION_CODE = 0;

    @Override
    public List<FruitTransaction> createTransactionsList(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            fruitTransactions.add(parseLine(data.get(i)));
        }
        return fruitTransactions;
    }

    private FruitTransaction parseLine(String line) {
        FruitTransaction transaction = new FruitTransaction();
        String[] strings = line.split(LINE_SEPARATOR);
        transaction.setFruit(strings[FRUIT_NAME]);
        transaction.setQuantity(Integer.parseInt(strings[FRUIT_QTY]));
        transaction.setOperation(FruitTransaction.Operation
                .getOperationByCode(strings[TRANSACTION_CODE]));
        return transaction;
    }
}
