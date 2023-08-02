package service.impl;

import db.*;
import model.*;
import operations.*;
import operations.impl.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import service.*;

import java.util.*;

class DataProcessorServiceImplTest {
    private DataProcesorService dataProcesorService;
    @BeforeEach
    void setUp() {
        Storage storage = new Storage();
        Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap = new HashMap<>();

        operationOperationHandlerMap.put(FruitTransaction.Operation.BALANCE,new BalanceOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.PURCHASE,new PurchaseOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.RETURN,new ReturnOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.SUPPLY,new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationOperationHandlerMap);

        dataProcesorService = new DataProcessorServiceImpl(storage,operationStrategy);
    }

    @Test
    void process() {
        List<String> inputLines = Arrays.asList(
            "s,orange,4000",
            "s,banana,4000",
            "b,banana,400",
            "s,apple,5000",
            "s,banana,100",
            "p,banana,13",
            "r,apple,10",
            "p,apple,20",
            "s,banana,50",
            "p,banana,5"
        );
        Assertions.assertDoesNotThrow(()->dataProcesorService.process(inputLines));
    }

    @Test
    void parseTransactionValidInput() {
        String line = "s,apple,1";
        FruitTransaction.Operation supply = FruitTransaction.Operation.SUPPLY;

        FruitTransaction expected = new FruitTransaction(supply,"apple",1);
        FruitTransaction actual = dataProcesorService.parseTransaction(line);

        Assertions.assertTrue(expected.getOperation().equals(actual.getOperation()));
        Assertions.assertEquals(expected.getQuantity(),actual.getQuantity());
        Assertions.assertTrue(expected.getFruitName().equals(actual.getFruitName()));
    }
    @Test
    void parseTransactionInvalidInput() {
        String line = "fafse";
        FruitTransaction.Operation supply = FruitTransaction.Operation.SUPPLY;

        Assertions.assertThrows(IllegalArgumentException.class,()->dataProcesorService.parseTransaction(line));
    }
}