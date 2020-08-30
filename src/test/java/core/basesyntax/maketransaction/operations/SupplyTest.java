package core.basesyntax.maketransaction.operations;

import core.basesyntax.identities.Storage;
import core.basesyntax.maketransaction.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SupplyTest {

    private Supply testSupply;

    @Before
    public void setUp() throws Exception {
        testSupply = new Supply();
    }

    @After
    public void tearDown() throws Exception {
        Storage.clear();
    }

    @Test
    public void supply_Ok() {
        assertTrue(testSupply.apply(new Transaction("s", "banana", 10, "2020-10-15")));
    }

    @Test
    public void supplyv_AmountOfFruits_Ok() {
        testSupply.apply(new Transaction("s", "banana", 10, "2020-10-15"));

        int actual = Storage.getFruits().get("banana").size();

        assertEquals(10, actual);
    }
}