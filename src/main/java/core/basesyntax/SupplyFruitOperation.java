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
        storage.merge(name, transaction, (t1, t2) -> {
            storage.get(name).setQuantity(t1.getQuantity() + t2.getQuantity());
            return t1;
        });
        return storage;
    }
}
