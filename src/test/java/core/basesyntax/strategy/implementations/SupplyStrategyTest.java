package core.basesyntax.strategy.implementations;

import core.basesyntax.model.Operation;
import core.basesyntax.model.ShopItem;
import core.basesyntax.model.TransactionDto;
import org.junit.BeforeClass;
import org.junit.Test;

public class SupplyStrategyTest {
    public static final TransactionDto SUPPLY_BANANA_POSITIVE_CORRECT =
            new TransactionDto(Operation.fromString("s"), new ShopItem("Mate Academy"), 666);
    public static final TransactionDto SUPPLY_BANANA_NEGATIVE_INCORRECT =
            new TransactionDto(Operation.fromString("s"), new ShopItem("Mate Academy"), -666);
    public static SupplyStrategy supplyStrategy;

    @BeforeClass
    public static void initialize() {
        supplyStrategy = new SupplyStrategy();
    }

    @Test
    public void validData_Correct() {
        supplyStrategy.apply(SUPPLY_BANANA_POSITIVE_CORRECT);
    }

    @Test(expected = RuntimeException.class)
    public void invalidOperation_ThrowsException() {
        new TransactionDto(Operation.fromString("G"), new ShopItem("Mate Academy"), 666);
    }

    @Test(expected = RuntimeException.class)
    public void invalidQuantity_ThrowsException() {
        supplyStrategy.apply(SUPPLY_BANANA_NEGATIVE_INCORRECT);
    }
}
