package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {

    private static final int INDEX_OF_COMMAND = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_COUNT = 2;
    private static final String REGEX = ",";

    @Override
    public List<Transaction> parse(List<String> transactions) {
        return transactions.stream()
                .skip(1)
                .map(this::getTransactionFromString)
                .collect(Collectors.toList());
    }

    private Transaction getTransactionFromString(String value) {
        String[] words = value.split(REGEX);
        return new Transaction(
                words[INDEX_OF_COMMAND].trim(),
                new Fruit(words[INDEX_OF_FRUIT_NAME].trim()),
                Integer.parseInt(words[INDEX_OF_COUNT]));
    }
}
