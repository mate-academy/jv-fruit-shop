import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class AllTests {
    private Storage storage;
    private DataConverterImpl dataConverter;
    private FileReaderImpl fileReader;
    private ShopServiceImpl shopService;

    @BeforeEach
    public void setUp() {
        storage = new Storage();
        dataConverter = new DataConverterImpl();
        fileReader = new FileReaderImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperation(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
                FruitTransaction.Operation.RETURN, new ReturnOperation()
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        shopService = new ShopServiceImpl(operationStrategy, storage);
    }

    // DataConverterImplTest
    @Test
    public void testConvertToTransaction() {
        List<String> data = Arrays.asList(
                "type,fruit,quantity",
                "b,banana,20",
                "s,apple,100",
                "p,banana,10"
        );

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(data);

        assertEquals(3, transactions.size());
        assertEquals(FruitTransaction.Operation.BALANCE, transactions.get(0).getOperation());
        assertEquals("banana", transactions.get(0).getFruit());
        assertEquals(20, transactions.get(0).getQuantity());
    }

    // FileReaderImplTest
    @Test
    public void testReadTransactionsFileNotFound() {
        try {
            List<FruitTransaction> transactions = fileReader.readTransactions("nonexistentfile.csv");
            fail("Expected IOException to be thrown");
        } catch (IOException e) {
            assertEquals("Error reading file: nonexistentfile.csv", e.getMessage());
        }
    }

    // OperationHandlersTest
    @Test
    public void testBalanceOperation() {
        FruitTransaction transaction = new FruitTransaction(FruitTransaction.Operation.BALANCE, "banana", 20);
        new BalanceOperation().handle(transaction, storage);
        assertEquals(20, storage.getFruitQuantities().get("banana"));
    }

    @Test
    public void testSupplyOperation() {
        FruitTransaction transaction = new FruitTransaction(FruitTransaction.Operation.SUPPLY, "apple", 100);
        new SupplyOperation().handle(transaction, storage);
        assertEquals(100, storage.getFruitQuantities().get("apple"));
    }

    @Test
    public void testPurchaseOperation() {
        storage.addFruit("banana", 50);
        FruitTransaction transaction = new FruitTransaction(FruitTransaction.Operation.PURCHASE, "banana", 10);
        new PurchaseOperation().handle(transaction, storage);
        assertEquals(40, storage.getFruitQuantities().get("banana"));
    }

    @Test
    public void testReturnOperation() {
        storage.addFruit("apple", 30);
        FruitTransaction transaction = new FruitTransaction(FruitTransaction.Operation.RETURN, "apple", 20);
        new ReturnOperation().handle(transaction, storage);
        assertEquals(50, storage.getFruitQuantities().get("apple"));
    }

    // ShopServiceImplTest
    @Test
    public void testProcessTransactions() {
        List<FruitTransaction> transactions = Arrays.asList(
                new FruitTransaction(FruitTransaction.Operation.BALANCE, "apple", 100),
                new FruitTransaction(FruitTransaction.Operation.SUPPLY, "banana", 50),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "apple", 20),
                new FruitTransaction(FruitTransaction.Operation.RETURN, "banana", 10)
        );

        shopService.process(transactions);

        assertEquals(80, storage.getFruitQuantities().get("apple"));
        assertEquals(60, storage.getFruitQuantities().get("banana"));
    }

    // StorageTest
    @Test
    public void testAddFruit() {
        storage.addFruit("apple", 10);
        assertEquals(10, storage.getFruitQuantities().get("apple"));
    }

    @Test
    public void testRemoveFruit() {
        storage.addFruit("apple", 10);
        storage.removeFruit("apple", 5);
        assertEquals(5, storage.getFruitQuantities().get("apple"));
    }

    @Test
    public void testRemoveFruitBeyondZero() {
        storage.addFruit("apple", 5);
        storage.removeFruit("apple", 10);
        assertEquals(-5, storage.getFruitQuantities().get("apple"));
    }
}
