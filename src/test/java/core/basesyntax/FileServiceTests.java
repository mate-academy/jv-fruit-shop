package core.basesyntax;

import core.basesyntax.fileservice.Parser;
import core.basesyntax.fileservice.ProductDto;
import core.basesyntax.fileservice.Reader;
import core.basesyntax.storeservice.Consumer;
import core.basesyntax.storeservice.Supplier;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileServiceTests {
    public static final String DIR_PATH = "src/main/files/";
    public static final String FIRST_FILE = "test1.csv";
    public static final String SECOND_FILE = "test2.csv";
    public static final String THIRD_FILE = "test3.csv";
    public static final String FOURTH_FILE = "test4.csv";
    public static final String FIRST_INPUT_DATA = "s, banana, 2020-10-17, 10";
    public static final String INVALID_DATA_FORMAT = "s,banana,2020-10-17,10";
    public static final String LACK_OF_ARGUMENTS = "2020-08-30";
    public static final String INVALID_ARGUMENTS_ORDER = "s, banana, 10, 2020-10-17";
    public static final String EMPTY = "";
    public static final Reader READER = new Reader(DIR_PATH);
    public static final Parser PARSER = new Parser();
    public static final ProductDto BANANA_PRODUCT_DTO = new ProductDto(new Supplier(),
            "banana", LocalDate.parse("2020-10-17"), 10);
    public static final ProductDto MANGO_PRODUCT_DTO = new ProductDto(new Supplier(),
            "mango", LocalDate.parse("2020-10-20"), 5);
    public static final ProductDto PINEAPPLE_PRODUCT_COMPLEX = new ProductDto(new Consumer(),
            "pineapple", LocalDate.parse("2020-10-15"), 500);
    public static final ProductDto COCONUT_PRODUCT_COMPLEX = new ProductDto(new Supplier(),
            "coconut", LocalDate.parse("2020-10-01"), 300);
    public static final ProductDto BANANA_PRODUCT_COMPLEX = new ProductDto(new Supplier(),
            "banana", LocalDate.parse("2020-10-17"), 700);
    public static final ProductDto MANGO_PRODUCT_COMPLEX = new ProductDto(new Supplier(),
            "mango", LocalDate.parse("2020-10-20"), 250);

    @Test(expected = IOException.class)
    public void ReaderTestException() throws IOException {
        READER.readFile("12345");
    }

    @Test
    public void ReaderTestOK() throws IOException {
        String actual = READER.readFile(FIRST_FILE).get(0);
        Assert.assertEquals(FIRST_INPUT_DATA, actual);
    }

    @Test
    public void ReaderMultipleLinesTest() throws IOException {
        int actual = READER.readFile(SECOND_FILE).size();
        Assert.assertEquals(5, actual);
    }

    @Test
    public void ParserTest() throws IOException {
        List<ProductDto> expected = new ArrayList<>();
        expected.add(BANANA_PRODUCT_DTO);
        expected.add(MANGO_PRODUCT_DTO);
        List<ProductDto> actual = PARSER.parseData(READER.readFile(THIRD_FILE));
        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected.get(0), actual.get(0));
        Assert.assertEquals(expected.get(1), actual.get(1));
    }

    @Test
    public void ProductDtoTest() throws IOException {
        List<ProductDto> parsedData = PARSER.parseData(READER.readFile(THIRD_FILE));
        ProductDto parsedMangoElement = parsedData.get(1);
        Assert.assertEquals(MANGO_PRODUCT_DTO.getExpDate(), parsedMangoElement.getExpDate());
        Assert.assertEquals(MANGO_PRODUCT_DTO.getQuantity(), parsedMangoElement.getQuantity());
        Assert.assertEquals(MANGO_PRODUCT_DTO.getType(), parsedMangoElement.getType());
    }

    @Test
    public void ParserNullTest() {
        String actual = EMPTY;
        List<String> readData = new ArrayList<>();
        readData.add(null);
        try {
            PARSER.parseData(readData);
        } catch (RuntimeException exception) {
            actual = exception.getMessage();
        }
        String expected = "No arguments to parse";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ParserEmptyTest() {
        String actual = EMPTY;
        List<String> readData = new ArrayList<>();
        readData.add(EMPTY);
        try {
            PARSER.parseData(readData);
        } catch (RuntimeException exception) {
            actual = exception.getMessage();
        }
        String expected = "Invalid format of input data";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ParserLackOfArgsTest() {
        String actual = EMPTY;
        List<String> readData = new ArrayList<>();
        readData.add(LACK_OF_ARGUMENTS);
        try {
            PARSER.parseData(readData);
        } catch (RuntimeException exception) {
            actual = exception.getMessage();
        }
        String expected = "Invalid format of input data";
        Assert.assertEquals(expected, actual);
    }

   @Test
    public void ParserInvalidRegexTest() {
        String actual = EMPTY;
        List<String> readData = new ArrayList<>();
        readData.add(INVALID_DATA_FORMAT);
        try {
            PARSER.parseData(readData);
        } catch (RuntimeException exception) {
            actual = exception.getMessage();
        }
        String expected = "Invalid format of input data";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ParserInvalidArgsOrder() {
        String actual = EMPTY;
        List<String> readData = new ArrayList<>();
        readData.add(INVALID_ARGUMENTS_ORDER);
        try {
            PARSER.parseData(readData);
        } catch (RuntimeException exception) {
            actual = exception.getMessage();
        }
        String expected = "Invalid format of input data";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ComplexTest() throws IOException {
        List<String> actual1 = READER.readFile(FOURTH_FILE);
        List<String> expected1 = new ArrayList<>();
        expected1.add("s, banana, 2020-10-17, 700");
        expected1.add("s, mango, 2020-10-20, 250");
        expected1.add("b, pineapple, 2020-10-15, 500");
        expected1.add("r, coconut, 2020-10-01, 300");
        expected1.add("s, banana, 2020-10-17, 700");
        expected1.add("s, mango, 2020-10-20, 250");
        expected1.add("b, pineapple, 2020-10-15, 500");
        expected1.add("r, coconut, 2020-10-01, 300");
        expected1.add("s, banana, 2020-10-17, 700");
        expected1.add("s, mango, 2020-10-20, 250");
        expected1.add("b, pineapple, 2020-10-15, 500");
        expected1.add("r, coconut, 2020-10-01, 300");
        expected1.add("s, banana, 2020-10-17, 700");
        expected1.add("s, mango, 2020-10-20, 250");
        expected1.add("b, pineapple, 2020-10-15, 500");
        expected1.add("r, coconut, 2020-10-01, 300");
        expected1.add("s, banana, 2020-10-17, 700");
        expected1.add("s, mango, 2020-10-20, 250");
        expected1.add("b, pineapple, 2020-10-15, 500");
        expected1.add("r, coconut, 2020-10-01, 300");
        Assert.assertEquals(actual1, expected1);
        List<ProductDto> actual2 = PARSER.parseData(actual1);
        List<ProductDto> expected2 = new ArrayList<>();
        expected2.add(BANANA_PRODUCT_COMPLEX);
        expected2.add(MANGO_PRODUCT_COMPLEX);
        expected2.add(PINEAPPLE_PRODUCT_COMPLEX);
        expected2.add(COCONUT_PRODUCT_COMPLEX);
        expected2.add(BANANA_PRODUCT_COMPLEX);
        expected2.add(MANGO_PRODUCT_COMPLEX);
        expected2.add(PINEAPPLE_PRODUCT_COMPLEX);
        expected2.add(COCONUT_PRODUCT_COMPLEX);
        expected2.add(BANANA_PRODUCT_COMPLEX);
        expected2.add(MANGO_PRODUCT_COMPLEX);
        expected2.add(PINEAPPLE_PRODUCT_COMPLEX);
        expected2.add(COCONUT_PRODUCT_COMPLEX);
        expected2.add(BANANA_PRODUCT_COMPLEX);
        expected2.add(MANGO_PRODUCT_COMPLEX);
        expected2.add(PINEAPPLE_PRODUCT_COMPLEX);
        expected2.add(COCONUT_PRODUCT_COMPLEX);
        expected2.add(BANANA_PRODUCT_COMPLEX);
        expected2.add(MANGO_PRODUCT_COMPLEX);
        expected2.add(PINEAPPLE_PRODUCT_COMPLEX);
        expected2.add(COCONUT_PRODUCT_COMPLEX);
        Assert.assertEquals(expected2, actual2);
    }
}
