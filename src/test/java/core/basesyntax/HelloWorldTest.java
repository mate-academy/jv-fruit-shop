package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HelloWorldTest {
    private OperationStorage operationStorage = new OperationStorage();
    private Conclusion conclusion = new Conclusion();
    private TypesOfFruits typesOfFruits = new TypesOfFruits();
    private DataParser dataParser = new DataParser();
    private Supply supply = new Supply();
    private Buy buy = new Buy();
    private Return ret = new Return();
    private Storage storage = new Storage();
    private final FileReaderForTest fileReaderForTest = new FileReaderForTest();
    private final FileWriterService fileWriterService = new FileWriterServiceImpl();
    private final FileReaderService fileReaderService = new FileReaderServiceImpl();
    private static final String FILE_PATH_TO_EMPTY_FILE
            = "src\\test\\empty";
    private static final String FILE_PATH_TO_FILE_DOES_NOT_EXIST
            = "src\\test\\resources\\k.csv";
    private static final String FILE_PATH_TO_FILE_WITH_ONE_LINE_INFORMATION
            = "src\\test\\testOneOperation";
    private static final String FILE_PATH_TO_OK_FILE
            = "src\\test\\basic";
    private static final String FILE_PATH_TO_FILE_WITH_NOT_ENOUGH_INFORMATION
            = "src\\test\\notEnoughData";
    private static final String FILE_PATH_TO_FILE_WITH_WRONG_OPERATION
            = "src\\test\\wrongOperation";
    private static final String FILE_PATH_TO_FILE_WE_WRITE_IN
            = "src\\test\\writeFile";
    private static final String FILE_PATH_FOR_MAIN_TEST
            = "src\\test\\testAll";
    private static final String FILE_PATH_FOR_MAIN_TEST_TO_WRITE
            = "src\\test\\testAllWrite";

    @Test(expected = RuntimeException.class)
    public void readFileEmpty() {
        fileReaderService
                .readFile(FILE_PATH_TO_EMPTY_FILE, ",");
    }

    @Test(expected = RuntimeException.class)
    public void readFileDoesNotExist() {
        fileReaderService
                .readFile(FILE_PATH_TO_FILE_DOES_NOT_EXIST, ",");
    }

    @Test(expected = RuntimeException.class)
    public void readFileWithWrongSeparator() {
        fileReaderService.readFile(FILE_PATH_TO_FILE_WITH_ONE_LINE_INFORMATION, ":");
    }

    @Test(expected = RuntimeException.class)
    public void readFileWithNotEnoughInformation() {
        fileReaderService.readFile(FILE_PATH_TO_FILE_WITH_NOT_ENOUGH_INFORMATION, ",");
    }

    @Test(expected = RuntimeException.class)
    public void readFileWithWrongOperation() {
        fileReaderService.readFile(FILE_PATH_TO_FILE_WITH_WRONG_OPERATION, ",");
    }

    @Test()
    public void readFileWithOneLineOk() {
        List<List<String>> expectedResultOfReading = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("s");
        row1.add("banana");
        row1.add("100");
        row1.add("2020-10-17");
        expectedResultOfReading.add(row1);

        List<List<String>> actual = fileReaderService
                .readFile(FILE_PATH_TO_FILE_WITH_ONE_LINE_INFORMATION, ",");
        Assert.assertEquals(expectedResultOfReading, actual);
    }

    @Test()
    public void readFileWithMoreThanOneOk() {
        List<List<String>> expectedResultOfReading = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("s");
        row1.add("banana");
        row1.add("100");
        row1.add("2020-10-17");
        List<String> row2 = new ArrayList<>();
        row2.add("s");
        row2.add("banana");
        row2.add("100");
        row2.add("2020-10-27");
        List<String> row3 = new ArrayList<>();
        row3.add("b");
        row3.add("banana");
        row3.add("70");
        row3.add("2020-10-20");
        expectedResultOfReading.add(row1);
        expectedResultOfReading.add(row2);
        expectedResultOfReading.add(row3);

        List<List<String>> actual = fileReaderService
                .readFile(FILE_PATH_TO_OK_FILE, ",");
        Assert.assertEquals(expectedResultOfReading, actual);
    }

    @Test(expected = RuntimeException.class)
    public void writeToBadNameFile() {
        List<List<String>> conclusionData = new ArrayList<>();
        fileWriterService.writeFile(conclusionData, ",", "");
    }

    @Test()
    public void parseDataOk() {
        LocalDate localDate = LocalDate.parse("2020-06-20");
        Fruit expectedFruit = new Fruit("apple", 100, localDate);
        List<String> data = new ArrayList<>();
        data.add("s");
        data.add("apple");
        data.add("100");
        data.add("2020-06-20");
        Fruit actualFruit = dataParser.toReadFromSting(data);
        Assert.assertEquals(expectedFruit.getType(), actualFruit.getType());
        Assert.assertEquals(expectedFruit.getAmount(), actualFruit.getAmount());
        Assert.assertEquals(expectedFruit.getDate(), actualFruit.getDate());
    }

    @Test()
    public void toSupplyOk() {
        LocalDate localDate = LocalDate.of(2020, 4, 12);
        Fruit fruitBanana = new Fruit("banana", 100, localDate);
        Fruit fruitApple = new Fruit("apple", 34, localDate);
        storage.getFruits().add(fruitBanana);
        supply.toDo(fruitApple, storage);
        Assert.assertEquals(fruitApple.getType(),
                storage.getFruits().get(storage.getFruits().size() - 1).getType());
        Assert.assertEquals(fruitApple.getAmount(),
                storage.getFruits().get(storage.getFruits().size() - 1).getAmount());
        Assert.assertEquals(fruitApple.getDate(),
                storage.getFruits().get(storage.getFruits().size() - 1).getDate());
    }

    @Test()
    public void toReturnOk() {
        LocalDate localDate = LocalDate.of(2020, 4, 12);
        Fruit fruitBanana = new Fruit("banana", 100, localDate);
        Fruit fruitApple = new Fruit("apple", 34, localDate);
        storage.getFruits().add(fruitBanana);
        ret.toDo(fruitApple, storage);
        Assert.assertEquals(fruitApple.getType(),
                storage.getFruits().get(storage.getFruits().size() - 1).getType());
        Assert.assertEquals(fruitApple.getAmount(),
                storage.getFruits().get(storage.getFruits().size() - 1).getAmount());
        Assert.assertEquals(fruitApple.getDate(),
                storage.getFruits().get(storage.getFruits().size() - 1).getDate());
    }

    @Test()
    public void toBuyOkFromOneObject() {
        LocalDate localDate = LocalDate.of(2020, 4, 12);
        Fruit fruitPost = new Fruit("banana", 100, localDate);
        storage.getFruits().add(fruitPost);
        LocalDate localDateBuying = LocalDate.of(2020, 4, 11);
        Fruit fruitSell = new Fruit("banana", 20, localDateBuying);
        buy.toDo(fruitSell, storage);
        Fruit fruitRemaining = new Fruit("banana", 80, localDate);
        List<Fruit> expectedList = new ArrayList<>();
        expectedList.add(fruitRemaining);
        Assert.assertEquals(expectedList.size(), storage.getFruits().size());
        Assert.assertEquals(expectedList.get(0).getAmount(),
                storage.getFruits().get(0).getAmount());
        Assert.assertEquals(expectedList.get(0).getDate(),
                storage.getFruits().get(0).getDate());
        Assert.assertEquals(expectedList.get(0).getType(),
                storage.getFruits().get(0).getType());
    }


    @Test(expected = IllegalArgumentException.class)
    public void toBuyAllFruitsAreOverdue() {
        LocalDate localDateBanana = LocalDate.of(2020, 4, 10);
        LocalDate localDateApple = LocalDate.of(2020, 4, 13);
        Fruit fruitPostBanana = new Fruit("banana", 100, localDateBanana);
        Fruit fruitPostApple = new Fruit("apple", 34, localDateApple);
        storage.getFruits().add(fruitPostBanana);
        storage.getFruits().add(fruitPostApple);
        LocalDate localDateBuying = LocalDate.of(2020, 4, 11);
        Fruit fruitSell = new Fruit("banana", 20, localDateBuying);
        buy.toDo(fruitSell, storage);
    }

    @Test()
    public void toBuyOkFromSeveralObjects() {
        LocalDate localDateBanana1 = LocalDate.of(2020, 4, 10);
        LocalDate localDateBanana2 = LocalDate.of(2020, 4, 13);
        LocalDate localDateBanana3 = LocalDate.of(2020, 4, 14);
        Fruit fruitPostBanana1 = new Fruit("banana", 10, localDateBanana1);
        Fruit fruitPostBanana2 = new Fruit("banana", 4, localDateBanana2);
        Fruit fruitPostBanana3 = new Fruit("banana", 15, localDateBanana3);
        storage.getFruits().add(fruitPostBanana1);
        storage.getFruits().add(fruitPostBanana2);
        storage.getFruits().add(fruitPostBanana3);
        LocalDate localDateBuying = LocalDate.of(2020, 4, 11);
        Fruit fruitSell = new Fruit("banana", 10, localDateBuying);
        buy.toDo(fruitSell, storage);
        Fruit fruitRemaining1 = new Fruit("banana", 10, localDateBanana1);
        Fruit fruitRemaining2 = new Fruit("banana", 9, localDateBanana3);
        List<Fruit> expectedList = new ArrayList<>();
        expectedList.add(fruitRemaining1);
        expectedList.add(fruitRemaining2);
        Assert.assertEquals(expectedList.size(), storage.getFruits().size());
        Assert.assertEquals(expectedList.get(1).getType(),
                storage.getFruits().get(1).getType());
        Assert.assertEquals(expectedList.get(1).getAmount(),
                storage.getFruits().get(1).getAmount());
        Assert.assertEquals(expectedList.get(1).getDate(),
                storage.getFruits().get(1).getDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void toBuyNotEnoughFreshFruit() {
        LocalDate localDateApple = LocalDate.of(2020, 4, 13);
        Fruit fruitPostApple = new Fruit("apple", 4, localDateApple);
        storage.getFruits().add(fruitPostApple);
        LocalDate localDateBuying = LocalDate.of(2020, 4, 11);
        Fruit fruitSell = new Fruit("apple", 20, localDateBuying);
        buy.toDo(fruitSell, storage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void toBuyFruitWeDoNotHave() {
        LocalDate localDateApple = LocalDate.of(2020, 4, 13);
        Fruit fruitPostApple = new Fruit("apple", 4, localDateApple);
        Fruit fruitPostOrange = new Fruit("orange", 33, localDateApple);
        Fruit fruitPostLime = new Fruit("lime", 12, localDateApple);
        storage.getFruits().add(fruitPostApple);
        storage.getFruits().add(fruitPostOrange);
        storage.getFruits().add(fruitPostLime);
        Fruit fruitSell = new Fruit("lemon", 4, localDateApple);
        buy.toDo(fruitSell, storage);
    }

    @Test(expected = RuntimeException.class)
    public void toGetTypesFromEmptyStorage() {
        typesOfFruits.toGetTypes(storage);
    }

    @Test
    public void toGetTypesOk() {
        LocalDate localDateApple = LocalDate.of(2020, 4, 13);
        Fruit fruitPostApple = new Fruit("apple", 4, localDateApple);
        Fruit fruitPostOrange = new Fruit("orange", 33, localDateApple);
        Fruit fruitPostLime = new Fruit("lime", 12, localDateApple);
        Fruit fruitPostLime2 = new Fruit("lime", 11, localDateApple);
        storage.getFruits().add(fruitPostApple);
        storage.getFruits().add(fruitPostOrange);
        storage.getFruits().add(fruitPostLime);
        storage.getFruits().add(fruitPostLime2);
        List<String> expectedList = new ArrayList<>();
        expectedList.add("apple");
        expectedList.add("orange");
        expectedList.add("lime");
        Assert.assertEquals(expectedList, typesOfFruits.toGetTypes(storage));
    }

    @Test
    public void toGetResultOk() {
        LocalDate localDateApple = LocalDate.of(2020, 4, 13);
        Fruit fruitPostApple = new Fruit("apple", 4, localDateApple);
        Fruit fruitPostLime = new Fruit("lime", 12, localDateApple);
        Fruit fruitPostLime2 = new Fruit("lime", 11, localDateApple);
        storage.getFruits().add(fruitPostApple);
        storage.getFruits().add(fruitPostLime);
        storage.getFruits().add(fruitPostLime2);
        List<List<String>> expectedResult = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("apple");
        row1.add("4");
        List<String> row2 = new ArrayList<>();
        row2.add("lime");
        row2.add("23");
        expectedResult.add(row1);
        expectedResult.add(row2);
        Assert.assertEquals(expectedResult.size(),
                conclusion.toGetResult(storage,
                        typesOfFruits.toGetTypes(storage)).size());
        Assert.assertEquals(expectedResult.get(1).get(0),
                conclusion.toGetResult(storage,
                        typesOfFruits.toGetTypes(storage)).get(1).get(0));
        Assert.assertEquals(expectedResult.get(1).get(1),
                conclusion.toGetResult(storage,
                        typesOfFruits.toGetTypes(storage)).get(1).get(1));
    }

    @Test
    public void toWriteInFile() {
        List<List<String>> expectedResult = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("apple");
        row1.add("4");
        List<String> row2 = new ArrayList<>();
        row2.add("lime");
        row2.add("23");
        expectedResult.add(row1);
        expectedResult.add(row2);
        fileWriterService.writeFile(expectedResult,
                ",", FILE_PATH_TO_FILE_WE_WRITE_IN);
        Assert.assertEquals(expectedResult.size(),
                fileReaderForTest.toReadWrittenFile(FILE_PATH_TO_FILE_WE_WRITE_IN,
                        ",")
                        .size());
        Assert.assertEquals(expectedResult.get(0),
                fileReaderForTest.toReadWrittenFile(FILE_PATH_TO_FILE_WE_WRITE_IN,
                        ",")
                        .get(0));
        Assert.assertEquals(expectedResult.get(1),
                fileReaderForTest.toReadWrittenFile(FILE_PATH_TO_FILE_WE_WRITE_IN,
                        ",")
                        .get(1));
    }

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
        List<List<String>> readFromFileList = fileReaderForTest
                .toReadWrittenFile(FILE_PATH_FOR_MAIN_TEST, ",");
        for (List<String> row : readFromFileList) {
            operationStorage.getOperationMap()
                    .get(row.get(0))
                    .toDo(dataParser.toReadFromSting(row), storage);
        }
        fileWriterService.writeFile(conclusion.toGetResult(storage,
                typesOfFruits.toGetTypes(storage)),
                ",", FILE_PATH_FOR_MAIN_TEST_TO_WRITE);
        List<List<String>> actual = fileReaderForTest
                .toReadWrittenFile(FILE_PATH_FOR_MAIN_TEST_TO_WRITE, ",");
        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected.get(0), actual.get(0));
        Assert.assertEquals(expected.get(1), actual.get(1));
    }

    @Test
    public void testMain() {
    }
}