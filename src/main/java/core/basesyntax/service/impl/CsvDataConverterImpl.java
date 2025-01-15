package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvDataConverterImpl implements DataConverter {
    private static final String COMMA_DELIMITER = ",";
    private static final int FRUIT_INDEX = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int QUANTITY_INDEX = 2;
    private static final int VALUES_IN_LINE = 3;
    private final List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
    private final List<String> valuesFromLine = new ArrayList<>();

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
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
        getRecordFromLine(line);
        if (valuesFromLine.size() != VALUES_IN_LINE) {
            throw new RuntimeException("Wrong number of values in line: " + line);
        }
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .fromString(valuesFromLine.get(OPERATION_INDEX)));
        fruitTransaction.setFruit(valuesFromLine.get(FRUIT_INDEX));
        fruitTransaction.setQuantity(Integer.parseInt(valuesFromLine.get(QUANTITY_INDEX)));
        return fruitTransaction;
    }

    private void getRecordFromLine(String line) {
        valuesFromLine.clear();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                valuesFromLine.add(rowScanner.next());
            }
        }
    }

}
