package core.basesyntax.services;

import core.basesyntax.models.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface StorageService {
    void add(String fruit, int quantity);

    void remove(String fruit, int quantity);

    int getQuantity(String fruit);

    Map<String, Integer> getAll();

    void processTransactions(List<FruitTransaction> transactions);
}
