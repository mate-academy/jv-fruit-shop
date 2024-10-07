package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : inputData.subList(1, inputData.size())) {
            String[] partsOfData = line.split(",");
            FruitTransaction.Operation fruitOperation =
                    FruitTransaction.Operation.valueOf(partsOfData[0]);
            String fruit = partsOfData[1];
            int quantity = Integer.parseInt(partsOfData[2]);
            fruitTransactions.add(new FruitTransaction(fruitOperation, fruit, quantity));
        }
        return fruitTransactions;
    }
}
