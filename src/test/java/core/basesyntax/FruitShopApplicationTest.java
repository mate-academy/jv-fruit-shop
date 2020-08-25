package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;

public class FruitShopApplicationTest {
    private static final String SUPPLY_FILE_PATH = "src/test/resources/fruits.txt";
    private static final String ALL_OPERATIONS_FILE_PATH = "src/test/resources/allOperations.txt";
    private static final String BUY_FILE_PATH = "src/test/resources/buyFruits.txt";
    private static final String BUY_SPOILED_FRUITS_FILE_PATH = "src/test/resources/buySpoiledFruits.txt";
    private static final String FILE_PATH_INCORRECT_DATE = "src/test/resources/incorrectDate.txt";
    private static final String FILE_PATH_INCORRECT_NUMBER = "src/test/resources/incorrectNumber.txt";
    private static final String EMPTY_FILE_PATH = "src/test/resources/emptyFile.txt";
    private static final String REPORT_FILE_PATH = "src/test/resources/reportApplication.txt";
    private FruitShop fruitShop;

    @Before
    public void init() {
        fruitShop = new FruitShop();
    }

    @Test
    public void checkFileExecutorReadSupplyFileWithCorrectParam() {
        List<String> strings = List.of("s,banana,100,2020-10-17", "s,orange,100,2020-10-17",
                "s,banana,50,2020-10-19", "s,orange,50,2020-10-19");
        Assert.assertEquals(strings, fruitShop.getFileExecutor().readFile(SUPPLY_FILE_PATH));
    }

    @Test(expected = NoSuchElementException.class)
    public void checkBuyFruitFromEmptyStorage() {
        fruitShop.executeRequestFile(BUY_FILE_PATH);
    }

    @Test(expected = NoSuchElementException.class)
    public void checkFileExecutorReadEmptyFile() {
        fruitShop.executeRequestFile(EMPTY_FILE_PATH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkExecuteRequestFileWithIncorrectDate() {
        fruitShop.executeRequestFile(FILE_PATH_INCORRECT_DATE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkExecuteRequestFileWithIncorrectNumber() {
        fruitShop.executeRequestFile(FILE_PATH_INCORRECT_NUMBER);
    }

    @Test(expected = RuntimeException.class)
    public void checkExecuteRequestFileWithIncorrectFilePath() {
        String incorrectFilePath = "incorrect.txt";
        fruitShop.executeRequestFile(incorrectFilePath);
    }

    @Test
    public void checkGetFileStorageInfoWithCorrectParams() {
        fruitShop.executeRequestFile(SUPPLY_FILE_PATH);
        List<String> strings = List.of("fruit, quantity\n", "banana, 150\n", "orange, 150\n");
        Assert.assertEquals(strings, fruitShop.getFileWithStorageInfo(REPORT_FILE_PATH));
        List<String> stringsAfterBuyOperation = List.of("fruit, quantity\n", "banana, 30\n", "orange, 30\n");
        fruitShop.executeRequestFile(BUY_FILE_PATH);
        Assert.assertEquals(stringsAfterBuyOperation, fruitShop.getFileWithStorageInfo(REPORT_FILE_PATH));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkGetFileStorageInfoWithEmptyFilePath() {
        fruitShop.getFileWithStorageInfo("");
    }

    @Test(expected = RuntimeException.class)
    public void checkGetFileStorageInfoWithIncorrectFilePath() {
        String incorrectFilePath = "/incorrect/incorrect/incorrect";
        fruitShop.getFileWithStorageInfo(incorrectFilePath);
    }

    @Test
    public void checkGetFileStorageInfoWhenAllFruitsAreSpoiled() {
        fruitShop.executeRequestFile(SUPPLY_FILE_PATH);
        fruitShop.executeRequestFile(BUY_SPOILED_FRUITS_FILE_PATH);
        List<String> report = List.of("fruit, quantity\n", "banana, 0\n", "orange, 0\n");
        Assert.assertEquals(report, fruitShop.getFileWithStorageInfo(REPORT_FILE_PATH));
    }

    @Test
    public void checkAllOperationsInOneFile() {
        fruitShop.executeRequestFile(ALL_OPERATIONS_FILE_PATH);
        List<String> report = List.of("fruit, quantity\n", "banana, 80\n",
                "orange, 120\n", "apple, 150\n");
        Assert.assertEquals(report, fruitShop.getFileWithStorageInfo(REPORT_FILE_PATH));
    }
}
