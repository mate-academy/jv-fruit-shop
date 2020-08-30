package core.basesyntax;

import core.basesyntax.dao.Box;
import core.basesyntax.dao.FruitStorage;
import core.basesyntax.dao.Storage;
import core.basesyntax.fileservice.Parser;
import core.basesyntax.fileservice.ProductDto;
import core.basesyntax.fileservice.Reader;
import core.basesyntax.goods.FruitPack;
import core.basesyntax.storeservice.Consumer;
import core.basesyntax.storeservice.Supplier;
import core.basesyntax.storeservice.Updater;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class StoreServiceTests {
    public static final Integer FIRST_QUANTITY = 100;
    public static final Integer SECOND_QUANTITY = 200;
    public static final Integer DOUBLED_SECOND_QUANTITY = SECOND_QUANTITY * 2;
    public static final String MANGO_PRODUCT_TYPE = "mango";
    public static final String BANANA_PRODUCT_TYPE = "banana";
    public static final String EMPTY = "";
    public static final String INVALID_ARGS_MESSAGE = "Invalid input arguments";
    public static final String NO_ARGS_MESSAGE = "No operation data found";
    public static final String LACK_OF_PROD_MESSAGE = "Lack of products";
    public static final String TERMINATED_MESSAGE = "Product is terminated";
    public static final String DIR_PATH = "src/main/files/";
    public static final String FIFTH_FILE = "test5.csv";
    public static final String SIXTH_FILE = "test6.csv";
    public static final LocalDate FIRST_EXP_DATE = LocalDate.parse("2020-10-17");
    public static final LocalDate SECOND_EXP_DATE = LocalDate.parse("2020-10-20");
    public static final LocalDate TERMINATED_EXP_DATE = LocalDate.parse("2020-08-14");
    public static final FruitPack MANGO_PACK =
            new FruitPack(MANGO_PRODUCT_TYPE, FIRST_EXP_DATE, FIRST_QUANTITY);
    public static final FruitPack MANGO_PACK_DIFFERENT_DATE =
            new FruitPack(MANGO_PRODUCT_TYPE, SECOND_EXP_DATE, FIRST_QUANTITY);
    public static final FruitPack BANANA_PACK =
            new FruitPack(BANANA_PRODUCT_TYPE, SECOND_EXP_DATE, SECOND_QUANTITY);
    public static final FruitPack BANANA_DOUBLE_PACK =
            new FruitPack(BANANA_PRODUCT_TYPE, SECOND_EXP_DATE, DOUBLED_SECOND_QUANTITY);
    public static final FruitPack TERMINATED_PACK =
            new FruitPack(BANANA_PRODUCT_TYPE, TERMINATED_EXP_DATE, SECOND_QUANTITY);
    public static final FruitStorage STORAGE = Storage.MAIN_STORAGE;
    public static final Updater UPDATER = new Updater();
    public static final Supplier SUPPLIER = new Supplier();
    public static final Consumer CONSUMER = new Consumer();
    public static final Reader READER = new Reader(DIR_PATH);
    public static final Parser PARSER = new Parser();

    @Before
    public void BeforeTest() {
        STORAGE.clearStorage();
    }

    @Test
    public void SupplierEmptyStorageTest() {
        SUPPLIER.updateStorage(MANGO_PACK);
        FruitPack actual = STORAGE.getBox(MANGO_PRODUCT_TYPE)
                .getProduct(FIRST_EXP_DATE);
        Assert.assertEquals(MANGO_PACK, actual);
    }

    @Test
    public void SupplierFilledStorageTest() {
        SUPPLIER.updateStorage(MANGO_PACK);
        SUPPLIER.updateStorage(BANANA_PACK);
        FruitPack actual = STORAGE.getBox(BANANA_PRODUCT_TYPE)
                .getProduct(SECOND_EXP_DATE);
        Assert.assertEquals(BANANA_PACK, actual);
    }

    @Test
    public void SupplierSameProductDiffDatesTest() {
        SUPPLIER.updateStorage(MANGO_PACK);
        SUPPLIER.updateStorage(MANGO_PACK_DIFFERENT_DATE);
        Box box = STORAGE.getBox(MANGO_PRODUCT_TYPE);
        FruitPack actual = box.getProduct(SECOND_EXP_DATE);
        Assert.assertEquals(MANGO_PACK_DIFFERENT_DATE, actual);
    }

    @Test
    public void SupplierNullTest() {
        String actual = EMPTY;
        try {
            SUPPLIER.updateStorage(null);
        } catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }
        Assert.assertEquals(INVALID_ARGS_MESSAGE, actual);
    }

    @Test
    public void ConsumerEmptyStorageTest() {
        SUPPLIER.updateStorage(MANGO_PACK);
        FruitPack actual = STORAGE.getBox(MANGO_PRODUCT_TYPE)
                .getProduct(FIRST_EXP_DATE);
        Assert.assertEquals(MANGO_PACK, actual);
        CONSUMER.updateStorage(MANGO_PACK);
        Assert.assertEquals(0, STORAGE.size());
    }

    @Test
    public void ConsumerFilledStorageTest() {
        SUPPLIER.updateStorage(BANANA_PACK);
        SUPPLIER.updateStorage(BANANA_PACK);
        FruitPack actual = STORAGE.getBox(BANANA_PRODUCT_TYPE)
                .getProduct(SECOND_EXP_DATE);
        Assert.assertEquals(BANANA_DOUBLE_PACK, actual);
        CONSUMER.updateStorage(BANANA_DOUBLE_PACK);
        Assert.assertEquals(0, STORAGE.size());
    }

    @Test
    public void ConsumerTerminatedProductTest() {
        String actual = EMPTY;
        try {
            CONSUMER.updateStorage(TERMINATED_PACK);
        } catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }
        Assert.assertEquals(INVALID_ARGS_MESSAGE, actual);
    }

    @Test
    public void ConsumerNonExistedProductTest() {
        String actual = EMPTY;
        try {
            CONSUMER.updateStorage(BANANA_PACK);
        } catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }
        Assert.assertEquals(INVALID_ARGS_MESSAGE, actual);
    }

    @Test
    public void ConsumerSeveralDiffProductTest() {
        SUPPLIER.updateStorage(MANGO_PACK);
        SUPPLIER.updateStorage(BANANA_PACK);
        SUPPLIER.updateStorage(MANGO_PACK_DIFFERENT_DATE);
        CONSUMER.updateStorage(MANGO_PACK);
        Assert.assertEquals(2, STORAGE.size());
    }

    @Test
    public void ConsumerSeveralSameProductTest() {
        SUPPLIER.updateStorage(BANANA_DOUBLE_PACK);
        CONSUMER.updateStorage(BANANA_PACK);
        int actual = STORAGE.getBox(BANANA_PRODUCT_TYPE)
                .getProduct(SECOND_EXP_DATE)
                .getQuantity();
        Assert.assertEquals(200, actual);
    }

    @Test
    public void ConsumerInvalidQuantityProductTest() {
        String actual = EMPTY;
        SUPPLIER.updateStorage(BANANA_PACK);
        try {
            CONSUMER.updateStorage(BANANA_DOUBLE_PACK);
        } catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }
        Assert.assertEquals(LACK_OF_PROD_MESSAGE, actual);
    }

    @Test
    public void ConsumerNullTest() {
        String actual = EMPTY;
        try {
            CONSUMER.updateStorage(null);
        } catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }
        Assert.assertEquals(INVALID_ARGS_MESSAGE, actual);
    }

    @Test
    public void UpdaterSupplyTest() throws IOException {
        List<String> readData = READER.readFile(FIFTH_FILE);
        List<ProductDto> parsedData = PARSER.parseData(readData);
        UPDATER.updateData(parsedData);
        FruitPack actual = STORAGE.getBox(MANGO_PRODUCT_TYPE)
                .getProduct(FIRST_EXP_DATE);
        Assert.assertEquals(MANGO_PACK, actual);
    }

    @Test
    public void UpdaterConsumeTest() throws IOException {
        List<String> readData1 = READER.readFile(FIFTH_FILE);
        List<ProductDto> parsedData1 = PARSER.parseData(readData1);
        List<String> readData2 = READER.readFile(SIXTH_FILE);
        List<ProductDto> parsedData2 = PARSER.parseData(readData2);
        UPDATER.updateData(parsedData1);
        UPDATER.updateData(parsedData2);
        Assert.assertTrue(STORAGE.isEmpty());
    }

    @Test
    public void UpdaterEmptyListTest() {
        String actual = EMPTY;
        try {
            UPDATER.updateData(Collections.EMPTY_LIST);
        } catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }
        Assert.assertEquals(NO_ARGS_MESSAGE, actual);

    }

    @Test
    public void UpdaterNullTest() {
        String actual = EMPTY;
        try {
            UPDATER.updateData(null);
        } catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }
        Assert.assertEquals(NO_ARGS_MESSAGE, actual);
    }
}
