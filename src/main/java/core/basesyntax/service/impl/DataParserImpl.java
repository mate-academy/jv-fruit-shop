package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserImpl implements DataParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLine(String line) {
        String[] splitted = line.split(SPLITTER);
        FruitTransaction.Operation operation =
                Arrays.stream(FruitTransaction.Operation.values())
                        .filter(o -> o.getOperation().equals(splitted[OPERATION_INDEX]))
                        .findFirst()
                        .get();
        String fruitName = splitted[FRUIT_INDEX];
        int amount = Integer.parseInt(splitted[QUANTITY_INDEX]);
        return new FruitTransaction(operation, fruitName, amount);
    }

}
