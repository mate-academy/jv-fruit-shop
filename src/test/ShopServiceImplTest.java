package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShopServiceImplTest {
    private ShopService shopService;
    private FruitDao fruitDao;

    @BeforeEach
    void setUp() {
        Storage.clear();
        fruitDao = new FruitDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(fruitDao));

        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        shopService = new ShopServiceImpl(strategy);
    }

    @Test
    void constructor_nullStrategy_notOk() {
        assertThrows(RuntimeException.class,
                () -> new ShopServiceImpl(null));
    }

    @Test
    void process_validTransactions_ok() {
        List<FruitTransaction> transactions = List.of(
                new FruitTransaction(FruitTransaction.Operation.SUPPLY,
                        "banana", 10));
        shopService.process(transactions);
        assertEquals(10, fruitDao.getQuantity("banana"));
    }

    @Test
    void process_nullTransactions_notOk() {
        assertThrows(RuntimeException.class,
                () -> shopService.process(null));
    }

    @Test
    void process_listWithNullTransaction_notOk() {
        List<FruitTransaction> transactions = new ArrayList<>();
        transactions.add(null);
        assertThrows(RuntimeException.class,
                () -> shopService.process(transactions));
    }

    @Test
    void process_transactionWithNullOperation_notOk() {
        List<FruitTransaction> transactions = List.of(
                new FruitTransaction(null, "apple", 10));
        assertThrows(RuntimeException.class,
                () -> shopService.process(transactions));
    }
}
