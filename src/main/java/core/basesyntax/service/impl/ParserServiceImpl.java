package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserServiceImpl implements ParserService {
    private static final String COMA_SEPARATOR = ",";
    private static final int HEADER_LINES_COUNT = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> infoFromFile) {
        return infoFromFile.stream()
                .skip(HEADER_LINES_COUNT)
                .map(this::parseCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseCsvRow(String line) {
        String[] fields = line.split(COMA_SEPARATOR);
        FruitTransaction.Operation operation = getOperationFromString(fields[OPERATION_INDEX]);
        String fruit = fields[FRUIT_INDEX];
        int quantity = Integer.parseInt(fields[QUANTITY_INDEX]);
        return new FruitTransaction(operation, fruit, quantity);
    }

    private FruitTransaction.Operation getOperationFromString(String operationAbr) {
        return Stream.of(FruitTransaction.Operation.values())
                .filter(o -> o.getCode().equals(operationAbr))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Invalid operation "
                        + operationAbr));
    }
}

