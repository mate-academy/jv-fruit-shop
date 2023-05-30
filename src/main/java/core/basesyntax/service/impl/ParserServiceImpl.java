package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserServiceImpl implements ParserService {
    private static final int INDEX_OF_REDUNDANT_LINE = 0;
    private static final String COMA_SEPARATOR = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseReadedData(List<String> infoFromFile) {
        infoFromFile.remove(INDEX_OF_REDUNDANT_LINE);
        return infoFromFile.stream()
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(COMA_SEPARATOR);
        FruitTransaction.Operation operation = getOperationFromString(fields[INDEX_OF_OPERATION]);
        String fruit = fields[INDEX_OF_FRUIT];
        int quantity = Integer.parseInt(fields[INDEX_OF_QUANTITY]);
        return new FruitTransaction(operation, fruit, quantity);
    }

    private FruitTransaction.Operation getOperationFromString(String operationAbr) {
        return Stream.of(FruitTransaction.Operation.values())
                .filter(o -> o.getCode().equals(operationAbr))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Invalid operation " + operationAbr));
    }
}

