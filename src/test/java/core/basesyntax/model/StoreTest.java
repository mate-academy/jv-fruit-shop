package core.basesyntax.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StoreTest {
    private static Store store;
    private static Map<String, OperationHandler> operationHandlerMap;
    private static OperationStrategy operationStrategy;

    @BeforeAll
    public static void setUp() {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
        operationHandlerMap.put("r", new ReturnOperationHandler());

        operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        store = new Store(operationStrategy);
    }

    @Test
    public void getStatistic_2items() {
        String fromFilePath = "test1.csv";
        String toFilePath = "result1.csv";
        store.showStatistic(fromFilePath, toFilePath);
        String actual = readFromFile(toFilePath).trim();
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,65" + System.lineSeparator()
                + "apple,1080";
        assertEquals(expected, actual);
    }

    @Test
    public void getStatistic_3items() {
        String fromFilePath = "test2.csv";
        String toFilePath = "result2.csv";
        store.showStatistic(fromFilePath, toFilePath);
        String actual = readFromFile(toFilePath).trim();
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,145" + System.lineSeparator()
                + "apple,1080" + System.lineSeparator()
                + "lemon,20";
        assertEquals(expected, actual);
    }

    @Test
    public void getStatistic_wrongOperator() {
        String fromFilePath = "test3.csv";
        String toFilePath = "result3.csv";
        assertThrows(RuntimeException.class, () -> {
            store.showStatistic(fromFilePath, toFilePath);
        });
    }

    @Test
    public void getStatistic_negativeQuantity() {
        String fromFilePath = "test4.csv";
        String toFilePath = "result4.csv";
        assertThrows(RuntimeException.class, () -> {
            store.showStatistic(fromFilePath, toFilePath);
        });
    }

    @Test
    public void getStatistic_invalidQuantity() {
        String fromFilePath = "test5.csv";
        String toFilePath = "result5.csv";
        assertThrows(RuntimeException.class, () -> {
            store.showStatistic(fromFilePath, toFilePath);
        });
    }

    private String readFromFile(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file " + fileName, e);
        }
    }
}
