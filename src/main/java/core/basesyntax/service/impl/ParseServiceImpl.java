package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.List;

public class ParseServiceImpl implements ParseService {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final int INDEX_DATA = 1;
    private static final int EMPTY_LIST = 0;
    private static final int INVALID_DATA = 1;
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseStringsToTransactions(List<String> list) {
        checkList(list);
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = INDEX_DATA; i < list.size(); i++) {
            String[] currentTransaction = list.get(i).split(COMMA_SEPARATOR);
            String operation = currentTransaction[INDEX_OPERATION];
            String fruit = currentTransaction[INDEX_FRUIT];
            int quantity = Integer.parseInt(currentTransaction[INDEX_QUANTITY]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }

    private void checkList(List<String> list) {
        if (list == null) {
            throw new RuntimeException("List of operations equals null");
        }
        if (list.size() == EMPTY_LIST) {
            throw new RuntimeException("List is empty");
        }
        if (list.size() == INVALID_DATA) {
            throw new RuntimeException("List has not valid operation's data");
        }
    }
}
