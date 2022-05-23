package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitData;
import core.basesyntax.strategy.OperationStrategy;
import java.util.ArrayList;
import java.util.List;

public class FruitDataImpl implements FruitData {

    public FruitDataImpl(OperationStrategy operationStrategy) {
    }

    @Override
    public List<FruitTransaction> convertDataIntoTransaction(List<String> fruitDataList) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String record : fruitDataList.subList(1, fruitDataList.size())) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] strings = record.split(",");
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
