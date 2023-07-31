package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;

import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    private static final String COMMA_REGEX = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        return data.stream()
                .map(line -> line.split(COMMA_REGEX))
                .map(this::createFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction createFruitTransaction(String[] dataLine) {
        return new FruitTransaction(
                dataLine[OPERATION_INDEX],
                dataLine[FRUIT_INDEX],
                Integer.parseInt(dataLine[AMOUNT_INDEX]));
    }
}
