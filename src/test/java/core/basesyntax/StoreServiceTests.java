package core.basesyntax;

import core.basesyntax.dao.Box;
import core.basesyntax.dao.FruitStorage;
import core.basesyntax.dao.Storage;
import core.basesyntax.goods.FruitPack;
import core.basesyntax.storeservice.Consumer;
import core.basesyntax.storeservice.Supplier;
import core.basesyntax.storeservice.Updater;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class StoreServiceTests {
    public static final Integer FIRST_QUANTITY = 100;
    public static final Integer SECOND_QUANTITY = 200;
    public static final String MANGO_PRODUCT_TYPE = "mango";
    public static final String BANANA_PRODUCT_TYPE = "banana";
    public static final LocalDate FIRST_EXP_DATE = LocalDate.parse("2020-10-17");
    public static final LocalDate SECOND_EXP_DATE = LocalDate.parse("2020-10-17");
    public static final LocalDate TERMINATED_EXP_DATE = LocalDate.parse("2020-10-18");
    public static final FruitPack MANGO_PACK =
            new FruitPack(MANGO_PRODUCT_TYPE, FIRST_EXP_DATE, FIRST_QUANTITY);
    public static final FruitPack MANGO_PACK_DIFFERENT_DATE =
            new FruitPack(MANGO_PRODUCT_TYPE, SECOND_EXP_DATE, FIRST_QUANTITY);
    public static final FruitPack BANANA_PACK =
            new FruitPack(BANANA_PRODUCT_TYPE, SECOND_EXP_DATE, SECOND_QUANTITY);
    public static final FruitPack TERMINATED_PACK =
            new FruitPack(BANANA_PRODUCT_TYPE, TERMINATED_EXP_DATE, SECOND_QUANTITY);
    public static final FruitStorage STORAGE = Storage.MAIN_STORAGE;
    public static final Updater UPDATER = new Updater();
    public static final Supplier SUPPLIER = new Supplier();
    public static final Consumer CONSUMER = new Consumer();

    @Before
    public void BeforeTest() {
        STORAGE.clearStorage();
    }

    @Test
    public void SupplierEmptyStorageTest() {
        SUPPLIER.updateStorage(MANGO_PACK);
        FruitPack actual = STORAGE.getBox(MANGO_PRODUCT_TYPE).getProduct(FIRST_EXP_DATE);
        Assert.assertEquals(MANGO_PACK, actual);
    }

    @Test
    public void SupplierFilledStorageTest() {
        SUPPLIER.updateStorage(MANGO_PACK);
        SUPPLIER.updateStorage(BANANA_PACK);
        FruitPack actual = STORAGE.getBox(BANANA_PRODUCT_TYPE).getProduct(FIRST_EXP_DATE);
        Assert.assertEquals(BANANA_PACK, actual);
    }

    @Test
    public void SupplierSameProductDiffDatesTest() {
        SUPPLIER.updateStorage(MANGO_PACK);
        SUPPLIER.updateStorage(MANGO_PACK_DIFFERENT_DATE);
        Box box = STORAGE.getBox(BANANA_PRODUCT_TYPE);
        FruitPack actual = box.getProduct(SECOND_EXP_DATE);
        Assert.assertEquals(MANGO_PACK_DIFFERENT_DATE, actual);
    }
}
