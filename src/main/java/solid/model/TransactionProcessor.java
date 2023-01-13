package solid.model;

import java.util.List;

public interface TransactionProcessor {
    void process(List<FruitTransaction> transactions);
}
