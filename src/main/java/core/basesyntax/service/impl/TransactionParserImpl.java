package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int TITLE_LINE = 1;

    @Override
    public List<FruitTransaction> toTransaction(List<String> inputData) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = TITLE_LINE; i < inputData.size(); i++) {
            transactions.add(parseLine(inputData.get(i)));
        }
        return transactions;
    }

    private FruitTransaction parseLine(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] activities = line.split(SEPARATOR);
        fruitTransaction.setFruit(activities[FRUIT_INDEX]);
        fruitTransaction.setOperation(FruitTransaction
                .Operation.getByCode(activities[OPERATION_INDEX]));
        fruitTransaction.setQuantity(Integer.parseInt(activities[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}