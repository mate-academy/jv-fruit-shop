package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.exception.NoSuchOperationException;
import core.basesyntax.service.strategy.OperationResolver;
import core.basesyntax.service.strategy.impl.OperationResolverImpl;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationResolverImplTest {
    private static OperationResolver operationResolver;
    private static Map<String, Operation> operationMap = new HashMap<>();

    @BeforeAll
    static void beforeAll() {
        operationMap = new HashMap<>();
        operationResolver = new OperationResolverImpl(operationMap);
    }

    @BeforeEach
    void setUp() {

        operationMap.put("b", Operation.BALANCE);
        operationMap.put("s", Operation.SUPPLY);
        operationMap.put("p", Operation.PURCHASE);
        operationMap.put("r", Operation.RETURN);
    }

    @Test
    void getOperation_receiveOperation_Ok() {
        String str = "b";
        Operation operation = operationResolver.getOperation(str);
        Assertions.assertEquals(Operation.BALANCE, operation);

    }

    @Test
    void getOperation_receiveOperation_NotOk() {
        String str = "bb";
        Assertions.assertThrows(NoSuchOperationException.class,
                () -> operationResolver.getOperation(str));
    }
}
