package mate.academy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.model.FruitTransaction;
import mate.academy.service.ParseFile;

public class ParseFileImpl implements ParseFile {
    private static final int INDEX_TYPE_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    public List<FruitTransaction> parseFile(List<String> records) {
        return records.stream()
                .skip(1)
                .map(line -> line.trim().split(","))
                .map(splitLine -> new FruitTransaction(splitLine[INDEX_TYPE_OPERATION],
                        splitLine[INDEX_FRUIT],
                        Integer.parseInt(splitLine[INDEX_QUANTITY])))
                .map(this::checkRecords)
                .collect(Collectors.toList());
    }

    private FruitTransaction checkRecords(FruitTransaction fruitTransaction) {
        List<String> listOfTypeOperations = new ArrayList<>();
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            listOfTypeOperations.add(operation.getOperations());
        }
        if (!listOfTypeOperations.contains(fruitTransaction.getOperation())) {
            throw new RuntimeException("Unknown type operation");
        }
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity must be greater then 0");
        }
        return fruitTransaction;
    }
}

