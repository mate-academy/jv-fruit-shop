package core.basesyntax.strategy;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.NegativeQuantityException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReductionStrategyImplTest {
    private static OperationStrategy reductionStrategy;
    private static final TransactionDto testDto1 = new TransactionDto(Operation.fromString("p"),
            new Fruit("banana"), 20);
    private static final TransactionDto testDto2 = new TransactionDto(Operation.fromString("p"),
            new Fruit("apple"), 100);
    private static final TransactionDto testDto3 = new TransactionDto(Operation.fromString("p"),
            new Fruit("banana"), 50);

    @BeforeClass
    public static void beforeClass() throws Exception {
        reductionStrategy = new ReductionStrategyImpl();
    }

    @Before
    public void setUp() throws Exception {
        Storage.getFruits().clear();
    }

    @Test
    public void apply_Ok() {
        Storage.getFruits().put("banana", 100);
        Storage.getFruits().put("apple", 300);
        reductionStrategy.apply(testDto1);
        reductionStrategy.apply(testDto2);
        reductionStrategy.apply(testDto3);
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("banana", 30);
        expectedMap.put("apple", 200);
        assertEquals(expectedMap, Storage.getFruits());
    }

    @Test(expected = NegativeQuantityException.class)
    public void reduceMoreThanExist_NotOk() {
        Storage.getFruits().put("banana", 20);
        reductionStrategy.apply(testDto3);
    }

    @Test(expected = NegativeQuantityException.class)
    public void reduceNonExistingGoods_NotOk() {
        reductionStrategy.apply(testDto3);
    }
}
