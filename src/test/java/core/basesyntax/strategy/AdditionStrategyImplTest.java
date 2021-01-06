package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdditionStrategyImplTest {
    public static AdditionStrategyImpl additionalStrategy;
    public static TransactionDto transactionDto;
    public static Storage myStorage;

    @Before
    public void setUp() throws Exception {
        additionalStrategy = new AdditionStrategyImpl();
        transactionDto = new TransactionDto(Operation.BALANCE, new Fruit("lemon"), 10);
        myStorage.fruitStorage = new HashMap<>();
    }

    @Test
    public void typicalTest_ok() {
        additionalStrategy.operate(transactionDto);
        Integer actual = myStorage.fruitStorage.get(new Fruit("lemon"));
        Integer expected = Integer.valueOf(10);
        Assert.assertEquals(actual, expected);
    }
}
