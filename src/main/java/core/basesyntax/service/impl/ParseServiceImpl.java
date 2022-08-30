package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParseService;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    private static final int ZERO_INDEX = 0;
    private static final int FIRST_INDEX = 1;
    private static final int SECOND_INDEX = 2;
    private static final String COMA = ",";

    @Override
    public List<Transaction> transactionsParser(List<String> transactions) {
        transactions.remove(ZERO_INDEX);
        return transactions.stream()
                .map(this::getTransaction)
                .collect(Collectors.toList());
    }

    private Transaction getTransaction(String string) {
        String[] splittedStrings = string.split(COMA);
        return new Transaction(splittedStrings[ZERO_INDEX].trim(),
                new Fruit(splittedStrings[FIRST_INDEX].trim()),
                Integer.parseInt(splittedStrings[SECOND_INDEX].trim()));
    }
}
