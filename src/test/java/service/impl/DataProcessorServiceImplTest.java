package service.impl;

import db.Storage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import operations.OperationHandler;
import operations.impl.BalanceOperationHandler;
import operations.impl.PurchaseOperationHandler;
import operations.impl.ReturnOperationHandler;
import operations.impl.SupplyOperationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.DataProcessorService;
import service.OperationStrategy;
import service.TransactionDataParse;

class DataProcessorServiceImplTest {
    private DataProcessorService dataProcessorService;
    private TransactionDataParse transactionDataParse;

    @BeforeEach
    void setUp() {
        Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap =
                new HashMap<>();
        operationOperationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        OperationStrategy operationStrategy =
                new OperationStrategyImpl(operationOperationHandlerMap);

        Storage storage = new Storage();
        dataProcessorService = new DataProcessorServiceImpl(storage,operationStrategy);
        transactionDataParse = new TransactionDataParseImpl();

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
        Assertions.assertDoesNotThrow(() -> dataProcessorService.process(inputLines));
    }

    @Test
    void parseTransactionValidInput() {
        String line = "s,apple,1";
        FruitTransaction.Operation supply = FruitTransaction.Operation.SUPPLY;

        FruitTransaction expected = new FruitTransaction(supply,"apple",1);
        FruitTransaction actual = transactionDataParse.parseTransaction(line);

        Assertions.assertEquals(expected.getOperation(), actual.getOperation());
        Assertions.assertEquals(expected.getQuantity(),actual.getQuantity());
        Assertions.assertEquals(expected.getFruitName(), actual.getFruitName());
    }

    @Test
    void parseTransactionLessThenZero() {
        String line = "s,apple,-1";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> transactionDataParse.parseTransaction(line));
    }

    @Test
    void parseTransactionInvalidInput() {
        String line = "fafse";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> transactionDataParse.parseTransaction(line));
    }
}
