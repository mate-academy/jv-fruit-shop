package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String CSV_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        if (inputReport == null) {
            throw new IllegalArgumentException("Input report cannot be null");
        }
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String line : inputReport) {
            if (line == null || line.isBlank()) {
                continue;
            }
            String[] splitedLine = line.split(CSV_SEPARATOR);
            if (splitedLine.length != 3) {
                throw new IllegalArgumentException("Invalid line format: " + line);
            }
            Operation operation = Operation.getOperationByCode(splitedLine[0]);
            int quantity;
            try {
                quantity = Integer.parseInt(splitedLine[2]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number format in line: " + line, e);
            }
            FruitTransaction fruitTransaction =
                    new FruitTransaction(operation, splitedLine[1], quantity);
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
