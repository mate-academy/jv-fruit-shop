package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Record;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdditionStrategyTest {
    static OperationStrategy additionStrategy;
    static long expected;
    static long actual;
    static Record firstTestRecord;
    static Record secondTestRecord;

    @BeforeAll
    static void beforeAll() {
        additionStrategy = new AdditionStrategy();
        firstTestRecord = new Record(Operation.BALANCE, new Fruit("banana"), 98L);
        secondTestRecord = new Record(Operation.SUPPLY, new Fruit("banana"), 2L);
    }

    @BeforeEach
    void setUp() {
        Storage.getStorage().clear();
    }

    @Test
    void applyNewObj_Ok() {
        expected = 98;

        additionStrategy.apply(firstTestRecord);
        actual = Storage.getStorage().get(firstTestRecord.getFruit());

        assertEquals(expected, actual);
    }

    @Test
    void applySameObj_Ok() {
        expected = 100;

        additionStrategy.apply(firstTestRecord);
        additionStrategy.apply(secondTestRecord);
        actual = Storage.getStorage().get(firstTestRecord.getFruit());

        assertEquals(expected, actual);
    }
}
