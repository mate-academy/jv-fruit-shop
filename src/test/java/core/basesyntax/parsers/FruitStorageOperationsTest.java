package core.basesyntax.parsers;

import core.basesyntax.exceptions.WrongDateException;
import core.basesyntax.exceptions.WrongTypeException;
import core.basesyntax.services.BalanceSheet;
import core.basesyntax.services.Buy;
import core.basesyntax.services.Supply;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStorageOperationsTest {

    public final static String PATH = "example.csv";

    @Test(expected = RuntimeException.class)
    public void testWrongPath() {
        List<String[]> dataFromTable = new ParseFromFile().parseFromFile("path.csv");
    }

    @Test(expected = WrongDateException.class)
    public void testWrongDate() {
        boolean actual = new Supply().updateTransactionTable("example.csv", "orange",
                12, LocalDate.of(2006,11,23));
    }

    @Test(expected = WrongTypeException.class)
    public void testWrongType() {
        boolean actual = new Buy().updateTransactionTable("example.csv", "lemon",
                12, LocalDate.of(2021,11,23));
    }

    @Test
    public void testBalanceSheet() {
        Map<String, Integer> actual = new BalanceSheet().getBalanceMap("balanceTest.csv");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("orange",67);
        expected.put("banana",60);
        expected.put("apple",22);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testSupply() {
        boolean actual = new Supply().updateTransactionTable("example.csv", "orange", 12, LocalDate.of(2021,11,23));
        boolean expected = true;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testBuy() {
        boolean actual = new Buy().updateTransactionTable("example.csv", "orange",
                12, LocalDate.of(2021,11,23));
        boolean expected = true;
        Assert.assertEquals(expected,actual);
    }
}

