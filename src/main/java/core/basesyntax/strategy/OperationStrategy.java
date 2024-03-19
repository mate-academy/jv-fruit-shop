package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Balance;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Purchase;
import core.basesyntax.model.Return;
import core.basesyntax.model.Supply;

public class OperationStrategy {

    public void processData(Operation operation) {
        if (operation == null) {
            throw new RuntimeException("Operation is null");
        }
        if (operation instanceof Balance b) {
            Storage.data.put(b.getProduct(), b.getAmount());
        } else if (operation instanceof Purchase p) {
            Storage.data.put(p.getProduct(),
                    Storage.data.getOrDefault(p.getProduct(), 0) - p.getAmount());
        } else if (operation instanceof Return r) {
            Storage.data.put(r.getProduct(),
                    Storage.data.getOrDefault(r.getProduct(), 0) + r.getAmount());
        } else if (operation instanceof Supply s) {
            Storage.data.put(s.getProduct(),
                    Storage.data.getOrDefault(s.getProduct(), 0) + s.getAmount());
        } else {
            throw new IllegalArgumentException("Unknown operation type");
        }
    }
}
