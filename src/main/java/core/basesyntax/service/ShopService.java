package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ShopService {
    void processTransactions(List<FruitTransaction> fruitTransactionList);

    Map<String, Integer> getReportData();

    void updateStorage(String fruit, int quantity);

    void reduceStorage(String fruit, int quantity);
}
