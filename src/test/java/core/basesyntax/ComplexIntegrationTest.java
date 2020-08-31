package core.basesyntax;

import core.basesyntax.dao.FruitStorage;
import core.basesyntax.dao.Storage;
import core.basesyntax.fileservice.Parser;
import core.basesyntax.fileservice.ProductDto;
import core.basesyntax.fileservice.Reader;
import core.basesyntax.storeservice.Updater;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ComplexIntegrationTest {
    public static final String DIR_PATH = "src/main/files/";
    public static final String SEVENTH_FILE = "test7.csv";
    public static final String MANGO_TYPE = "mango";
    public static final String BANANA_TYPE = "banana";
    public static final String ORANGE_TYPE = "orange";
    public static final LocalDate MANGO_EXP_DATE = LocalDate.parse("2020-10-17");
    public static final LocalDate BANANA_EXP_DATE = LocalDate.parse("2020-10-20");
    public static final LocalDate ORANGE_EXP_DATE = LocalDate.parse("2020-10-23");
    public static final Reader READER = new Reader(DIR_PATH);
    public static final Parser PARSER = new Parser();
    public static final FruitStorage STORAGE = Storage.MAIN_STORAGE;
    public static final Updater UPDATER = new Updater();


    @Test
    public void ComplexTest() throws IOException {
        List<ProductDto> inputData = PARSER.parseData(READER.readFile(SEVENTH_FILE));
        UPDATER.updateData(inputData);
        int actual = STORAGE.getBox(MANGO_TYPE)
                .getProduct(MANGO_EXP_DATE)
                .getQuantity();
        Assert.assertEquals(30, actual);
        actual = STORAGE.getBox(BANANA_TYPE)
                .getProduct(BANANA_EXP_DATE)
                .getQuantity();
        Assert.assertEquals(10, actual);
        actual = STORAGE.getBox(ORANGE_TYPE)
                .getProduct(ORANGE_EXP_DATE)
                .getQuantity();
        Assert.assertEquals(20, actual);
    }
}
