package core.basesyntax.maketransaction.operations;

import core.basesyntax.identities.Storage;
import core.basesyntax.maketransaction.Transaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SupplyTest {

    private Supply testSupply;
    private Storage storage;

    @Before
    public void setUp() throws Exception {
        testSupply = new Supply();
        storage = new Storage();
    }

    @Test
    public void supply_Ok() {
        assertTrue(testSupply.apply(new Transaction("s", "banana", 10, "2020-10-15"), storage));
    }

    @Test
    public void supplyv_AmountOfFruits_Ok() {
        testSupply.apply(new Transaction("s", "banana", 10, "2020-10-15"), storage);

        int actual = storage.getFruits().get("banana").size();

        assertEquals(10, actual);
    }
}