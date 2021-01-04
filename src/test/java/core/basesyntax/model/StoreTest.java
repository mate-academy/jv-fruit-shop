package core.basesyntax.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.impl.FruitStoreImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.io.File;
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
    void getStatistic_2items() {
        String fromFilePath = "src" + File.separator + "test1.csv";
        String toFilePath = "src" + File.separator + "result1.csv";
        store.getStatistic(fromFilePath, toFilePath);
        String actual = readFromFile(toFilePath).trim();
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,65" + System.lineSeparator()
                + "apple,1080";
        assertEquals(expected, actual);
    }

    @Test
    void getStatistic_3items() {
        String fromFilePath = "src" + File.separator + "test2.csv";
        String toFilePath = "src" + File.separator + "result2.csv";
        store.getStatistic(fromFilePath, toFilePath);
        String actual = readFromFile(toFilePath).trim();
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,145" + System.lineSeparator()
                + "apple,1080" + System.lineSeparator()
                + "lemon,20";
        assertEquals(expected, actual);
    }

    @Test
    void getStatistic_wrongOperator() {
        String fromFilePath = "src" + File.separator + "test3.csv";
        String toFilePath = "src" + File.separator + "result3.csv";
        assertThrows(RuntimeException.class, () -> {
            store.getStatistic(fromFilePath, toFilePath);
        });
    }

    @Test
    void getStatistic_negativeQuantity() {
        String fromFilePath = "src" + File.separator + "test4.csv";
        String toFilePath = "src" + File.separator + "result4.csv";
        assertThrows(RuntimeException.class, () -> {
            store.getStatistic(fromFilePath, toFilePath);
        });
    }

    @Test
    void getStatistic_invalidQuantity() {
        String fromFilePath = "src" + File.separator + "test5.csv";
        String toFilePath = "src" + File.separator + "result5.csv";
        assertThrows(RuntimeException.class, () -> {
            store.getStatistic(fromFilePath, toFilePath);
        });
    }

    @Test
    void getStatistic_balanceIsZero() {
        String fromFilePath = "src" + File.separator + "test6.csv";
        String toFilePath = "src" + File.separator + "result6.csv";
        store.getStatistic(fromFilePath, toFilePath);
        String actual = readFromFile(toFilePath).trim();
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,0";
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
