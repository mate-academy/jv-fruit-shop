package core.basesyntax;

import core.basesyntax.dao.Box;
import core.basesyntax.dao.FruitStorage;
import core.basesyntax.goods.FruitPack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

public class DaoStorageTests {
    public static final Integer COCONUT_QUANTITY = 200;
    public static final Integer NEW_COCONUT_QUANTITY = 600;
    public static final String PRODUCT_TYPE = "coconut";
    public static final String NON_EXISTED_PRODUCT_TYPE = "kiwi";
    public static final String INVALID_INPUT_ARG = "lol";
    public static final LocalDate VALID_DATE = LocalDate.parse("2020-10-17");
    public static final LocalDate TERMINATED_DATE = LocalDate.parse("2020-08-14");
    public static final FruitPack VALID_PRODUCT =
            new FruitPack(PRODUCT_TYPE, VALID_DATE, COCONUT_QUANTITY);
    public static final FruitPack TERMINATED_PRODUCT =
            new FruitPack(PRODUCT_TYPE, TERMINATED_DATE, COCONUT_QUANTITY);
    public static final Box BOX = new Box();
    public static final Box BOX_WITH_COCONUTS = new Box(VALID_PRODUCT);
    public static final FruitStorage STORAGE = new FruitStorage();

    @Before
    public void BeforeTest() {
        BOX.clear();
        STORAGE.clearStorage();
    }

    @Test
    public void EmptyBoxAddTestOk() {
        BOX.addProduct(VALID_PRODUCT);
        FruitPack actual = BOX.getProduct(VALID_PRODUCT.getExpDate());
        Assert.assertEquals(actual, VALID_PRODUCT);
    }

    @Test
    public void BoxClearTestOk() {
        BOX.addProduct(VALID_PRODUCT);
        Assert.assertEquals(1, BOX.size());
        BOX.clear();
        Assert.assertEquals(0, BOX.size());
    }

    @Test
    public void FilledBoxAddTestOk() {
        BOX.addProduct(VALID_PRODUCT);
        BOX.addProduct(VALID_PRODUCT);
        BOX.addProduct(VALID_PRODUCT);
        FruitPack product = BOX.getProduct(VALID_PRODUCT.getExpDate());
        Integer actual = product.getQuantity();
        Assert.assertEquals(NEW_COCONUT_QUANTITY, actual);
        BOX.clear();
    }

    @Test
    public void BoxAddTerminatedProductTest() {
        String actual = "";
        try {
            BOX.addProduct(TERMINATED_PRODUCT);
        } catch (DateTimeException exception) {
            actual = exception.getMessage();
        }
        String expected = "Product is terminated";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void BoxAddInvalidArgsTest() {
        String actual = "";
        try {
            BOX.addProduct(null);
        } catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }
        String expected = "Invalid arguments";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void BoxGetProductTestOk() {
        BOX.addProduct(VALID_PRODUCT);
        FruitPack actual = BOX.getProduct(VALID_DATE);
        Assert.assertEquals(VALID_PRODUCT, actual);
    }

    @Test
    public void BoxGetProductNullTest() {
        BOX.addProduct(VALID_PRODUCT);
        FruitPack actual = BOX.getProduct(VALID_DATE);
        Assert.assertEquals(VALID_PRODUCT, actual);
    }

    @Test
    public void BoxGetTerminatedProductTest() {
        String actual = "";
        try {
            BOX.addProduct(TERMINATED_PRODUCT);
        } catch (DateTimeException exception) {
            actual = exception.getMessage();
        }
        String expected = "Product is terminated";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void BoxGetInvalidArgsTest() {
        String actual = "";
        try {
            BOX.getProduct(null);
        } catch (DateTimeException exception) {
            actual = exception.getMessage();
        }
        String expected = "Invalid date input";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void BoxRemoveProductTestOk() {
        Assert.assertEquals(0, BOX.size());
        BOX.addProduct(VALID_PRODUCT);
        Assert.assertEquals(1, BOX.size());
        BOX.removeProduct(VALID_DATE);
        Assert.assertEquals(0, BOX.size());
    }

    @Test
    public void BoxRemoveProductNullTest() {
        String actual = "";
        try {
            BOX.removeProduct(null);
        } catch (DateTimeException exception) {
            actual = exception.getMessage();
        }
        String expected = "Invalid date input";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void BoxRemoveTerminatedProductTest() {
        String actual = "";
        try {
            BOX.removeProduct(TERMINATED_DATE);
        } catch (DateTimeException exception) {
            actual = exception.getMessage();
        }
        String expected = "Product is terminated";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void EmptyStorageAddBoxTestOk() {
        Assert.assertEquals(0, STORAGE.size());
        STORAGE.addProduct(VALID_PRODUCT);
        Assert.assertEquals(1, STORAGE.size());
        FruitPack actual = STORAGE.getBox(PRODUCT_TYPE).getProduct(VALID_DATE);
        Assert.assertEquals(VALID_PRODUCT, actual);
    }

    @Test
    public void FilledStorageAddProductTestOk() {
        STORAGE.addProduct(VALID_PRODUCT);
        STORAGE.addProduct(VALID_PRODUCT);
        STORAGE.addProduct(VALID_PRODUCT);
        Integer actual = STORAGE.getBox(PRODUCT_TYPE).getProduct(VALID_DATE).getQuantity();
        Assert.assertEquals(NEW_COCONUT_QUANTITY, actual);
    }

    @Test
    public void StorageAddTerminatedProductTest() {
        String actual = "";
        try {
            STORAGE.addProduct(TERMINATED_PRODUCT);
        } catch (DateTimeException exception) {
            actual = exception.getMessage();
        }
        String expected = "Product is terminated";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void StorageAddNullTest() {
        String actual = "";
        try {
            STORAGE.addProduct(null);
        } catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }
        String expected = "Invalid input arguments";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void StorageContainsProductTestOk() {
        STORAGE.addProduct(VALID_PRODUCT);
        Assert.assertTrue(STORAGE.contains(PRODUCT_TYPE));
    }

    @Test
    public void StorageContainsNonExistedProductTest() {
        Assert.assertFalse(STORAGE.contains(NON_EXISTED_PRODUCT_TYPE));
    }

    @Test
    public void StorageContainsNullTest() {
        String actual = "";
        try {
            STORAGE.contains(null);
        } catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }
        String expected = "Invalid input arguments";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void StorageContainsInvalidArgsTest() {
        Assert.assertFalse(STORAGE.contains(INVALID_INPUT_ARG));
    }

    @Test
    public void StorageGetBoxTestOk() {
        STORAGE.addProduct(VALID_PRODUCT);
        Box actual = STORAGE.getBox(PRODUCT_TYPE);
        Assert.assertEquals(BOX_WITH_COCONUTS, actual);
    }

    @Test
    public void StorageGetBoxNullTest() {
        String actual = "";
        try {
            STORAGE.getBox(null);
        } catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }
        String expected = "Invalid input arguments";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void StorageGetBoxInvalidArgsTest() {
        String actual = "";
        try {
            STORAGE.getBox(INVALID_INPUT_ARG);
        } catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }
        String expected = "Invalid input arguments";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void StorageClearTestOk() {
        Assert.assertEquals(0, STORAGE.size());
        STORAGE.addProduct(VALID_PRODUCT);
        Assert.assertEquals(1, STORAGE.size());
        STORAGE.clearStorage();
        Assert.assertEquals(0, STORAGE.size());
    }
}
