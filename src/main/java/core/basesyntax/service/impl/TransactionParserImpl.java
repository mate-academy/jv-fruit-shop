package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final String REGEX = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String lines: data) {
            String[] fields = lines.split(REGEX);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.getByCode(fields[OPERATION]));
            fruitTransaction.setFruit(fields[FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY]));
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
