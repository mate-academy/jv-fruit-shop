package core.basesyntax;

import java.util.Map;

public class ReturnFruitOperation extends FruitOperation {
    public ReturnFruitOperation(OperationType type, Transaction fruit) {
        super(type, fruit);
    }

    @Override
    public Map<String, Transaction> execute(int totalQuantity,
                                            Map<String, Transaction> storage) {
        for (Transaction transaction : storage.values()) {
            if (transaction.getDate().isEqual(this.transaction.getDate())) {
                transaction.setQuantity(transaction.getQuantity() + this.transaction.getQuantity());
            }
        }
        return storage;
    }
}
