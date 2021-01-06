
package core.basesyntax.service.work.with.file;

import static org.junit.Assert.assertEquals;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operation.Operation;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.OperationStrategyImpl;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReportImplTest {
    private static Report report;
    private static String expected;
    private static String fileName;
    private static ReadInformationFromFile readInformationFromFile;
    private static Map<Operation.Type, OperationHandler> operationHandlerMap;
    private static OperationStrategy operationStrategy;
    private static ShopService shopService;

    @BeforeClass
    public static void beforeClass() throws Exception {
        report = new ReportImpl();
        readInformationFromFile = new ReadInformationFromFileImpl();
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.Type.B, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.Type.R, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.Type.P, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.Type.S, new SupplyOperationHandler());
        operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        shopService = new ShopServiceImpl(new FruitDaoImpl(), operationStrategy);
    }

    @After
    public void tearDown() throws Exception {
        Storage.fruits.clear();
    }

    @Test
    public void inputData_Ok() {
        fileName = "database.csv";
        expected = "fruit,quantity" + System.lineSeparator()
                + "banana,152" + System.lineSeparator()
                + "apple,90";
        List<String> allLinesFromFile = readInformationFromFile.getAllLines(fileName);
        shopService.doOperation(allLinesFromFile);
        assertEquals(expected, report.writeReportToString());
    }

    @Test
    public void inputData1_Ok() {
        fileName = "database1.csv";
        expected = "fruit,quantity" + System.lineSeparator()
                + "banana,46" + System.lineSeparator()
                + "apple,134" + System.lineSeparator()
                + "orange,1000";
        List<String> allLinesFromFile = readInformationFromFile.getAllLines(fileName);
        shopService.doOperation(allLinesFromFile);
        assertEquals(expected, report.writeReportToString());
    }

    @Test (expected = ArithmeticException.class)
    public void inputData_NotOk() {
        fileName = "databaseWithNegativeNumber.csv";
        List<String> allLinesFromFile = readInformationFromFile.getAllLines(fileName);
        shopService.doOperation(allLinesFromFile);
        report.writeReportToString();
    }

    @Test
    public void inputDataWithRepetitiveBalance_Ok() {
        fileName = "databaseWithRepetitiveBalance.csv";
        expected = "fruit,quantity" + System.lineSeparator()
                + "banana,152" + System.lineSeparator()
                + "apple,90";
        List<String> allLinesFromFile = readInformationFromFile.getAllLines(fileName);
        shopService.doOperation(allLinesFromFile);
        assertEquals(expected, report.writeReportToString());
    }

    @Test (expected = RuntimeException.class)
    public void writeInFile_NotOk() {
        report.writeReportToFile(null, "databaseError.csv");
    }
}

