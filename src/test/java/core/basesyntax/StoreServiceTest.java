package core.basesyntax;

import core.basesyntax.items.Storage;
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
import java.util.ArrayList;
import java.util.List;

public class StoreServiceTest {
    public final static String FIRST_PATH = "src/test/resources/test_1.csv";
    public final static String SECOND_PATH = "src/test/resources/test_2.csv";
    public final static String THIRD_PATH = "src/test/resources/test_3.csv";
    public final static String FOURTH_PATH = "src/test/resources/test_4.csv";
    public final static String FIFTH_PATH = "src/test/resources/test_5.csv";
    public final static String SIXTH_PATH = "src/test/resources/test_6.csv";
    public final static String FIRST_INPUT_DATA = "s,banana,100,2020-10-17";
    public final static String WRONG_ARGUMENT_AMOUNT_TO_PARSE_DATA = "asdasdasd";
    public final static String WRONG_QUANTITY_ARGUMENT_TO_PARSE_DATA = "s,banana,1s00r,2020-10-17";
    public final static String WRONG_DATE_ARGUMENT_TO_PARSE_DATA = "s,banana,100,20204-103-177";

    @Test
    public void textReaderTest() {
        TextReader reader = new TextReader();
        String actual = reader.read(FIRST_PATH).get(0);
        Assert.assertEquals(FIRST_INPUT_DATA, actual);
    }

    @Test(expected = RuntimeException.class)
    public void textReaderTestFail() {
        TextReader reader = new TextReader();
        reader.read("asdsd").get(0);
    }

    @Test
    public void textReaderTestWithMultipleLines() {
        TextReader reader = new TextReader();
        int actual = reader.read(SECOND_PATH).size();
        Assert.assertEquals(3, actual);
    }

    @Test
    public void lineParserTest() {
        String line = "s,banana,100,2020-10-17";
        LineParser parser = new LineParser();
        String[] actual = parser.parse(line);
        String[] expected = line.split(",");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lineParserTestIncorrectArgumentsAmount() {
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
    public void lineParserTestIncorrectQuantity() {
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
    public void lineParserTestIncorrectDate() {
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
    public void aggregatorTest() {
        Storage storage = new Storage();
        DataAggregator aggregator = new DataAggregator();
        aggregator.aggregate(new ArrayList<String>(List.of("s,banana,100,2020-10-17")), storage);
        List<String> expected = new ArrayList<>(List.of("banana,100,2020-10-17"
                ,"Total amount:"
                ,"banana,100"));
        List<String> actual = List.of(storage.toString().split("\n"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void aggregatorTestWithMultipleActions() {
        Storage storage = new Storage();
        DataAggregator aggregator = new DataAggregator();
        aggregator.aggregate(new ArrayList<String>(List.of("s,banana,100,2020-10-17"
                ,"b,banana,13,2020-10-15"
                ,"r,banana,10,2020-10-17")), storage);
        List<String> expected = new ArrayList<>(List.of("banana,97,2020-10-17"
                ,"Total amount:"
                ,"banana,97"));
        List<String> actual = List.of(storage.toString().split("\n"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void textPrinterTest() {
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
    public void fullTest() {
        Manager manager = new Manager();
        manager.calculateRemainedProduct(FIRST_PATH, FIFTH_PATH);
        List<String> actual;
        try {
            actual = Files.readAllLines(Path.of(FIFTH_PATH));
        } catch (IOException e) {
            throw new RuntimeException("No such file exist!");
        }
        List<String> expected = new ArrayList<>(List.of("banana,100,2020-10-17"
                ,"Total amount:"
                ,"banana,100"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fullTestExtremeValue() {
        Manager manager = new Manager();
        manager.calculateRemainedProduct(THIRD_PATH, SIXTH_PATH);
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
                , "potato,50,2020-10-19"
                ,"Total amount:"
                ,"apple,970"
                ,"banana,1185"
                ,"potato,700"));
        Assert.assertEquals(expected, actual);
    }
}
