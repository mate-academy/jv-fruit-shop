package core.basesyntax.servise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.servise.impl.CsvParser;
import core.basesyntax.servise.impl.FilesReaderImpl;
import core.basesyntax.servise.impl.FruitServiceImpl;
import core.basesyntax.strategy.AdditionStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceTest {
    private static FruitService service;

    @BeforeClass
    public static void beforeClass() throws Exception {
        Map<Operation, OperationStrategy> operationMap = new HashMap<>();
        operationMap.put(Operation.BALANCE, new AdditionStrategy());
        operationMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationMap.put(Operation.PURCHASE, new ReductionStrategy());
        operationMap.put(Operation.RETURN, new AdditionStrategy());
        FileParser<TransactionDto> fileParser = new CsvParser();
        service = new FruitServiceImpl(operationMap);
        FilesReader filesReader = new FilesReaderImpl();
        List<String> list = filesReader.readData("src/main/resources/test-fruit.csv");
        List<TransactionDto> dtoList = fileParser.parseData(list);
        service.applyOperation(dtoList);
    }

    @AfterClass
    public static void afterClass() {
        Storage.fruits.clear();
    }

    @Test
    public void returnReport_Ok() {
        Map<Fruit, Integer> expect = new HashMap<>();
        expect.put(new Fruit("banana"), 152);
        expect.put(new Fruit("apple"), 90);
        assertEquals(expect, service.getFruitReport());
    }

    @Test
    public void returnReportIncorrectData_NotOk() {
        Map<Fruit, Integer> expect = new HashMap<>();
        expect.put(new Fruit("apple"), 15);
        expect.put(new Fruit("apple"), 90);
        assertNotEquals(expect, service.getFruitReport());
    }

    @Test
    public void returnReportEmptyMap_NotOk() {
        Map<Fruit, Integer> expect = new HashMap<>();
        assertNotEquals(expect, service.getFruitReport());
    }
}
