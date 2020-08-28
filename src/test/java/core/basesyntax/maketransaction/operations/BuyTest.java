package core.basesyntax.maketransaction.operations;

import core.basesyntax.identities.Fruit;
import core.basesyntax.identities.Storage;
import core.basesyntax.maketransaction.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class BuyTest {

    private Buy testBuy;
    private Storage storage;

    @Before
    public void setUp() throws Exception {
        testBuy = new Buy();
        storage = new Storage();
    }

    @Test
    public void apply_Ok() {
        storage.addFruit(new Fruit("banana", LocalDate.parse("2020-10-15")));
        storage.addFruit(new Fruit("banana", LocalDate.parse("2020-10-15")));
        assertTrue(testBuy.apply(new Transaction("s", "banana", 2, "2020-10-15"), storage));
    }

    @Test(expected = NoSuchElementException.class)
    public void apply_NoSuchElementException_Not_Enough_Fruits() {
        storage.addFruit(new Fruit("banana", LocalDate.parse("2020-10-15")));
        testBuy.apply(new Transaction("s", "banana", 10, "2020-10-15"), storage);
    }

    @Test(expected = NoSuchElementException.class)
    public void apply_NoSuchElementException() {
        testBuy.apply(new Transaction("s", "banana", 10, "2020-10-15"), storage);
    }
}