package core.basesyntax;

import core.basesyntax.fruitservice.Transaction;
import core.basesyntax.operationstrategy.OperationStrategy;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationStrategyTest {
    private Map<String, Integer> fruitDao = new HashMap<>();
    private Map<String, Integer> expected = new HashMap<>();
    private static OperationStrategy operationStrategy;

    @BeforeClass
    public static void beforeClass() throws Exception {
        operationStrategy = new OperationStrategy();
    }

    @Test
    public void supplyTest() {
        List<Transaction> input = new ArrayList<>();
        input.add(Transaction.build("s", "banana","200","2020-11-20"));
        input.add(Transaction.build("b", "banana","30","2020-10-19"));
        input.add(Transaction.build("r", "banana","7","2020-11-20"));
        input.add(Transaction.build("s", "mango","65","2020-11-17"));
        input.add(Transaction.build("b", "mango","25","2020-10-19"));
        input.add(Transaction.build("r", "banana","10","2020-11-20"));
        input.add(Transaction.build("s", "orange","40","2020-11-17"));
        input.add(Transaction.build("b", "orange","20","2020-10-19"));
        input.add(Transaction.build("r", "orange","7","2020-11-20"));
        expected.put("banana", 187);
        expected.put("mango", 40);
        expected.put("orange", 27);
        operationStrategy.operation(fruitDao, input);
        Assert.assertEquals(expected, fruitDao);
    }
}
