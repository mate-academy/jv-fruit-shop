package core.basesyntax;

import core.basesyntax.exception.InvalidDateException;
import core.basesyntax.exception.NoSuchFruitException;
import core.basesyntax.exception.NotEnoughFruitException;
import core.basesyntax.filereader.FileReaderService;
import core.basesyntax.filereader.LocalFileReaderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitStoreServiceTest {
    public static final String INPUT_FOLDER = "src/test/resources/input/";
    public static final String OUTPUT_FOLDER = "src/test/resources/output/";
    public static final String EXPECTED_FOLDER = "src/test/resources/expected/";
    private static FruitStoreService fruitStoreService;
    private static FileReaderService localFileReaderService;
    private static Storage storage;

    @BeforeClass
    public static void beforeClass() {
        fruitStoreService = new FruitStoreService();
        localFileReaderService = new LocalFileReaderService();
        storage = new Storage();
    }

    @Before
    public void setUp() {
        storage.throwAwayAllTheFruits();
    }

    @Test
    public void buyFruitsOK() {
        String inputPath = INPUT_FOLDER + "buyFruitsOK.csv";
        String outputPath = OUTPUT_FOLDER + "outputBuyFruitsOK.csv";
        String expectedPath = EXPECTED_FOLDER + "expectedBuyFruitsOK.csv";
        fruitStoreService.processData(localFileReaderService.readFile(inputPath));
        List<List<String>> actualAndExpectedData
                = getActualAndExpectedData(outputPath, expectedPath);
        Assert.assertEquals(actualAndExpectedData.get(1), actualAndExpectedData.get(0));
    }

    @Test(expected = NoSuchFruitException.class)
    public void buyNonExistentFruit() {
        String input = INPUT_FOLDER + "buyNonExistentFruit.csv";
        fruitStoreService.processData(localFileReaderService.readFile(input));
    }

    @Test(expected = NotEnoughFruitException.class)
    public void buyMoreFruitsThanAvailable() {
        String input = INPUT_FOLDER + "buyMoreFruitsThanAvailable.csv";
        fruitStoreService.processData(localFileReaderService.readFile(input));
    }

    @Test
    public void buyFruitAfterReturnOk() {
        String input = INPUT_FOLDER + "buyFruitAfterReturnOk.csv";
        String output = OUTPUT_FOLDER + "outputBuyFruitAfterReturnOk.csv";
        String expectedPath = EXPECTED_FOLDER + "expectedBuyFruitAfterReturnOk.csv";
        fruitStoreService.processData(localFileReaderService.readFile(input));
        List<List<String>> actualAndExpectedData = getActualAndExpectedData(output, expectedPath);
        Assert.assertEquals(actualAndExpectedData.get(1), actualAndExpectedData.get(0));
    }

    @Test(expected = NotEnoughFruitException.class)
    public void buyFruitAfterReturnExpiredFruit() {
        String input = INPUT_FOLDER + "buyFruitAfterReturnExpiredFruit.csv";
        fruitStoreService.processData(localFileReaderService.readFile(input));
    }

    @Test
    public void returnFruitsOk() {
        String input = INPUT_FOLDER + "returnFruitsOk.csv";
        String output = OUTPUT_FOLDER + "outputReturnFruitsOk.csv";
        String expectedPath = EXPECTED_FOLDER + "expectedReturnFruitsOk.csv";
        fruitStoreService.processData(localFileReaderService.readFile(input));
        List<List<String>> actualAndExpectedData = getActualAndExpectedData(output, expectedPath);
        Assert.assertEquals(actualAndExpectedData.get(1), actualAndExpectedData.get(0));
    }

    @Test
    public void supplyFruitsOk() {
        String input = INPUT_FOLDER + "supplyFruitsOk.csv";
        String output = OUTPUT_FOLDER + "outputSupplyFruitsOk.csv";
        String expectedPath = EXPECTED_FOLDER + "expectedSupplyFruitsOk.csv";
        fruitStoreService.processData(localFileReaderService.readFile(input));
        List<List<String>> actualAndExpectedData = getActualAndExpectedData(output, expectedPath);
        Assert.assertEquals(actualAndExpectedData.get(1), actualAndExpectedData.get(0));
    }

    @Test(expected = InvalidDateException.class)
    public void supplyFruitsWithInvalidExpirationDate() {
        String input = INPUT_FOLDER + "supplyFruitsWithInvalidExpirationDate.csv";
        fruitStoreService.processData(localFileReaderService.readFile(input));
    }

    private List<List<String>> getActualAndExpectedData
            (String actualPath, String expectedPath) {
        List<String> actual = null;
        List<String> expected = null;
        try {
            expected = Files.readAllLines(Path.of(expectedPath));
            actual = Files.readAllLines(Path.of(actualPath));
        } catch (IOException e) {
            Assert.fail();
        }
        return List.of(actual, expected);
    }
}
