package core.basesyntax;

import java.util.Map;

public class BuyFruitOperation extends FruitOperation {
    public BuyFruitOperation(OperationType type, Transaction fruit) {
        super(type, fruit);
    }

    @Override
    public Map<String, Transaction> execute(int totalQuantity,
                                            Map<String, Transaction> storage) {
        String name = transaction.getFruitType();
        int fruitQuantity = transaction.getQuantity();
        if (!storage.containsKey(name)) {
            throw new RuntimeException("The fruit does not exist");
        }
        if (totalQuantity >= fruitQuantity) {
            for (Transaction transaction : storage.values()) {
                if (transaction.getFruitType().equals(name) && !transaction.isEmpty()) {
                    int fruitCount = transaction.getQuantity();
                    if (fruitQuantity <= fruitCount) {
                        transaction.setQuantity(fruitCount - fruitQuantity);
                    }
                }
            }
            return storage;
        }
        throw new RuntimeException("Storage does not contain such fruitQuantity of fruit");
    }
}
