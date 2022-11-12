package mate.academy.service;

import java.util.List;
import java.util.Map;
import mate.academy.model.FruitTransaction;

public interface TransactionService {
    Map<String, Integer> processedData(
            List<FruitTransaction> fruitTransactionList);
}
