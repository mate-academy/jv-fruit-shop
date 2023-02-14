package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionService;
import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private static final String REGEX = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<Transaction> parse(List<String> list) {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            String[] entries = list.get(i).split(REGEX);
            transactions.add(new Transaction(entries[OPERATION_INDEX],
                    new Fruit(entries[FRUIT_INDEX]),
                    Integer.parseInt(entries[QUANTITY_INDEX])));
        }
        return transactions;
    }
}
