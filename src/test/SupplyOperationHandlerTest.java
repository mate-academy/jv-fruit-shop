package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupplyOperationHandlerTest {
    private FruitDao fruitDao;
    private SupplyOperationHandler handler;

    @BeforeEach
    void setUp() {
        Storage.clear();
        fruitDao = new FruitDaoImpl();
        handler = new SupplyOperationHandler(fruitDao);
    }

    @Test
    void handle_validSupply_ok() {
        fruitDao.add("apple", 10);
        FruitTransaction transaction = new FruitTransaction(
                FruitTransaction.Operation.SUPPLY, "apple", 5);
        handler.handle(transaction);
        assertEquals(15, fruitDao.getQuantity("apple"));
    }
}
