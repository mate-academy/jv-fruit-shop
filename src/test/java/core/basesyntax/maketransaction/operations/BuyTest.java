package core.basesyntax.maketransaction.operations;

import core.basesyntax.identities.Fruit;
import core.basesyntax.identities.Storage;
import core.basesyntax.maketransaction.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class BuyTest {

    private Buy testBuy;

    @Before
    public void setUp() throws Exception {
        testBuy = new Buy();
    }

    @After
    public void tearDown() throws Exception {
        Storage.clear();
    }

    @Test
    public void apply_Ok() {
        Storage.addFruit(new Fruit("banana", LocalDate.parse("2020-10-15")));
        Storage.addFruit(new Fruit("banana", LocalDate.parse("2020-10-15")));
        assertTrue(testBuy.apply(new Transaction("s", "banana", 2, "2020-10-15")));
    }

    @Test(expected = NoSuchElementException.class)
    public void apply_NoSuchElementException_Not_Enough_Fruits() {
        Storage.addFruit(new Fruit("banana", LocalDate.parse("2020-10-15")));
        testBuy.apply(new Transaction("s", "banana", 10, "2020-10-15"));
    }

    @Test(expected = NoSuchElementException.class)
    public void apply_NoSuchElementException() {
        testBuy.apply(new Transaction("s", "banana", 10, "2020-10-15"));
    }
}