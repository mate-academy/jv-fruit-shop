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
    private Transaction transaction3 = Transaction.build("b", "mango","100","2010-11-21");
    private Transaction transaction4 = Transaction.build("b", "mango","50","2020-11-21");
    private Transaction transaction5 = Transaction.build("b", "mango","60","2020-11-21");
    private Transaction transaction6 = Transaction.build("b", "orange","200","2019-11-21");
    private Transaction transaction7 = Transaction.build("b", "orange","40","2020-11-21");
    private Transaction transaction8 = Transaction.build("b", "orange","80","2020-11-21");
    private static Operation buy;

    @BeforeClass
    public static void beforeClass() throws Exception {
        buy = new Buy();
    }

    @Test
    public void buyTest() {
        fruitDao.put("banana", 555);
        fruitDao.put("mango", 410);
        fruitDao.put("orange", 200);
        expected.put("banana", 195);
        expected.put("mango", 300);
        expected.put("orange", 80);
        buy.operation(fruitDao, transaction);
        buy.operation(fruitDao, transaction1);
        buy.operation(fruitDao, transaction2);
        buy.operation(fruitDao, transaction3);
        buy.operation(fruitDao, transaction4);
        buy.operation(fruitDao, transaction5);
        buy.operation(fruitDao, transaction6);
        buy.operation(fruitDao, transaction7);
        buy.operation(fruitDao, transaction8);
        Assert.assertEquals(expected, fruitDao);
    }
}
