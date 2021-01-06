package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReductionStrategyImplTest {
    public static AdditionStrategyImpl additionalStrategy;
    public static ReductionStrategyImpl reductionStrategyImpl;
    public static TransactionDto transactionDtoFirst;
    public static TransactionDto transactionDtoSecond;
    public static Storage myStorage;

    @Before
    public void setUp() {
        reductionStrategyImpl = new ReductionStrategyImpl();
        additionalStrategy = new AdditionStrategyImpl();
        transactionDtoFirst = new TransactionDto(Operation.BALANCE, new Fruit("lemon"), 10);
        transactionDtoSecond = new TransactionDto(Operation.PURCHASE, new Fruit("lemon"), 5);
        myStorage.fruitStorage = new HashMap<>();
    }

    @Test
    public void typicalTest_ok() {
        additionalStrategy.operate(transactionDtoFirst);
        reductionStrategyImpl.operate(transactionDtoSecond);
        Integer actual = myStorage.fruitStorage.get(new Fruit("lemon"));
        Integer expected = Integer.valueOf(5);
        Assert.assertEquals(actual, expected);
    }
}
