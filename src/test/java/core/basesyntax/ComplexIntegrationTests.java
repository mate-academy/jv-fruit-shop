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

public class ComplexIntegrationTests {
    public static final String DIR_PATH = "src/main/files/";
    public static final String FOURTH_FILE = "test4.csv";
    public static final Reader READER = new Reader(DIR_PATH);
    public static final Parser PARSER = new Parser();
    public static final ProductDto PINEAPPLE_PRODUCT_COMPLEX = new ProductDto(new Consumer(),
            "pineapple", LocalDate.parse("2020-10-15"), 500);
    public static final ProductDto COCONUT_PRODUCT_COMPLEX = new ProductDto(new Supplier(),
            "coconut", LocalDate.parse("2020-10-01"), 300);
    public static final ProductDto BANANA_PRODUCT_COMPLEX = new ProductDto(new Supplier(),
            "banana", LocalDate.parse("2020-10-17"), 700);
    public static final ProductDto MANGO_PRODUCT_COMPLEX = new ProductDto(new Supplier(),
            "mango", LocalDate.parse("2020-10-20"), 250);

    @Test
    public void ComplexTest() throws IOException {
        List<String> actual1 = READER.readFile(FOURTH_FILE);
        List<String> expected1 = new ArrayList<>();
        expected1.add("b, pineapple, 2020-10-15, 500");
        expected1.add("b, pineapple, 2020-10-15, 500");
        expected1.add("b, pineapple, 2020-10-15, 500");
        expected1.add("b, pineapple, 2020-10-15, 500");
        expected1.add("b, pineapple, 2020-10-15, 500");
        expected1.add("r, coconut, 2020-10-01, 300");
        expected1.add("r, coconut, 2020-10-01, 300");
        expected1.add("r, coconut, 2020-10-01, 300");
        expected1.add("r, coconut, 2020-10-01, 300");
        expected1.add("r, coconut, 2020-10-01, 300");
        expected1.add("s, banana, 2020-10-17, 700");
        expected1.add("s, banana, 2020-10-17, 700");
        expected1.add("s, banana, 2020-10-17, 700");
        expected1.add("s, banana, 2020-10-17, 700");
        expected1.add("s, banana, 2020-10-17, 700");
        expected1.add("s, mango, 2020-10-20, 250");
        expected1.add("s, mango, 2020-10-20, 250");
        expected1.add("s, mango, 2020-10-20, 250");
        expected1.add("s, mango, 2020-10-20, 250");
        expected1.add("s, mango, 2020-10-20, 250");
        Assert.assertEquals(actual1, expected1);
        List<ProductDto> actual2 = PARSER.parseData(actual1);
        List<ProductDto> expected2 = new ArrayList<>();
        expected2.add(PINEAPPLE_PRODUCT_COMPLEX);
        expected2.add(PINEAPPLE_PRODUCT_COMPLEX);
        expected2.add(PINEAPPLE_PRODUCT_COMPLEX);
        expected2.add(PINEAPPLE_PRODUCT_COMPLEX);
        expected2.add(PINEAPPLE_PRODUCT_COMPLEX);
        expected2.add(COCONUT_PRODUCT_COMPLEX);
        expected2.add(COCONUT_PRODUCT_COMPLEX);
        expected2.add(COCONUT_PRODUCT_COMPLEX);
        expected2.add(COCONUT_PRODUCT_COMPLEX);
        expected2.add(COCONUT_PRODUCT_COMPLEX);
        expected2.add(BANANA_PRODUCT_COMPLEX);
        expected2.add(BANANA_PRODUCT_COMPLEX);
        expected2.add(BANANA_PRODUCT_COMPLEX);
        expected2.add(BANANA_PRODUCT_COMPLEX);
        expected2.add(BANANA_PRODUCT_COMPLEX);
        expected2.add(MANGO_PRODUCT_COMPLEX);
        expected2.add(MANGO_PRODUCT_COMPLEX);
        expected2.add(MANGO_PRODUCT_COMPLEX);
        expected2.add(MANGO_PRODUCT_COMPLEX);
        expected2.add(MANGO_PRODUCT_COMPLEX);
        Assert.assertEquals(expected2, actual2);
    }

}
