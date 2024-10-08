package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputData) {
        if (inputData.isEmpty()) {
            return new ArrayList<>();
        }

        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : inputData.subList(1, inputData.size())) {
            String[] partsOfData = line.split(",");
            if (partsOfData.length != 3) {
                throw new IllegalArgumentException("Incorrect input data in line: " + line);
            }
            Operation fruitOperation = Operation.valueOf(partsOfData[0]);
            String fruit = partsOfData[1];
            try {
                int quantity = Integer.parseInt(partsOfData[2]);
                fruitTransactions.add(new FruitTransaction(fruitOperation, fruit, quantity));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity format in line: " + line);
            }
        }
        return fruitTransactions;
    }
}
