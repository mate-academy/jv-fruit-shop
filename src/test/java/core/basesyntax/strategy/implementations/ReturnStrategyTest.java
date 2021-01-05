package core.basesyntax.strategy.implementations;

import core.basesyntax.model.Operation;
import core.basesyntax.model.ShopItem;
import core.basesyntax.model.TransactionDto;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReturnStrategyTest {
    public static final TransactionDto RETURN_BANANA_POSITIVE_CORRECT =
            new TransactionDto(Operation.fromString("r"), new ShopItem("SAMURAI"), 1337);
    public static final TransactionDto RETURN_BANANA_NEGATIVE_INCORRECT =
            new TransactionDto(Operation.fromString("r"), new ShopItem("SAMURAI"), -1);
    public static ReturnStrategy returnStrategy;

    @BeforeClass
    public static void initialize() {
        returnStrategy = new ReturnStrategy();
    }

    @Test
    public void validData_Correct() {
        returnStrategy.apply(RETURN_BANANA_POSITIVE_CORRECT);
    }

    @Test(expected = RuntimeException.class)
    public void invalidOperation_ThrowsException() {
        new TransactionDto(Operation.fromString("Z"), new ShopItem("SAMURAI"), 10);
    }

    @Test(expected = RuntimeException.class)
    public void invalidQuantity_ThrowsException() {
        returnStrategy.apply(RETURN_BANANA_NEGATIVE_INCORRECT);
    }
}
