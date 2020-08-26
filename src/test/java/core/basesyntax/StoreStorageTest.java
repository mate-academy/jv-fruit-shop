package core.basesyntax;

import core.basesyntax.items.Product;
import core.basesyntax.items.Storage;
import core.basesyntax.operations.Buy;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.Supply;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class StoreStorageTest {

    public final static String BANANA = "banana";
    public final static Integer TWENTY = 20;
    public final static String SEVENTEENTH_OF_OCTOBER = "2020-10-17";
    public final static String EIGHTEENTH_OF_OCTOBER = "2020-10-18";
    public final static String FIFTEENTH_OF_OCTOBER = "2020-10-15";
    public final static String TENTH_OF_OCTOBER = "2020-10-10";
    public final static String FIRST_OUTPUT_DATA = "banana,20,2020-10-17";

    @Test
    public void storageTestSupplyWithEmptyStorage() {
        Storage storage = new Storage();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        Assert.assertEquals(FIRST_OUTPUT_DATA + "\n", storage.toString());
    }

    @Test
    public void storageTestSupplyWithSameFruitDifferentDate() {
        Storage storage = new Storage();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(EIGHTEENTH_OF_OCTOBER)), storage);
        Assert.assertEquals(FIRST_OUTPUT_DATA + "\n" + "banana,20,2020-10-18" + "\n",
                storage.toString());
    }

    @Test
    public void storageTestSupplyWithSameFruitSameDate() {
        Storage storage = new Storage();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        Assert.assertEquals("banana,40,2020-10-17" + "\n",
                storage.toString());
    }

    @Test
    public void storageTestBuyNonExistedFruit() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Assert.assertFalse(buy.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage));
        Assert.assertEquals("", storage.toString());
    }

    @Test
    public void storageTestBuyNothing() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.updateStorage(new Product(BANANA, 0, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage));
        Assert.assertEquals(FIRST_OUTPUT_DATA + "\n", storage.toString());
    }

    @Test
    public void storageTestBuyAllFruitsAreOverdue() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        Assert.assertFalse(buy.updateStorage(new Product(BANANA, 10, LocalDate.parse(EIGHTEENTH_OF_OCTOBER)), storage));
        Assert.assertEquals(FIRST_OUTPUT_DATA + "\n", storage.toString());
    }

    @Test
    public void storageTestBuyFromOneBox() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.updateStorage(new Product(BANANA, 10, LocalDate.parse(FIFTEENTH_OF_OCTOBER)), storage));
        Assert.assertEquals("banana,10,2020-10-17" + "\n", storage.toString());
    }

    @Test
    public void storageTestBuyFullBox() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(FIFTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(TENTH_OF_OCTOBER)), storage));
        Assert.assertEquals("", storage.toString());
    }

    @Test
    public void storageTestBuyFromDifferentBox() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(EIGHTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.updateStorage(new Product(BANANA, 40, LocalDate.parse(FIFTEENTH_OF_OCTOBER)), storage));
        Assert.assertEquals("", storage.toString());
    }

    @Test
    public void storageTestBuyFromDifferentBoxWithRemainder() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(TENTH_OF_OCTOBER)), storage);
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(EIGHTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.updateStorage(new Product(BANANA, 40, LocalDate.parse(FIFTEENTH_OF_OCTOBER)), storage));
        Assert.assertEquals("banana,20,2020-10-10" + "\n", storage.toString());
    }
}
