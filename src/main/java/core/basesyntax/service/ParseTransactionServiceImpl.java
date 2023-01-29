package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class ParseTransactionServiceImpl implements ParseTransactionService {
    private static final String SPLIT_SYMBOL = ",";
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OPERATION_INDEX = 0;

    private FruitTransaction parseTransaction(String line) {
        String[] fields = line.split(SPLIT_SYMBOL);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(Operation.getByCode(fields[OPERATION_INDEX].trim()));
        fruitTransaction.setFruit(fields[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
        return fruitTransaction;
    }

    @Override
    public List<FruitTransaction> parseStringTransactions(String transactions) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] splitTransactions = transactions.split(System.lineSeparator());
        for (String splitTransaction : splitTransactions) {
            fruitTransactions.add(parseTransaction(splitTransaction));
        }
        return fruitTransactions;
    }
}
