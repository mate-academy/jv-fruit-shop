package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FruitShopTest {
    private FileReaderService fileReaderServiceImpl = new FileReaderServiceImpl();
    private OperationStrategy operationStrategy = new OperationStrategy();
    private ReportService reportService = new ReportService();
    private TypesOfFruitsInStorage typesOfFruitsInStorage = new TypesOfFruitsInStorage();
    private Storage storage = new Storage();
    private final FileReaderForTest fileReaderForTest = new FileReaderForTest();
    private final FileWriterService fileWriterService = new FileWriterServiceImpl();
    private static final String FILE_PATH_FOR_MAIN_TEST
            = "src/test/resources/testAll";
    private static final String FILE_PATH_FOR_MAIN_TEST_TO_WRITE
            = "src/test/resources/testAllWrite";

    @Test
    public void toDoAllProgram() {
        List<List<String>> expected = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("apple");
        row1.add("4");
        List<String> row2 = new ArrayList<>();
        row2.add("lime");
        row2.add("33");
        expected.add(row1);
        expected.add(row2);
        operationStrategy.fulfillAllOrders(fileReaderServiceImpl.readFile(FILE_PATH_FOR_MAIN_TEST, ","), storage);
        fileWriterService.writeFile(reportService.toGetReport(storage,
                typesOfFruitsInStorage.getTypesOfFruits(storage)),
                ",", FILE_PATH_FOR_MAIN_TEST_TO_WRITE);
        List<List<String>> actual = fileReaderForTest
                .toReadWrittenFile(FILE_PATH_FOR_MAIN_TEST_TO_WRITE, ",");
        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected.get(0), actual.get(0));
        Assert.assertEquals(expected.get(1), actual.get(1));
    }
}
