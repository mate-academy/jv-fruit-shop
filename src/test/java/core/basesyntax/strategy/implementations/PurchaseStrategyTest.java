package core.basesyntax.strategy.implementations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.model.ShopItem;
import core.basesyntax.model.TransactionDto;
import org.junit.BeforeClass;
import org.junit.Test;

public class PurchaseStrategyTest {
    public static final TransactionDto PURCHASE_BANANA_POSITIVE_CORRECT =
            new TransactionDto(Operation.fromString("p"), new ShopItem("Burnout"), 1);
    public static final TransactionDto PURCHASE_BANANA_NEGATIVE_INCORRECT =
            new TransactionDto(Operation.fromString("p"), new ShopItem("Burnout"), -1);
    public static PurchaseStrategy purchaseStrategy;

    @BeforeClass
    public static void initialize() {
        purchaseStrategy = new PurchaseStrategy();
    }

    @Test
    public void validData_Correct() {
        Storage.storage.put(new ShopItem("Burnout"), 1);
        purchaseStrategy.apply(PURCHASE_BANANA_POSITIVE_CORRECT);
    }

    @Test(expected = RuntimeException.class)
    public void validDataButNoItemInStorage_ThrowsException() {
        purchaseStrategy.apply(PURCHASE_BANANA_POSITIVE_CORRECT);
    }

    @Test(expected = RuntimeException.class)
    public void invalidOperation_ThrowsException() {
        new TransactionDto(Operation.fromString("7"), new ShopItem("Burnout"), 1);
    }

    @Test(expected = RuntimeException.class)
    public void invalidQuantity_ThrowsException() {
        purchaseStrategy.apply(PURCHASE_BANANA_NEGATIVE_INCORRECT);
    }
}
