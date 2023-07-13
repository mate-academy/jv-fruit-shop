package core.basesyntax.service.impl;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int FIELDS_COUNT = 3;
    private static final int ACTIVITIES_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final Map<String, FruitTransaction.Operation> mapFromEnumOperations;

    public FruitTransactionParserImpl() {
        mapFromEnumOperations = createMapFromEnumOperations();
    }

    @Override
    public List<FruitTransaction> getFruitTransactionsList(List<String> data) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        return data.stream()
                .map(s -> s.split(","))
                .filter(array -> array.length == FIELDS_COUNT
                        && mapFromEnumOperations.containsKey(array[ACTIVITIES_TYPE_INDEX]))
                .map(this::createFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction createFruitTransaction(String[] fieldsFromLine) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(mapFromEnumOperations
                .get(fieldsFromLine[ACTIVITIES_TYPE_INDEX]));
        fruitTransaction.setFruit(fieldsFromLine[FRUIT_NAME_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(fieldsFromLine[QUANTITY_INDEX]));
        return fruitTransaction;
    }

    private Map<String, FruitTransaction.Operation> createMapFromEnumOperations() {
        return Arrays.stream(FruitTransaction.Operation.values())
                .map(e -> new AbstractMap.SimpleEntry<>(e.getOperation(), e))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
