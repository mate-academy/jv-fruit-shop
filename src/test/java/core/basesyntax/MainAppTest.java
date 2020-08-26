package core.basesyntax;

import core.basesyntax.exception.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainAppTest {
    private String[] args;
    private FruitStoreDao fruitStoreDAO = new FruitStoreDao();
    public static final String INPUT_FOLDER = "src/test/resources/input/";
    public static final String OUTPUT_FOLDER = "src/test/resources/output/";
    public static final String EXPECTED_FOLDER = "src/test/resources/expected/";

    @Before
    public void setUp() {
        fruitStoreDAO.throwAwayAllTheFruits();
    }

    @Test
    public void supplyFruitsOk() {
        String supplyFruitsOkInput = INPUT_FOLDER + "supplyFruitsOk.txt";
        String supplyFruitsOkOutput = OUTPUT_FOLDER + "outputSupplyFruitsOk.txt";
        String SupplyFruitsOkExpected = EXPECTED_FOLDER + "expectedSupplyFruitsOk.txt";
        args = new String[]{supplyFruitsOkInput, supplyFruitsOkOutput};
        MainApp.main(args);
        List<List<String>> actualAndExpectedData = getActualAndExpectedData(supplyFruitsOkOutput, SupplyFruitsOkExpected);
        Assert.assertEquals(actualAndExpectedData.get(1), actualAndExpectedData.get(0));
    }

    @Test
    public void supplyFruitsWithInvalidExpirationDate() {
        String supplyFruitsOkInput = INPUT_FOLDER + "supplyFruitsWithInvalidExpirationDate.txt";
        String supplyFruitsOkOutput = OUTPUT_FOLDER + "outputSupplyFruitsWithInvalidExpirationDate.txt";
        args = new String[]{supplyFruitsOkInput, supplyFruitsOkOutput};
        try {
            MainApp.main(args);
        } catch (InvalidDateException e) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void buyFruitsOK() {
        String supplyFruitsOkInput = INPUT_FOLDER + "buyFruitsOK.txt";
        String supplyFruitsOkOutput = OUTPUT_FOLDER + "outputBuyFruitsOK.txt";
        String SupplyFruitsOkExpected = EXPECTED_FOLDER + "expectedBuyFruitsOK.txt";
        args = new String[]{supplyFruitsOkInput, supplyFruitsOkOutput};
        MainApp.main(args);
        List<List<String>> actualAndExpectedData = getActualAndExpectedData(supplyFruitsOkOutput, SupplyFruitsOkExpected);
        Assert.assertEquals(actualAndExpectedData.get(1), actualAndExpectedData.get(0));
    }

    @Test
    public void buyNonExistentFruit() {
        String supplyFruitsOkInput = INPUT_FOLDER + "buyNonExistentFruit.txt";
        String supplyFruitsOkOutput = OUTPUT_FOLDER + "outputBuyNonExistentFruit.txt";
        args = new String[]{supplyFruitsOkInput, supplyFruitsOkOutput};
        try {
            MainApp.main(args);
        } catch (NoSuchFruitException e) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void buyExpiredFruit() {
        String supplyFruitsOkInput = INPUT_FOLDER + "buyExpiredFruit.txt";
        String supplyFruitsOkOutput = OUTPUT_FOLDER + "outputBuyExpiredFruit.txt";
        args = new String[]{supplyFruitsOkInput, supplyFruitsOkOutput};
        try {
            MainApp.main(args);
        } catch (NoSuchFruitException e) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void buyMoreFruitsThanAvailable() {
        String supplyFruitsOkInput = INPUT_FOLDER + "buyMoreFruitsThanAvailable.txt";
        String supplyFruitsOkOutput = OUTPUT_FOLDER + "outputBuyMoreFruitsThanAvailable.txt";
        args = new String[]{supplyFruitsOkInput, supplyFruitsOkOutput};
        try {
            MainApp.main(args);
        } catch (NotEnoughFruitException e) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void returnFruitsOk() {
        String supplyFruitsOkInput = INPUT_FOLDER + "returnFruitsOk.txt";
        String supplyFruitsOkOutput = OUTPUT_FOLDER + "outputReturnFruitsOk.txt";
        String SupplyFruitsOkExpected = EXPECTED_FOLDER + "expectedReturnFruitsOk.txt";
        args = new String[]{supplyFruitsOkInput, supplyFruitsOkOutput};
        MainApp.main(args);
        List<List<String>> actualAndExpectedData = getActualAndExpectedData(supplyFruitsOkOutput, SupplyFruitsOkExpected);
        Assert.assertEquals(actualAndExpectedData.get(1), actualAndExpectedData.get(0));
    }

    @Test
    public void buyFruitAfterReturnOk() {
        String supplyFruitsOkInput = INPUT_FOLDER + "buyFruitAfterReturnOk.txt";
        String supplyFruitsOkOutput = OUTPUT_FOLDER + "outputBuyFruitAfterReturnOk.txt";
        String SupplyFruitsOkExpected = EXPECTED_FOLDER + "expectedBuyFruitAfterReturnOk.txt";
        args = new String[]{supplyFruitsOkInput, supplyFruitsOkOutput};
        MainApp.main(args);
        List<List<String>> actualAndExpectedData = getActualAndExpectedData(supplyFruitsOkOutput, SupplyFruitsOkExpected);
        Assert.assertEquals(actualAndExpectedData.get(1), actualAndExpectedData.get(0));
    }

    @Test
    public void buyFruitAfterReturnExpiredFruit() {
        String supplyFruitsOkInput = INPUT_FOLDER + "buyFruitAfterReturnExpiredFruit.txt";
        String supplyFruitsOkOutput = OUTPUT_FOLDER + "outputBuyFruitAfterReturnExpiredFruit.txt";
        args = new String[]{supplyFruitsOkInput, supplyFruitsOkOutput};
        try {
            MainApp.main(args);
        } catch (NotEnoughFruitException e) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void invalidOutputPath() {
        String supplyFruitsOkInput = INPUT_FOLDER + "buyFruitsOK.txt";
        String supplyFruitsOkOutput = "src/test/resources/notExistingFolder/outputBuyExpiredFruit.txt";
        args = new String[]{supplyFruitsOkInput, supplyFruitsOkOutput};
        try {
            MainApp.main(args);
        } catch (FileWritingException e) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void invalidInputPath() {
        String supplyFruitsOkInput = INPUT_FOLDER + "notExistingFile.txt";
        String supplyFruitsOkOutput = OUTPUT_FOLDER + "notExistingFile.txt";
        args = new String[]{supplyFruitsOkInput, supplyFruitsOkOutput};
        try {
            MainApp.main(args);
        } catch (FileReadingException e) {
            return;
        }
        Assert.fail();
    }

    private List<List<String>> getActualAndExpectedData(String actualPath, String expectedPath) {
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
