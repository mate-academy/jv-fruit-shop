package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.TransactionParser;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    private final Map<String, FruitTransaction.Operation> operationMap;

    public TransactionParserImpl() {
        operationMap = getMapOperation();
    }

    @Override
    public List<FruitTransaction> transaction(List<String> fruitData) {
        return fruitData.stream()
                .map(f -> f.split(","))
                .skip(1)
                .map(this::createTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction createTransaction(String[] fields) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(operationMap.get(fields[OPERATION_INDEX]));
        fruitTransaction.setFruit(fields[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
        return fruitTransaction;
    }

    private Map<String, FruitTransaction.Operation> getMapOperation() {
        return Arrays.stream(FruitTransaction.Operation.values())
                .map(operation -> new AbstractMap
                        .SimpleEntry<>(operation.getCode(), operation))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue));
    }
}
