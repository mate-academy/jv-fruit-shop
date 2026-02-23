package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BalanceOperationHandlerTest {
    private FruitDao fruitDao;
    private BalanceOperationHandler handler;

    @BeforeEach
    void setUp() {
        Storage.clear();
        fruitDao = new FruitDaoImpl();
        handler = new BalanceOperationHandler(fruitDao);
    }

    @Test
    void handle_validBalance_ok() {
        FruitTransaction transaction = new FruitTransaction(
                FruitTransaction.Operation.BALANCE, "apple", 50);
        handler.handle(transaction);
        assertEquals(50, fruitDao.getQuantity("apple"));
    }
}
