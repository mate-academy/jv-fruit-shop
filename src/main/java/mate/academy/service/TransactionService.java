package mate.academy.service;

import java.util.List;
import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.strategy.activities.ActivityHandler;

public interface TransactionService {
    Map<String, Integer> processedData(
            List<FruitTransaction> fruitTransactionList,
            Map<FruitTransaction.Operation, ActivityHandler> activityHandlerMap);
}
