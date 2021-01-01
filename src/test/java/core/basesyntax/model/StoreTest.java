package core.basesyntax.model;

import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.operation.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    private static Store store;
    private static Map<String, OperationHandler> operationHandlerMap;
    private static  OperationStrategy operationStrategy;

    @BeforeAll
    static void setUp() {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
        operationHandlerMap.put("r", new ReturnOperationHandler());

        operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        store = new FruitStoreImpl(operationStrategy);
    }

    @Test
    void getStatistic() {
        String fromFilePath = "src\\test1.csv";
        String toFilePath = "src\\result1.csv";
        store.getStatistic(fromFilePath, toFilePath);
        String actual = readFromFile(toFilePath);
        String expected = "fruit,quantity" + System.lineSeparator() +
                "banana,145" + System.lineSeparator() +
                "apple,1080" + System.lineSeparator() +
                "lemon,20";
        assertEquals(expected, actual);
    }

    private String readFromFile(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file " + fileName, e);
        }
    }
}