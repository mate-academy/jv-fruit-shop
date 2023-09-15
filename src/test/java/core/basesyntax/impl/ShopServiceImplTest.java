package core.basesyntax.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.OperationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopServiceImplTest {

    private final FruitTransaction fruit1 = new FruitTransaction(FruitTransaction
            .Operation.BALANCE, "banana", 20);
    private final StorageDao storageDao = new StorageDaoImpl();
    private final HashMap<FruitTransaction.Operation, OperationHandler> operationHashMap
            = new HashMap<>();
    private final List<FruitTransaction> fruitTransactions = new ArrayList<>();
    private final Map<String, Integer> storage = Storage.getFruits();
    private final OperationStrategy operationStrategy =
            new OperationStrategyImpl(operationHashMap);
    private final ShopService shopService = new ShopServiceImpl(operationStrategy);

    @Test
    void processTransactions_Ok() {
        operationHashMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(storageDao));
        fruitTransactions.add(fruit1);
        storage.clear();
        shopService.processTransactions(fruitTransactions);
        Assertions.assertTrue(storage.containsKey("banana") && storage.get("banana").equals(20));
    }

    @Test
    void processTransactionsWithEmptyList_Ok() {
        fruitTransactions.clear();
        storage.clear();
        shopService.processTransactions(fruitTransactions);
        Assertions.assertTrue(storage.isEmpty());
    }
}
