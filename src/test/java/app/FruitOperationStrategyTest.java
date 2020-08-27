package app;

import app.service.Operation;
import app.service.impl.OperationBuy;
import app.service.impl.OperationReturn;
import app.service.impl.OperationSupply;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class    FruitOperationStrategyTest {
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static final String RETURN = "r";
    private static final String COLON = ":";
    private static FruitOperationStrategy fruitOperationStrategy;
    private static Map<String, Operation> mapForTest;

    @BeforeClass
    public static void start() {
        mapForTest = new HashMap<>();
        mapForTest.put(SUPPLY,new OperationSupply());
        mapForTest.put(BUY, new OperationBuy());
        mapForTest.put(RETURN, new OperationReturn());
        fruitOperationStrategy = new FruitOperationStrategy(mapForTest);
    }

    @Test
    public void choseCorrectOperationOk() {
       List<String> line = new ArrayList<>();
       line.add(RETURN);
       Operation operationReturn = fruitOperationStrategy.getOperation(line);
       line.set(line.indexOf(RETURN), SUPPLY);
       Operation operationSupply = fruitOperationStrategy.getOperation(line);
       line.set(line.indexOf(SUPPLY), BUY);
       Operation operationBuy = fruitOperationStrategy.getOperation(line);
       Assert.assertEquals(OperationSupply.class, operationSupply.getClass());
       Assert.assertEquals(OperationReturn.class, operationReturn.getClass());
       Assert.assertEquals(OperationBuy.class, operationBuy.getClass());
    }

    @Test
    public void choseOperationException() {
        List<String> line = new ArrayList<>();
        line.add(COLON);
        try {
            Operation operationSupply = fruitOperationStrategy.getOperation(line);
        } catch (RuntimeException e) {
            Assert.assertEquals("Cant find correct operation for type: " + line.get(0),
                    e.getMessage());
        }
    }
}