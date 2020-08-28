package core.basesyntax.maketransaction.operations;

import core.basesyntax.identities.Storage;
import core.basesyntax.maketransaction.Transaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReturnTest {

    private Return testReturn;
    private Storage storage;

    @Before
    public void setUp() throws Exception {
        testReturn = new Return();
        storage = new Storage();
    }

    @Test
    public void return_Ok() {
        assertTrue(testReturn.apply(new Transaction("s", "banana", 10, "2020-10-15"), storage));
    }

    @Test
    public void return_AmountOfFruits_Ok() {
        testReturn.apply(new Transaction("s", "banana", 10, "2020-10-15"), storage);

        int actual = storage.getFruits().get("banana").size();

        assertEquals(10, actual);
    }
}