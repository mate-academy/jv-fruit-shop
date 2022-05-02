package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int HEADER_INDEX = 1;
    private static final String COMMA = ",";

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        return data.stream()
                .skip(HEADER_INDEX)
                .map(this::lineToFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction lineToFruitTransaction(String line) {
        String[] splitLine = line.split(COMMA);
        return new FruitTransaction(splitLine[OPERATION_INDEX],
                new Fruit(splitLine[FRUIT_INDEX]),
                Integer.parseInt(splitLine[QUANTITY_INDEX]));
    }
}
