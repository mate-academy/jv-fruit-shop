package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int COLUMNS_COUNT = 3;
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COLUMNS_SEPARATOR = ",";
    private final Map<String, FruitTransaction.Operation> mapOfEnumOperations;

    public FruitTransactionParserImpl() {
        mapOfEnumOperations = createMapOfEnumOperations();
    }

    @Override
    public List<FruitTransaction> getFruitTransactionsList(List<String> dataFromCsvInput) {
        return dataFromCsvInput.stream()
                .map(s -> s.split(COLUMNS_SEPARATOR))
                .filter(array -> array.length == COLUMNS_COUNT
                        && mapOfEnumOperations.containsKey(array[OPERATION_TYPE_INDEX]))
                .map(this::createFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction createFruitTransaction(String[] dataFromLine) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(mapOfEnumOperations
                .get(dataFromLine[OPERATION_TYPE_INDEX]));
        fruitTransaction.setFruit(dataFromLine[FRUIT_NAME_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(dataFromLine[QUANTITY_INDEX]));
        return fruitTransaction;
    }

    private Map<String, FruitTransaction.Operation> createMapOfEnumOperations() {
        return Arrays.stream(FruitTransaction.Operation.values())
                .map(operation ->
                        new AbstractMap.SimpleEntry<>(operation.getOperation(), operation))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }
}
