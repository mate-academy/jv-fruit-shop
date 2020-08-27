package core.basesyntax;

import core.basesyntax.fruitservice.Transaction;
import core.basesyntax.operation.Buy;
import core.basesyntax.operation.Operation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BuyTest {
    private Map<String, Integer> fruitDao = new HashMap<>();
    private Map<String, Integer> expected = new HashMap<>();
    private Transaction transaction = Transaction.build("b", "banana","130","2010-11-18");
    private Transaction transaction1 = Transaction.build("b", "banana","147","2020-12-25");
    private Transaction transaction2 = Transaction.build("b", "banana","213","2020-11-21");
    private static Operation buy;

    @BeforeClass
    public static void beforeClass() throws Exception {
        buy = new Buy();
    }

    @Test
    public void supplyTest() {
        fruitDao.put("banana", 555);
        expected.put("banana", 195);
        buy.operation(fruitDao, transaction);
        buy.operation(fruitDao, transaction1);
        buy.operation(fruitDao, transaction2);
        Assert.assertEquals(expected, fruitDao);
    }
}