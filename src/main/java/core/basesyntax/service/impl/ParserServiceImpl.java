package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final String REGEX = ",";

    @Override
    public List<Transaction> parse(List<String> lines) {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] fields = line.split(REGEX);
            Transaction transaction = new Transaction();
            transaction.setOperation(fields[OPERATION]);
            transaction.setFruit(new Fruit(fields[FRUIT]));
            transaction.setQuantity(Integer.parseInt(fields[QUANTITY]));
            transactions.add(transaction);
        }
        return transactions;
    }
}
