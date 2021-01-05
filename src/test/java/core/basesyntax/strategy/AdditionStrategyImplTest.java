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
    private static final TransactionDto testDto1 = new TransactionDto(Operation.fromString("b"),
            new Fruit("banana"), 20);
    private static final TransactionDto testDto2 = new TransactionDto(Operation.fromString("s"),
            new Fruit("apple"), 100);
    private static final TransactionDto testDto3 = new TransactionDto(Operation.fromString("r"),
            new Fruit("banana"), 50);

    @BeforeClass
    public static void beforeClass() throws Exception {
        additionStrategy = new AdditionStrategyImpl();
    }

    @Before
    public void setUp() throws Exception {
        Storage.getFruits().clear();
    }

    @Test
    public void applyNew_Ok() {
        additionStrategy.apply(testDto1);
        additionStrategy.apply(testDto2);
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("banana", 20);
        expectedMap.put("apple", 100);
        assertEquals(expectedMap, Storage.getFruits());
    }

    @Test
    public void applyExisted_Ok() {
        additionStrategy.apply(testDto1);
        additionStrategy.apply(testDto3);
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("banana", 70);
        assertEquals(expectedMap, Storage.getFruits());
    }
}
