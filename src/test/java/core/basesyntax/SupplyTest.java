package core.basesyntax;

import core.basesyntax.fruitservice.Transaction;
import core.basesyntax.operation.Operation;
import core.basesyntax.operation.Supply;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SupplyTest {
    private Map<String, Integer> fruitDao = new HashMap<>();
    private Map<String, Integer> expected = new HashMap<>();
    private Transaction transaction = new Transaction("s", "banana","245","2020-12-10");
    private Transaction transaction1 = new Transaction("s", "banana","300","2018-10-20");
    private Transaction transaction2 = new Transaction("s", "banana","350","2020-11-27");
    private static Operation supply;

    @BeforeClass
    public static void beforeClass() throws Exception {
        supply = new Supply();
    }

    @Test
    public void supplyTest() {
        expected.put("banana", 595);
        supply.operation(fruitDao, transaction);
        supply.operation(fruitDao, transaction1);
        supply.operation(fruitDao, transaction2);
        Assert.assertEquals(expected, fruitDao);
    }
}
