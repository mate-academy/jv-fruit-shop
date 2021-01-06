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
    private static final TransactionDto TEST_DTO_1 = new TransactionDto(Operation.fromString("p"),
            new Fruit("banana"), 20);
    private static final TransactionDto TEST_DTO_2 = new TransactionDto(Operation.fromString("p"),
            new Fruit("apple"), 100);
    private static final TransactionDto TEST_DTO_3 = new TransactionDto(Operation.fromString("p"),
            new Fruit("banana"), 50);

    @BeforeClass
    public static void beforeClass() {
        reductionStrategy = new ReductionStrategyImpl();
    }

    @Before
    public void setUp() {
        Storage.getFruits().clear();
    }

    @Test
    public void apply_Ok() {
        Storage.getFruits().put("banana", 100);
        Storage.getFruits().put("apple", 300);
        reductionStrategy.apply(TEST_DTO_1);
        reductionStrategy.apply(TEST_DTO_2);
        reductionStrategy.apply(TEST_DTO_3);
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("banana", 30);
        expectedMap.put("apple", 200);
        assertEquals(expectedMap, Storage.getFruits());
    }

    @Test(expected = NegativeQuantityException.class)
    public void reduceMoreThanExist_NotOk() {
        Storage.getFruits().put("banana", 20);
        reductionStrategy.apply(TEST_DTO_3);
    }

    @Test(expected = NegativeQuantityException.class)
    public void reduceNonExistingGoods_NotOk() {
        reductionStrategy.apply(TEST_DTO_3);
    }
}
