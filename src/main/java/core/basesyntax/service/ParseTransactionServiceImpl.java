package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class ParseTransactionServiceImpl implements FruitTransactionParser {
    private static final String SPLIT_SYMBOL = ",";
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OPERATION_INDEX = 0;

    @Override
    public List<FruitTransaction> parse(String transactions) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] splittedTransactions = transactions.split(System.lineSeparator());
        for (String transaction : splittedTransactions) {
            fruitTransactions.add(parseTransaction(transaction));
        }
        return fruitTransactions;
    }

    private FruitTransaction parseTransaction(String line) {
        String[] fields = line.split(SPLIT_SYMBOL);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(Operation.getByFirstLetter(fields[OPERATION_INDEX].trim()));
        fruitTransaction.setFruit(fields[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
