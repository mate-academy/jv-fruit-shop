package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    private static final String COMMA_SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseFile(List<String> input) {
        return input.stream()
                .map(line -> line.split(COMMA_SPLITTER))
                .map(line -> new FruitTransaction(FruitTransaction.fromCode(line[OPERATION_INDEX]),
                                line[FRUIT_INDEX], Integer.parseInt(line[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}
