package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FruitTransactionService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int ROW_COUNT_INDEX = 3;
    private final Map<String, FruitTransaction.Type> mapTypeOperation;

    public FruitTransactionServiceImpl() {
        mapTypeOperation = getMapTypeOperation();
    }

    @Override
    public List<FruitTransaction> transaction(List<String> fruitData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        return fruitData.stream()
                .map(f -> f.split(","))
                .filter(array -> array.length == ROW_COUNT_INDEX
                && mapTypeOperation.containsKey(array[OPERATION_INDEX]))
                .map(this::createTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction createTransaction(String[] fields) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setType(mapTypeOperation.get(fields[OPERATION_INDEX]));
        fruitTransaction.setFruit(fields[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
        return fruitTransaction;
    }

    private Map<String, FruitTransaction.Type> getMapTypeOperation() {
        return Arrays.stream(FruitTransaction.Type.values())
                .collect(Collectors.toMap(
                        FruitTransaction.Type::getTypeOperation, Function.identity()));
    }
}
