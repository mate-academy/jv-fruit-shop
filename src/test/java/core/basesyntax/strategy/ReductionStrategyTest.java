package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Record;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReductionStrategyTest {
    static OperationStrategy additionStrategy;
    static OperationStrategy reductionStrategy;
    static Record firstTestRecord;
    static Record secondTestRecord;

    @BeforeAll
    static void beforeAll() {
        additionStrategy = new AdditionStrategy();
        reductionStrategy = new ReductionStrategy();
        firstTestRecord = new Record(Operation.BALANCE, new Fruit("banana"), 98L);
        secondTestRecord = new Record(Operation.SUPPLY, new Fruit("banana"), 2L);
    }

    @BeforeEach
    void setUp() {
        Storage.getStorage().clear();
    }

    @Test
    void reduction_OK() {
        long expected = 96;

        additionStrategy.apply(firstTestRecord);
        reductionStrategy.apply(secondTestRecord);
        long actual = Storage.getStorage().get(firstTestRecord.getFruit());

        assertEquals(expected, actual);
    }

    @Test
    void reductionMoreThanWeHave_NotOk() {
        Class<? extends IllegalArgumentException> expected = IllegalArgumentException.class;
        additionStrategy.apply(secondTestRecord);
        assertThrows(expected, () -> reductionStrategy.apply(firstTestRecord));
    }

    @Test
    void reductionNoExistElement_NotOk() {
        assertThrows(NoSuchElementException.class, () -> reductionStrategy.apply(firstTestRecord));
    }
}
