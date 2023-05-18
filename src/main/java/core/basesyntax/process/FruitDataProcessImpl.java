package core.basesyntax.process;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Storage;
import java.util.List;

public class FruitDataProcessImpl implements FruitDataProcess {
    @Override
    public void processFruitData(List<FruitTransaction> fruitTransactionList) {
        if (fruitTransactionList.isEmpty()) {
            throw new RuntimeException("Empty list: " + fruitTransactionList);
        }
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            String fruit = fruitTransaction.getFruit();
            int quantity = fruitTransaction.getQuantity();
            if (fruitTransaction.getOperation() == FruitTransaction.Operation.BALANCE) {
                Storage.fruits.put(fruit, quantity);
            } else if (Storage.fruits.containsKey(fruit)) {
                int currentQuantity = Storage.fruits.get(fruit);
                switch (fruitTransaction.getOperation()) {
                    case SUPPLY:
                    case RETURN:
                        Storage.fruits.put(fruit, currentQuantity + quantity);
                        break;
                    case PURCHASE:
                        Storage.fruits.put(fruit, currentQuantity - quantity);
                        break;
                    default:
                        throw new RuntimeException("No such operation!");
                }
            }
        }
    }
}
