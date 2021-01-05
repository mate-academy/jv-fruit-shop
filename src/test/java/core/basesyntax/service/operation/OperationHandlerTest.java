package core.basesyntax.service.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OperationHandlerTest {
    private static Map<String, OperationHandler> operationHandlerMap;
    private static final String OPERATION_RETURN = "r";
    private static final String OPERATION_SUPPLY = "s";
    private static final String OPERATION_PURCHASE = "p";
    private static final String OPERATION_BALANCE = "b";
    private static final Integer BALANCE = 100;
    private static final Integer VALID_VALUE = 10;
    private static final Integer INVALID_VALUE = -10;
    private static final Integer BALANCE_SMALLER_VALUE = 200;

    @BeforeAll
     public static void setUp() {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
        operationHandlerMap.put("r", new ReturnOperationHandler());
    }

    @Test
    public void updateBalanceReturn() {
        Integer expected = 110;
        Integer actual = operationHandlerMap.get(OPERATION_RETURN)
                .updateBalance(BALANCE, VALID_VALUE);

        assertEquals(expected, actual);

        assertThrows(RuntimeException.class, () -> {
            operationHandlerMap.get(OPERATION_RETURN).updateBalance(BALANCE, INVALID_VALUE);
        });

        expected = 300;
        actual = operationHandlerMap.get(OPERATION_RETURN)
                .updateBalance(BALANCE, BALANCE_SMALLER_VALUE);

        assertEquals(expected, actual);

    }

    @Test
    public void updateBalanceSupply() {
        Integer expected = 110;
        Integer actual = operationHandlerMap.get(OPERATION_SUPPLY)
                .updateBalance(BALANCE, VALID_VALUE);

        assertEquals(expected, actual);

        assertThrows(RuntimeException.class, () -> {
            operationHandlerMap.get(OPERATION_SUPPLY).updateBalance(BALANCE, INVALID_VALUE);
        });

        expected = 300;
        actual = operationHandlerMap.get(OPERATION_SUPPLY)
                .updateBalance(BALANCE, BALANCE_SMALLER_VALUE);

        assertEquals(expected, actual);

    }

    @Test
    public void updateBalancePurchase() {
        Integer expected = 90;
        Integer actual = operationHandlerMap.get(OPERATION_PURCHASE)
                .updateBalance(BALANCE, VALID_VALUE);

        assertEquals(expected, actual);

        assertThrows(RuntimeException.class, () -> {
            operationHandlerMap.get(OPERATION_PURCHASE).updateBalance(BALANCE, INVALID_VALUE);
        });

        assertThrows(RuntimeException.class, () -> {
            operationHandlerMap.get(OPERATION_PURCHASE).updateBalance(BALANCE,
                    BALANCE_SMALLER_VALUE);
        });
    }

    @Test
    public void updateBalanceBalance() {
        Integer expected = 10;
        Integer actual = operationHandlerMap.get(OPERATION_BALANCE)
                .updateBalance(BALANCE, VALID_VALUE);

        assertEquals(expected, actual);

        assertThrows(RuntimeException.class, () -> {
            operationHandlerMap.get(OPERATION_BALANCE).updateBalance(BALANCE, INVALID_VALUE);
        });

        expected = 200;
        actual = operationHandlerMap.get(OPERATION_BALANCE)
                .updateBalance(BALANCE, BALANCE_SMALLER_VALUE);

        assertEquals(expected, actual);

    }
}
