package core.basesyntax.strategy;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdditionStrategyImplTest {
    private static OperationStrategy additionStrategy;
    private static final TransactionDto TEST_DTO_1 = new TransactionDto(Operation.BALANCE,
            new Fruit("banana"), 20);
    private static final TransactionDto TEST_DTO_2 = new TransactionDto(Operation.SUPPLY,
            new Fruit("apple"), 100);
    private static final TransactionDto TEST_DTO_3 = new TransactionDto(Operation.RETURN,
            new Fruit("banana"), 50);

    @BeforeClass
    public static void beforeClass() {
        additionStrategy = new AdditionStrategyImpl();
    }

    @Before
    public void setUp() {
        Storage.getFruits().clear();
    }

    @Test
    public void applyNew_Ok() {
        additionStrategy.apply(TEST_DTO_1);
        additionStrategy.apply(TEST_DTO_2);
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("banana", 20);
        expectedMap.put("apple", 100);
        assertEquals(expectedMap, Storage.getFruits());
    }

    @Test
    public void applyExisted_Ok() {
        additionStrategy.apply(TEST_DTO_1);
        additionStrategy.apply(TEST_DTO_3);
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("banana", 70);
        assertEquals(expectedMap, Storage.getFruits());
    }
}
