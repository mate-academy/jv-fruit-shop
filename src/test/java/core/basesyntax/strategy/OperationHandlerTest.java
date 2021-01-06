package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OperationHandlerTest {
    private static Map<String, OperationHandler> operationHandlerMap;
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String BALANCE = "b";

    @BeforeAll
    static void setUp() {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
        operationHandlerMap.put("r", new ReturnOperationHandler());
    }

    @Test
    void check_Return_ok() {
        Integer expected = 70;
        Integer actual = operationHandlerMap.get(RETURN)
                .updateBalance(50, 20);

        assertEquals(expected, actual);

        assertThrows(RuntimeException.class, () -> operationHandlerMap
                .get(RETURN).updateBalance(50, -2));

        expected = 150;
        actual = operationHandlerMap.get(RETURN)
                .updateBalance(50, 100);

        assertEquals(expected, actual);

    }

    @Test
    void check_Supply_ok() {
        Integer expected = 70;
        Integer actual = operationHandlerMap.get(SUPPLY)
                .updateBalance(50, 20);

        assertEquals(expected, actual);

        assertThrows(RuntimeException.class, () -> operationHandlerMap
                .get(SUPPLY).updateBalance(50, -1));

        expected = 150;
        actual = operationHandlerMap.get(SUPPLY)
                .updateBalance(50, 100);

        assertEquals(expected, actual);

    }

    @Test
    void check_Purchase_ok() {
        Integer expected = 30;
        Integer actual = operationHandlerMap.get(PURCHASE)
                .updateBalance(50, 20);

        assertEquals(expected, actual);

        assertThrows(RuntimeException.class, () -> operationHandlerMap
                .get(PURCHASE).updateBalance(50, -1));

        assertThrows(RuntimeException.class, () -> operationHandlerMap
                .get(PURCHASE).updateBalance(50, 100));
    }

    @Test
    void check_Balance_ok() {
        Integer expected = 70;
        Integer actual = operationHandlerMap.get(BALANCE)
                .updateBalance(50, 20);

        assertEquals(expected, actual);

        assertThrows(RuntimeException.class, () -> operationHandlerMap
                .get(BALANCE).updateBalance(50, -2));

        expected = 150;
        actual = operationHandlerMap.get(BALANCE)
                .updateBalance(50, 100);

        assertEquals(expected, actual);

    }
}
