package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        if (inputReport == null) {
            throw new IllegalArgumentException("Input report cannot be null");
        }
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String line : inputReport) {
            if (line == null || line.trim().isEmpty()) {
                continue;
            }
            String[] splitedLine = line.trim().split(",");
            if (splitedLine.length != 3) {
                throw new IllegalArgumentException("Invalid line format: " + line);
            }
            Operation operation = getOperationByCode(splitedLine[0]);
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

    public Operation getOperationByCode(String code) {
        return Stream.of(Operation.values())
                .filter(op -> op.getCode().equals(code.trim()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown operation: " + code));
    }
}
