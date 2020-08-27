package app.service.impl;

import app.FruitOperationStrategy;
import app.service.FileReadService;
import app.service.Operation;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationBuyTest {
    private static Map<String, Operation> fruitOperations;
    public static final String FIRST_FILE = "src\\test\\resources\\testCantBuy.csv";
    public static final String SECOND_FILE = "src\\test\\resources\\testCantBuy2.csv";
    private static FruitOperationStrategy fruitOperationStrategy;
    private static FileReadService fileReadService;

    @BeforeClass
    public static void start() {
        fruitOperations = new HashMap<>();
        fruitOperations.put("s",new OperationSupply());
        fruitOperations.put("b", new OperationBuy());
        fruitOperations.put("r", new OperationReturn());
        fruitOperationStrategy = new FruitOperationStrategy(fruitOperations);
        fileReadService = new FileReadServiceImplements();
    }

    @Test(expected = RuntimeException.class)
    public void expiredFruits() {
        List<List<String>> allData = fileReadService.readFile(FIRST_FILE);
        for (List<String> line : allData) {
            Operation operation = fruitOperationStrategy.getOperation(line);
            operation.doOperation(line);
        }
    }

    @Test(expected = RuntimeException.class)
    public void notEnoughGoods() {
        List<List<String>> allData = fileReadService.readFile(SECOND_FILE);
        for (List<String> line : allData) {
            Operation operation = fruitOperationStrategy.getOperation(line);
            operation.doOperation(line);
        }
    }
}