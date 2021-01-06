package core.basesyntax.strategy.implementations;

import core.basesyntax.dao.OperationsDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.model.ShopItem;
import core.basesyntax.model.TransactionDto;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BalanceStrategyTest {
    public static final ShopItem SHOP_ITEM = new ShopItem("banana");
    public static final TransactionDto BALANCE_ITEM_POSITIVE_CORRECT =
            new TransactionDto(Operation.fromString("b"), SHOP_ITEM, 10);
    public static final TransactionDto BALANCE_ITEM_NEGATIVE_INCORRECT =
            new TransactionDto(Operation.fromString("b"), SHOP_ITEM, -10);
    public static BalanceStrategy balanceStrategy;
    public static OperationsDao dao;

    @BeforeClass
    public static void initialize() {
        dao = new OperationsDao();
        balanceStrategy = new BalanceStrategy(dao);
    }

    @After
    public void tearDown() {
        Storage.storage.clear();
    }

    @Test
    public void validData_Correct() {
        balanceStrategy.apply(BALANCE_ITEM_POSITIVE_CORRECT);
        Integer expected = 10;
        Integer actual = Storage.storage.get(SHOP_ITEM);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void invalidQuantity_ThrowsException() {
        balanceStrategy.apply(BALANCE_ITEM_NEGATIVE_INCORRECT);
    }
}
