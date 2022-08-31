package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String COMMA = ",";
    private static final int ACTIVITIES_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int OPERATION_INDEX = 2;

    @Override
    public List<Transaction> parseToTransaction(List<String> list) {
        return list.stream()
                .map(line -> line.split(COMMA))
                .map(line -> new Transaction(line[ACTIVITIES_INDEX],
                        new Fruit(line[FRUIT_INDEX]),
                        Integer.parseInt(line[OPERATION_INDEX])))
                .collect(Collectors.toList());
    }
}
