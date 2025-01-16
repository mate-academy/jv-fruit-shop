package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvDataConverterImpl implements DataConverter {
    private static final String COMMA_DELIMITER = ",";
    private static final int FRUIT_INDEX = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int QUANTITY_INDEX = 2;
    private static final int VALUES_IN_LINE = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        boolean isFirstLine = true;
        for (String line : lines) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            fruitTransactionsList.add(formFruitTransaction(line));
        }
        return fruitTransactionsList;
    }

    private FruitTransaction formFruitTransaction(String line) {
        List<String> values = List.of(line.split(COMMA_DELIMITER));
        if (values.size() != VALUES_IN_LINE) {
            throw new RuntimeException("Wrong data format: " + line);
        }
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .fromString(values.get(OPERATION_INDEX)));
        fruitTransaction.setFruit(values.get(FRUIT_INDEX));
        fruitTransaction.setQuantity(Integer.parseInt(values.get(QUANTITY_INDEX)));
        return fruitTransaction;
    }
}
