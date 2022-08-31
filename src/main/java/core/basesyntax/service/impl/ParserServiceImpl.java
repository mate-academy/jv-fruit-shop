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
    public List<Transaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(s -> s.split(REGEX))
                .map(s ->
                        new Transaction(
                                s[INDEX_OF_COMMAND].trim(),
                                new Fruit(s[INDEX_OF_FRUIT_NAME].trim()),
                                Integer.parseInt(s[INDEX_OF_COUNT])))
                .collect(Collectors.toList());
    }
}
