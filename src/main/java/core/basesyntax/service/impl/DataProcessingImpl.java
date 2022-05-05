package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessing;
import core.basesyntax.strategy.OperationStrategy;
import java.util.ArrayList;
import java.util.List;

public class DataProcessingImpl implements DataProcessing {

    public DataProcessingImpl(OperationStrategy operationStrategy) {
    }

    @Override
    public List<FruitTransaction> convertDataIntoTransaction(List<String> dataList) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : dataList.subList(1, dataList.size())) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] strings = line.split(",");
            String letter = strings[0];
            String fruitName = strings[1];
            int quantity = Integer.parseInt(strings[2]);
            fruitTransaction.setFruit(fruitName);
            fruitTransaction.setQuantity(quantity);
            fruitTransaction.setOperation(FruitTransaction.Operation.findOperationByLetter(letter));
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
