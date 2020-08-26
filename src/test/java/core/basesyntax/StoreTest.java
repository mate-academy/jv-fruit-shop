package core.basesyntax;

import core.basesyntax.items.Product;
import core.basesyntax.items.Storage;
import core.basesyntax.operations.Buy;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.Supply;
import core.basesyntax.services.DataAggregator;
import core.basesyntax.services.LineParser;
import core.basesyntax.services.Manager;
import core.basesyntax.services.TextPrinter;
import core.basesyntax.services.TextReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StoreTest {
    public final static String FIRST_PATH = "src/test/resources/test_1.txt";
    public final static String SECOND_PATH = "src/test/resources/test_2.txt";
    public final static String THIRD_PATH = "src/test/resources/test_3.txt";
    public final static String FOURTH_PATH = "src/test/resources/test_4.txt";
    public final static String FIFTH_PATH = "src/test/resources/test_5.txt";
    public final static String SIXTH_PATH = "src/test/resources/test_6.txt";
    public final static String BANANA = "banana";
    public final static Integer TWENTY = 20;
    public final static String SEVENTEENTH_OF_OCTOBER = "2020-10-17";
    public final static String EIGHTEENTH_OF_OCTOBER = "2020-10-18";
    public final static String FIFTEENTH_OF_OCTOBER = "2020-10-15";
    public final static String TENTH_OF_OCTOBER = "2020-10-10";
    public final static String FIRST_INPUT_DATA = "s,banana,100,2020-10-17";
    public final static String FIRST_OUTPUT_DATA = "banana,20,2020-10-17";
    public final static String WRONG_ARGUMENT_AMOUNT_TO_PARSE_DATA = "asdasdasd";
    public final static String WRONG_QUANTITY_ARGUMENT_TO_PARSE_DATA = "s,banana,1s00r,2020-10-17";
    public final static String WRONG_DATE_ARGUMENT_TO_PARSE_DATA = "s,banana,100,20204-103-177";

    @Test
    public void TextReaderTest() {
        TextReader reader = new TextReader();
        String actual = reader.read(FIRST_PATH).get(0);
        Assert.assertEquals(FIRST_INPUT_DATA, actual);
    }

    @Test(expected = RuntimeException.class)
    public void TextReaderTestFail() {
        TextReader reader = new TextReader();
        reader.read("asdsd").get(0);
    }

    @Test
    public void TextReaderTestWithMultipleLines() {
        TextReader reader = new TextReader();
        int actual = reader.read(SECOND_PATH).size();
        Assert.assertEquals(3, actual);
    }

    @Test
    public void StorageTestSupplyWithEmptyStorage() {
        Storage storage = new Storage();
        Operation supply = new Supply();
        supply.doAction(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        Assert.assertEquals(FIRST_OUTPUT_DATA + "\n", storage.toString());
    }

    @Test
    public void StorageTestSupplyWithSameFruitDifferentDate() {
        Storage storage = new Storage();
        Operation supply = new Supply();
        supply.doAction(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        supply.doAction(new Product(BANANA, TWENTY, LocalDate.parse(EIGHTEENTH_OF_OCTOBER)), storage);
        Assert.assertEquals(FIRST_OUTPUT_DATA + "\n" + "banana,20,2020-10-18" + "\n",
                storage.toString());
    }

    @Test
    public void StorageTestSupplyWithSameFruitSameDate() {
        Storage storage = new Storage();
        Operation supply = new Supply();
        supply.doAction(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        supply.doAction(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)),storage);
        Assert.assertEquals("banana,40,2020-10-17" + "\n",
                storage.toString());
    }

    @Test
    public void StorageTestBuyNonExistedFruit() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Assert.assertFalse(buy.doAction(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage));
        Assert.assertEquals("", storage.toString());
    }

    @Test
    public void StorageTestBuyNothing() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.doAction(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.doAction(new Product(BANANA, 0, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage));
        Assert.assertEquals(FIRST_OUTPUT_DATA + "\n", storage.toString());
    }

    @Test
    public void StorageTestBuyAllFruitsAreOverdue() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.doAction(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        Assert.assertFalse(buy.doAction(new Product(BANANA, 10, LocalDate.parse(EIGHTEENTH_OF_OCTOBER)), storage));
        Assert.assertEquals(FIRST_OUTPUT_DATA + "\n", storage.toString());
    }

    @Test
    public void StorageTestBuyFromOneBox() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.doAction(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.doAction(new Product(BANANA, 10, LocalDate.parse(FIFTEENTH_OF_OCTOBER)), storage));
        Assert.assertEquals("banana,10,2020-10-17" + "\n", storage.toString());
    }

    @Test
    public void StorageTestBuyFullBox() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.doAction(new Product(BANANA, TWENTY, LocalDate.parse(FIFTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.doAction(new Product(BANANA, TWENTY, LocalDate.parse(TENTH_OF_OCTOBER)), storage));
        Assert.assertEquals("", storage.toString());
    }

    @Test
    public void StorageTestBuyFromDifferentBox() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.doAction(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        supply.doAction(new Product(BANANA, TWENTY, LocalDate.parse(EIGHTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.doAction(new Product(BANANA, 40, LocalDate.parse(FIFTEENTH_OF_OCTOBER)), storage));
        Assert.assertEquals("", storage.toString());
    }

    @Test
    public void StorageTestBuyFromDifferentBoxWithRemainder() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.doAction(new Product(BANANA, TWENTY, LocalDate.parse(TENTH_OF_OCTOBER)), storage);
        supply.doAction(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        supply.doAction(new Product(BANANA, TWENTY, LocalDate.parse(EIGHTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.doAction(new Product(BANANA, 40, LocalDate.parse(FIFTEENTH_OF_OCTOBER)), storage));
        Assert.assertEquals("banana,20,2020-10-10" + "\n", storage.toString());
    }

    @Test
    public void LineParserTest() {
        String line = "s,banana,100,2020-10-17";
        LineParser parser = new LineParser();
        String[] actual = parser.parse(line);
        String[] expected = line.split(",");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void LineParserTestIncorrectArgumentsAmount() {
        LineParser parser = new LineParser();
        String actual = "";
        try {
            parser.parse(WRONG_ARGUMENT_AMOUNT_TO_PARSE_DATA);
        } catch (RuntimeException e) {
            actual = e.getMessage();
        }
        String expected = "Wrong argument format!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void LineParserTestIncorrectQuantity() {
        LineParser parser = new LineParser();
        String actual = "";
        try {
            parser.parse(WRONG_QUANTITY_ARGUMENT_TO_PARSE_DATA);
        } catch (RuntimeException e) {
            actual = e.getMessage();
        }
        String expected = "Wrong quantity format!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void LineParserTestIncorrectDate() {
        LineParser parser = new LineParser();
        String actual = "";
        try {
            parser.parse(WRONG_DATE_ARGUMENT_TO_PARSE_DATA);
        } catch (RuntimeException e) {
            actual = e.getMessage();
        }
        String expected = "Wrong date format!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void AggregatorTest() {
        Storage storage = new Storage();
        DataAggregator aggregator = new DataAggregator();
        aggregator.aggregate(new ArrayList<String>(List.of("s,banana,100,2020-10-17")), storage);
        Assert.assertEquals("banana,100,2020-10-17" + "\n", storage.toString());
    }

    @Test
    public void AggregatorTestWithMultipleActions() {
        Storage storage = new Storage();
        DataAggregator aggregator = new DataAggregator();
        aggregator.aggregate(new ArrayList<String>(List.of("s,banana,100,2020-10-17"
                ,"b,banana,13,2020-10-15", "r,banana,10,2020-10-17")), storage);
        Assert.assertEquals("banana,97,2020-10-17" + "\n", storage.toString());
    }

    @Test
    public void TextPrinterTest() {
        TextPrinter printer = new TextPrinter();
        printer.print("sdasdasdasda", FOURTH_PATH);
        String actual = "";
        try {
            actual = Files.readString(Path.of(FOURTH_PATH));
        } catch (IOException e) {
            throw new RuntimeException("No such file exist!");
        }
        Assert.assertEquals("sdasdasdasda", actual);
    }

    @Test
    public void FullTest() {
        Manager manager = new Manager();
        manager.manage(FIRST_PATH, FIFTH_PATH);
        String actual = "";
        try {
            actual = Files.readString(Path.of(FIFTH_PATH));
        } catch (IOException e) {
            throw new RuntimeException("No such file exist!");
        }
        Assert.assertEquals("banana,100,2020-10-17" + "\n", actual);
    }

    @Test
    public void FullTestExtremeValue() {
        Manager manager = new Manager();
        manager.manage(THIRD_PATH, SIXTH_PATH);
        List<String> actual;
        try {
            actual = Files.readAllLines(Path.of(SIXTH_PATH));
        } catch (IOException e) {
            throw new RuntimeException("No such file exist!");
        }
        List<String> expected = new ArrayList<>(List.of("apple,465,2020-10-16"
                , "apple,505,2020-10-24"
                , "banana,700,2020-10-15"
                , "banana,485,2020-10-17"
                , "potato,650,2020-10-12"
                , "potato,50,2020-10-19"));
        Assert.assertEquals(expected, actual);
    }
}