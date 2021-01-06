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

public class SupplyStrategyTest {
    public static final ShopItem SHOP_ITEM = new ShopItem("Mate Academy");
    public static final TransactionDto SUPPLY_ITEM_POSITIVE_CORRECT =
            new TransactionDto(Operation.fromString("s"), SHOP_ITEM, 666);
    public static final TransactionDto SUPPLY_ITEM_NEGATIVE_INCORRECT =
            new TransactionDto(Operation.fromString("s"), SHOP_ITEM, -666);
    public static SupplyStrategy supplyStrategy;
    public static OperationsDao dao;

    @BeforeClass
    public static void initialize() {
        dao = new OperationsDao();
        supplyStrategy = new SupplyStrategy(dao);
    }

    @After
    public void tearDown() {
        Storage.storage.clear();
    }

    @Test
    public void validData_Correct() {
        supplyStrategy.apply(SUPPLY_ITEM_POSITIVE_CORRECT);
        Integer expected = 666;
        Integer actual = Storage.storage.get(SHOP_ITEM);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void invalidQuantity_ThrowsException() {
        supplyStrategy.apply(SUPPLY_ITEM_NEGATIVE_INCORRECT);
    }
}
