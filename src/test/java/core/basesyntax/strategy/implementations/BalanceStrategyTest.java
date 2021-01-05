package core.basesyntax.strategy.implementations;

import core.basesyntax.model.Operation;
import core.basesyntax.model.ShopItem;
import core.basesyntax.model.TransactionDto;
import org.junit.BeforeClass;
import org.junit.Test;

public class BalanceStrategyTest {
    public static final TransactionDto BALANCE_BANANA_POSITIVE_CORRECT =
            new TransactionDto(Operation.fromString("b"), new ShopItem("banana"), 10);
    public static final TransactionDto BALANCE_BANANA_NEGATIVE_INCORRECT =
            new TransactionDto(Operation.fromString("b"), new ShopItem("banana"), -10);
    public static BalanceStrategy balanceStrategy;

    @BeforeClass
    public static void initialize() {
        balanceStrategy = new BalanceStrategy();
    }

    @Test
    public void validData_Correct() {
        balanceStrategy.apply(BALANCE_BANANA_POSITIVE_CORRECT);
    }

    @Test(expected = RuntimeException.class)
    public void invalidOperation_ThrowsException() {
        new TransactionDto(Operation.fromString("F"), new ShopItem("banana"), 10);
    }

    @Test(expected = RuntimeException.class)
    public void invalidQuantity_ThrowsException() {
        balanceStrategy.apply(BALANCE_BANANA_NEGATIVE_INCORRECT);
    }
}
