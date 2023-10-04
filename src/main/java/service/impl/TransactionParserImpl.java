package service.impl;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    private static final int TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final int COUNT = 3;
    private static final String SPLITERATOR = ",";
    private final Map<String, FruitTransaction.Operation> mapOperations;

    public TransactionParserImpl() {
        mapOperations = createMapOperations();
    }

    @Override
    public List<FruitTransaction> getTransactionList(List<String> data) {
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        return data.stream()
                .map(d -> d.split(SPLITERATOR))
                .filter(array -> array.length == COUNT
                        && mapOperations.containsKey(array[TYPE]))
                .map(this::createTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction createTransaction(String[] fields) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(mapOperations.get(fields[TYPE]));
        fruitTransaction.setFruit(fields[FRUIT_NAME]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY]));
        return fruitTransaction;
    }

    private Map<String, FruitTransaction.Operation> createMapOperations() {
        return Arrays.stream(FruitTransaction.Operation.values())
                .map(o -> new AbstractMap.SimpleEntry<>(o.getOperation(), o))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
