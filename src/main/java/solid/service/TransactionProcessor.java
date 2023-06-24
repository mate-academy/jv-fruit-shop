package solid.service;

import java.util.List;
import solid.model.FruitTransaction;

public interface TransactionProcessor {
    void process(List<FruitTransaction> transactions);
}
