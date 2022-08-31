package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String REGEX = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<Transaction> parse(List<String> data) {
        List<Transaction> transactions = new ArrayList<>();
        data.stream()
                .skip(1)
                .map(d -> d.split(REGEX))
                .forEach(fiel -> {
                    Transaction transaction = new Transaction();
                    transaction.setOperation(fiel[INDEX_OPERATION]);
                    transaction.setFruit(new Fruit(fiel[INDEX_FRUIT]));
                    transaction.setQuantity(Integer.parseInt(fiel[INDEX_QUANTITY]));
                    transactions.add(transaction);
                });
        return transactions;
    }
}
