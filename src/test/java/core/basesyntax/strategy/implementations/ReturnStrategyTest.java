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

public class ReturnStrategyTest {
    public static final ShopItem SHOP_ITEM = new ShopItem("SAMURAI");
    public static final TransactionDto RETURN_ITEM_POSITIVE_CORRECT =
            new TransactionDto(Operation.fromString("r"), SHOP_ITEM, 1337);
    public static final TransactionDto RETURN_ITEM_NEGATIVE_INCORRECT =
            new TransactionDto(Operation.fromString("r"), SHOP_ITEM, -1);
    public static ReturnStrategy returnStrategy;
    public static OperationsDao dao;

    @BeforeClass
    public static void initialize() {
        dao = new OperationsDao();
        returnStrategy = new ReturnStrategy(dao);
    }

    @After
    public void tearDown() {
        Storage.storage.clear();
    }

    @Test
    public void validData_Correct() {
        returnStrategy.apply(RETURN_ITEM_POSITIVE_CORRECT);
        Integer expected = 1337;
        Integer actual = Storage.storage.get(SHOP_ITEM);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void invalidQuantity_ThrowsException() {
        returnStrategy.apply(RETURN_ITEM_NEGATIVE_INCORRECT);
    }
}
