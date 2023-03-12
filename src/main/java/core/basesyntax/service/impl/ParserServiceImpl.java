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
    public List<Transaction> parse(List<String> lines) {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String [] part = lines.get(i).split(REGEX);
            transactions.add(new Transaction(part[INDEX_OPERATION],
                    new Fruit(part[INDEX_FRUIT]),
                    Integer.parseInt(part[INDEX_QUANTITY])));
        }
        return transactions;
    }
}
