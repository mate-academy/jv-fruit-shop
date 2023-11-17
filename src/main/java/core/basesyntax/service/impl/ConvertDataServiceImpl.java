package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ConvertDataService;
import core.basesyntax.service.exception.NoSuchOperationException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConvertDataServiceImpl implements ConvertDataService {
    private static final String DELIMITER_COMMA = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> processingData(List<String> fruits) {
        return fruits.stream()
                .map(this::createNewTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction createNewTransaction(String dataFromReport) {
        String[] strings = getArrayFromString(dataFromReport);
        FruitTransaction transaction = new FruitTransaction(
                getOperation(strings[INDEX_OPERATION]),
                getFruit(strings[INDEX_FRUIT]),
                getQuantity(strings[INDEX_QUANTITY]));
        return transaction;
    }

    private Operation getOperation(String w) {
        for (Operation value : Operation.values()) {
            if (Objects.equals(value.getCode(), w.trim())) {
                return value;
            }
        }
        throw new NoSuchOperationException("No such operation");
    }

    private String getFruit(String fruitName) {
        if (fruitName == null || fruitName.isEmpty()) {
            throw new NoSuchOperationException("Element shouldn't be " + fruitName);
        }
        return fruitName;
    }

    private int getQuantity(String string) {
        if (string == null || string.isEmpty()) {
            throw new NoSuchOperationException("Quantity is wrong");
        }
        int quantity = Integer.parseInt(string);
        if (quantity < 0) {
            throw new NoSuchOperationException("Quantity must be positive number, not " + quantity);
        }

        return quantity;
    }

    private String[] getArrayFromString(String fruitString) {
        return fruitString.split(DELIMITER_COMMA);
    }
}
