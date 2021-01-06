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

public class PurchaseStrategyTest {
    public static final ShopItem SHOP_ITEM = new ShopItem("Burnout");
    public static final TransactionDto PURCHASE_ITEM_POSITIVE_CORRECT =
            new TransactionDto(Operation.fromString("p"), SHOP_ITEM, 1);
    public static final TransactionDto PURCHASE_ITEM_NEGATIVE_INCORRECT =
            new TransactionDto(Operation.fromString("p"), SHOP_ITEM, -1);
    public static PurchaseStrategy purchaseStrategy;
    public static OperationsDao dao;

    @BeforeClass
    public static void initialize() {
        dao = new OperationsDao();
        purchaseStrategy = new PurchaseStrategy(dao);
    }

    @After
    public void tearDown() {
        Storage.storage.clear();
    }

    @Test
    public void validData_Correct() {
        Storage.storage.put(SHOP_ITEM, 5);
        purchaseStrategy.apply(PURCHASE_ITEM_POSITIVE_CORRECT);
        Integer expected = 4;
        Integer actual = Storage.storage.get(SHOP_ITEM);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void validDataButNoItemInStorage_ThrowsException() {
        purchaseStrategy.apply(PURCHASE_ITEM_POSITIVE_CORRECT);
    }

    @Test(expected = RuntimeException.class)
    public void invalidQuantity_ThrowsException() {
        purchaseStrategy.apply(PURCHASE_ITEM_NEGATIVE_INCORRECT);
    }
}
