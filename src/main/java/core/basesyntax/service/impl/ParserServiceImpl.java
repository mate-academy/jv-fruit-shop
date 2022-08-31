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
    private static final int SKIP_HEADERS = 1;
    private static final String REGEX = ",";

    @Override
    public List<Transaction> parse(List<String> lines) {
        return lines.stream()
                .skip(SKIP_HEADERS)
                .map(line -> line.split(REGEX))
                .map(parametersArray ->
                        new Transaction(
                                parametersArray[INDEX_OF_COMMAND],
                                new Fruit(parametersArray[INDEX_OF_FRUIT_NAME]),
                                Integer.parseInt(parametersArray[INDEX_OF_COUNT])))
                .collect(Collectors.toList());
    }
}
