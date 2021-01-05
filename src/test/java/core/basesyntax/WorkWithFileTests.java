package core.basesyntax;

import core.basesyntax.model.Operations;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.impl.ReadFromCsvFileImpl;
import core.basesyntax.service.impl.WriteToCsvFileImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;

import java.util.*;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WorkWithFileTests {

    @Before
    public void setUp() throws Exception {
        Map<Operations, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(Operations.B, new BalanceHandler());
        operationMap.put(Operations.P, new PurchaseHandler());
        operationMap.put(Operations.R, new ReturnHandler());
        operationMap.put(Operations.S, new SupplyHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
    }

    @Test
    public void testReading_Ok() {
        FileReader reader = new ReadFromCsvFileImpl("src/test/resources/test1_correct.csv");
        List<String> actual = reader.read();
        Assert.assertEquals(Arrays.asList("b,banana,20", "b,apple,100", "s,banana,100",
                "p,banana,13", "r,apple,10", "p,apple,20", "p,banana,5", "s,banana,50"), actual);
    }

    @Test
    public void testReadingEmptyFile_Ok() {
        FileReader reader = new ReadFromCsvFileImpl("src/test/resources/test_emptyFile.csv");
        List<String> actual = reader.read();
        Assert.assertEquals(Collections.EMPTY_LIST, actual);
    }

    @Test
    public void testWritingToFile_Ok() {
        FileWriter writer = new WriteToCsvFileImpl();
        writer.writeToFile("Expected report", "expectedReport");
    }
}
