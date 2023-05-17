package core.basesyntax.process;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitDataProcessImpl implements FruitDataProcess {
    private Map<String, Integer> fruitsQuantity;

    public FruitDataProcessImpl() {
        this.fruitsQuantity = new HashMap<>();
    }

    @Override
    public Map<String, Integer> processFruitData(List<FruitTransaction> fruitTransactionList) {
        if (fruitTransactionList.isEmpty()) {
            throw new RuntimeException("Empty list: " + fruitTransactionList);
        }
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            String fruit = fruitTransaction.getFruit();
            int quantity = fruitTransaction.getQuantity();
            if (fruitTransaction.getOperation() == FruitTransaction.Operation.BALANCE) {
                fruitsQuantity.put(fruit, quantity);
            } else if (fruitsQuantity.containsKey(fruit)) {
                int currentQuantity = fruitsQuantity.get(fruit);
                switch (fruitTransaction.getOperation()) {
                    case SUPPLY:
                    case RETURN:
                        fruitsQuantity.put(fruit, currentQuantity + quantity);
                        break;
                    case PURCHASE:
                        fruitsQuantity.put(fruit, currentQuantity - quantity);
                        break;
                    default:
                        throw new RuntimeException("No such operation!");
                }
            }
        }
        return fruitsQuantity;
    }
}
