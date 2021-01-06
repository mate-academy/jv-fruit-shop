package core.basesyntax.service;

import static org.junit.Assert.assertNotNull;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvParserImpl;
import core.basesyntax.service.impl.FruitServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.strategies.BalanceStrategy;
import core.basesyntax.strategy.strategies.PurchaseStrategy;
import core.basesyntax.strategy.strategies.ReturnStrategy;
import core.basesyntax.strategy.strategies.SupplyStrategy;
import org.junit.Before;
import org.junit.Test;

public class FruitServiceTest {
    private static final String FILE_FROM = "src/test/resources/shop_activity_test.csv";
    private static final String FILE_INVALID_OPERATION
            = "src/test/resources/shop_activity_test_invalid_operation.csv";
    private static Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
    private List<String> data;
    private FruitService service;

    @Before
    public void setUp() {
        operationStrategyMap.put(Operation.BALANCE, new BalanceStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        operationStrategyMap.put(Operation.RETURN, new ReturnStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        service = new FruitServiceImpl(operationStrategyMap);
    }

    @Test
    public void validFileData() {
        data = new CsvFileReaderImpl().readFromFile(FILE_FROM);
        List<TransactionDto> parsedData = new CsvParserImpl().parse(data);
        service.processActivities(parsedData);
        assertNotNull(Storage.storage);
    }

    @Test(expected = RuntimeException.class)
    public void invalidFileData_OperationType() {
        data = new CsvFileReaderImpl().readFromFile(FILE_INVALID_OPERATION);
        List<TransactionDto> parsedData = new CsvParserImpl().parse(data);
        service.processActivities(parsedData);
    }
}
