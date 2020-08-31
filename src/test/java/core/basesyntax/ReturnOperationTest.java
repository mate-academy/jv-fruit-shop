package core.basesyntax;

import core.basesyntax.fruitservice.Transaction;
import core.basesyntax.operation.Operation;
import core.basesyntax.operation.ReturnOperation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ReturnOperationTest {
    private Map<String, Integer> fruitDao = new HashMap<>();
    private Map<String, Integer> expected = new HashMap<>();
    private Transaction transaction = new Transaction("b", "banana", "200", "2010-11-20");
    private Transaction transaction1 = new Transaction("b", "banana", "150", "2020-12-23");
    private Transaction transaction2 = new Transaction("b", "banana", "365", "2020-10-15");
    private static Operation returnTest;

    @BeforeClass
    public static void beforeClass() throws Exception {
        returnTest = new ReturnOperation();
    }

    @Test
    public void returnTest() {
        fruitDao.put("banana", 355);
        expected.put("banana", 870);
        returnTest.operation(fruitDao, transaction);
        returnTest.operation(fruitDao, transaction1);
        returnTest.operation(fruitDao, transaction2);
        Assert.assertEquals(expected, fruitDao);
    }
}
