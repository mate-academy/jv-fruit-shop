package core.basesyntax.service.impl.servicetest;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileReaderImplTest {
    private static final String PATH_TO_FILE = "src/test/resources/firstTestFileOk.csv";
    private static CsvFileReader reader;
    private static Map<Operation, OperationStrategy> operationStrategyMap;

    @BeforeClass
    public static void beforeAll() {
        operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new BalanceStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        operationStrategyMap.put(Operation.RETURN, new ReturnStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        reader = new CsvFileReaderImpl();
    }

    @Test
    public void testFirstFile_Ok() {
        List<TransactionDto> firstListTransaction = reader
                .readDate(PATH_TO_FILE);
        int expectedSize = 8;
        int actualSize = firstListTransaction.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testFirstFileCorrectParse_Ok() {
        TransactionDto expectedTransaction = new TransactionDto();
        expectedTransaction.setOperation(Operation.BALANCE);
        expectedTransaction.setFruit(new Fruit("banana"));
        expectedTransaction.setQuantity(20);
        List<TransactionDto> firstListTransaction = reader.readDate(PATH_TO_FILE);
        assertEquals(firstListTransaction.get(0), expectedTransaction);
    }

    @Test(expected = RuntimeException.class)
    public void testFirstFileIncorrectPath_NotOk() {
        List<TransactionDto> firstListTransaction = reader
                .readDate("src/test/resources/firstTestFileOk.cs");
    }
}
