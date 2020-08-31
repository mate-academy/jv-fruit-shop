package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import core.basesyntax.daily.AvailableFruit;
import core.basesyntax.daily.Fruit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FruitShopTest {

    private static final String EMPTY_FILE = "FileEmpty.csv";
    private static final String WRONG_DATA_FILE = "File2.csv";
    private static final String MANY_FRUITS = "File1.csv";
    private static final String WRONG_OPERATION = "FileWrongOps.csv";
    private static final String ERROR_IN_DATE = "FIle3.csv";
    private static final String NO_FILE = "NoFile.csv";
    private static final String RESULT = "Report";
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String REPORT_LINE_TWO = "orange,140";
    private static final String REPORT_LINE_FOUR = "apple,40";
    private static final String REPORT_LINE_THREE = "banana,257";
    private static final Path REPORT = Paths.get("Report");
    private FruitStoreApplication fruitStoreApplication = new FruitStoreApplication();

    @Before
    public void setUp() throws Exception {
        Files.deleteIfExists(REPORT);
    }

    @Test(expected = RuntimeException.class)
    public void emptyFile() throws IOException {
        fruitStoreApplication.makeReport(EMPTY_FILE);
    }

    @Test(expected = RuntimeException.class)
    public void wrongDataInFile() throws IOException {
        fruitStoreApplication.makeReport(WRONG_DATA_FILE);
    }

    @Test(expected = RuntimeException.class)
    public void fileAbsent() throws IOException {
        fruitStoreApplication.makeReport(NO_FILE);
    }

    @Test(expected = RuntimeException.class)
    public void fileWithWrongOperation() throws IOException {
        fruitStoreApplication.makeReport(WRONG_OPERATION);
    }

    @Test
    public void testReportWithManyFruits() throws IOException {
        fruitStoreApplication.makeReport(MANY_FRUITS);
        List<String> BigTestFile = Files.readAllLines(Path.of(RESULT));
        Assert.assertTrue(BigTestFile.size() == 4);
        Assert.assertEquals(REPORT_HEADER, BigTestFile.get(0));
        Assert.assertEquals(REPORT_LINE_TWO, BigTestFile.get(1));
        Assert.assertEquals(REPORT_LINE_THREE, BigTestFile.get(2));
        Assert.assertEquals(REPORT_LINE_FOUR, BigTestFile.get(3));
    }

    @Test(expected = RuntimeException.class)
    public void wrongData() throws IOException {
        fruitStoreApplication.makeReport(ERROR_IN_DATE);
    }

    @Test
    public void checkAdditionToStock() {
        List<Fruit> fruits = new ArrayList<>();
        Fruit fruit = new Fruit();
        fruit.setFruitName("banana");
        fruit.setLocalDate(LocalDate.now());
        fruits.add(fruit);
        Assert.assertTrue(AvailableFruit.getStockReport(fruits).size() == 1);
        Assert.assertTrue(AvailableFruit.getStockReport(fruits).get("banana") == 1);
    }
}
