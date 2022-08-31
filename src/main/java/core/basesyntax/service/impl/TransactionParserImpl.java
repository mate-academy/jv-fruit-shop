package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<Transaction> transactionParser(List<String> list) {
        String[] parsedData;
        Fruit fruit = new Fruit("");
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            parsedData = list.get(i).split(",");
            fruit.setName(parsedData[FRUIT_NAME]);
            transactions.add(new Transaction(parsedData[OPERATION],
                    new Fruit(parsedData[FRUIT_NAME]), Integer.parseInt(parsedData[QUANTITY])));
        }
        return transactions;
    }
}
