package core.basesyntax.maketransaction.operations;

import core.basesyntax.identities.Storage;
import core.basesyntax.maketransaction.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReturnTest {

    private Return testReturn;

    @Before
    public void setUp() throws Exception {
        testReturn = new Return();
    }

    @After
    public void tearDown() throws Exception {
        Storage.clear();
    }

    @Test
    public void return_Ok() {
        assertTrue(testReturn.apply(new Transaction("s", "banana", 10, "2020-10-15")));
    }

    @Test
    public void return_AmountOfFruits_Ok() {
        testReturn.apply(new Transaction("s", "banana", 10, "2020-10-15"));

        int actual = Storage.getFruits().get("banana").size();

        assertEquals(10, actual);
    }
}