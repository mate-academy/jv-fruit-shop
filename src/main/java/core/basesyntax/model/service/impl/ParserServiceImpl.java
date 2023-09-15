package core.basesyntax.model.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.model.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String SPLIT_DELIMITER = ",";
    private static final int PARTS_LENGTH = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransaction(List<String> lines) {
        return lines.stream()
                .map(line -> line.split(SPLIT_DELIMITER))
                .filter(parts -> parts.length == PARTS_LENGTH)
                .map(parts -> {
                    Operation operation = Operation.of(parts[OPERATION_INDEX].trim());
                    String fruit = parts[FRUIT_INDEX].trim();
                    int quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .collect(Collectors.toList());
    }
}
