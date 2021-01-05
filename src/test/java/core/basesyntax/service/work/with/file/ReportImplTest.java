package core.basesyntax.service.work.with.file;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import java.util.List;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReportImplTest {
    private static Report report;
    private static String expected;
    private static String fileName;
    private static FruitService fruitService;
    private static ReadInformationFromFile readInformationFromFile;

    @BeforeClass
    public static void beforeClass() throws Exception {
        report = new ReportImpl();
        fruitService = new FruitServiceImpl();
        readInformationFromFile = new ReadInformationFromFileImpl();
    }

    @After
    public void tearDown() throws Exception {
        Storage.fruits.clear();
    }

    @Test
    public void inputData_Ok() {
        fileName = "database.csv";
        List<String> allLinesFromFile = readInformationFromFile.getAllLines(fileName);
        fruitService.addNewFruit(allLinesFromFile);
        expected = "fruit,quantity" + System.lineSeparator()
                + "banana,152" + System.lineSeparator()
                + "apple,90";
        assertEquals(expected, report.writeReport(allLinesFromFile));
    }

    @Test
    public void inputData1_Ok() {
        fileName = "database1.csv";
        List<String> allLinesFromFile = readInformationFromFile.getAllLines(fileName);
        fruitService.addNewFruit(allLinesFromFile);
        expected = "fruit,quantity" + System.lineSeparator()
                + "banana,46" + System.lineSeparator()
                + "apple,134" + System.lineSeparator()
                + "orange,1000";
        assertEquals(expected, report.writeReport(allLinesFromFile));
    }

    @Test (expected = ArithmeticException.class)
    public void inputData_NotOk() {
        fileName = "databaseWithNegativeNumber.csv";
        List<String> allLinesFromFile = readInformationFromFile.getAllLines(fileName);
        fruitService.addNewFruit(allLinesFromFile);
        report.writeReport(allLinesFromFile);
    }

    @Test
    public void inputDataWithRepetitiveBalance_Ok() {
        fileName = "databaseWithRepetitiveBalance.csv";
        List<String> allLinesFromFile = readInformationFromFile.getAllLines(fileName);
        fruitService.addNewFruit(allLinesFromFile);
        expected = "fruit,quantity" + System.lineSeparator()
                + "banana,152" + System.lineSeparator()
                + "apple,90";
        assertEquals(expected, report.writeReport(allLinesFromFile));
    }

    @Test
    public void inputWithoutBalanceButWithSupply() {
        fileName = "databaseWithoutBalanceButWithSupply.csv";
        List<String> allLinesFromFile = readInformationFromFile.getAllLines(fileName);
        fruitService.addNewFruit(allLinesFromFile);
        expected = "fruit,quantity" + System.lineSeparator()
                + "banana,132" + System.lineSeparator()
                + "apple,90";
        assertEquals(expected, report.writeReport(allLinesFromFile));
    }

    @Test (expected = RuntimeException.class)
    public void writeInFile_NotOk() {
        report.writeReportToFile(null, "databaseError.csv");
    }
}
