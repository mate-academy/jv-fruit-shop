package core.basesyntax;

import java.util.Map;

public class SupplyFruitOperation extends FruitOperation {
    public SupplyFruitOperation(OperationType type, Transaction fruit) {
        super(type, fruit);
    }

    @Override
    public Map<String, Transaction> execute(int totalQuantity,
                                            Map<String, Transaction> storage) {
        String name = transaction.getFruitType();
        int quantity = transaction.getQuantity();
        if (storage.containsKey(name)) {
            storage.get(name).setQuantity(storage.get(name).getQuantity() + quantity);
        } else {
            storage.put(name, transaction);
        }
        return storage;
    }
}
