package core.basesyntax;

import core.basesyntax.items.Product;
import core.basesyntax.items.Storage;
import core.basesyntax.operations.Buy;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.Supply;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.List;

public class StoreStorageTest {

    public final static String BANANA = "banana";
    public final static Integer TWENTY = 20;
    public final static String SEVENTEENTH_OF_OCTOBER = "2020-10-17";
    public final static String EIGHTEENTH_OF_OCTOBER = "2020-10-18";
    public final static String FIFTEENTH_OF_OCTOBER = "2020-10-15";
    public final static String TENTH_OF_OCTOBER = "2020-10-10";
    public final static String FIRST_OUTPUT_DATA = "banana,20,2020-10-17";

    @Test
    public void storageTest_supply_emptyStorage() {
        Storage storage = new Storage();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        List<String> expected = List.of(FIRST_OUTPUT_DATA
                ,"Total amount:"
                ,"banana,20");
        List<String> actual = List.of(storage.toString().split("\n"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void storageTest_supply_sameFruit_differentDate() {
        Storage storage = new Storage();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(EIGHTEENTH_OF_OCTOBER)), storage);
        List<String> expected = List.of(FIRST_OUTPUT_DATA
                ,"banana,20,2020-10-18"
                ,"Total amount:"
                ,"banana,40");
        List<String> actual = List.of(storage.toString().split("\n"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void storageTest_supply_sameFruit_sameDate() {
        Storage storage = new Storage();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        List<String> expected = List.of("banana,40,2020-10-17"
                ,"Total amount:"
                ,"banana,40");
        List<String> actual = List.of(storage.toString().split("\n"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void storageTest_buy_nonExistedFruit() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Assert.assertFalse(buy.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage));
        Assert.assertEquals("", storage.toString());
    }

    @Test
    public void storageTest_buy_nothing() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.updateStorage(new Product(BANANA, 0, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage));
        List<String> expected = List.of(FIRST_OUTPUT_DATA
                ,"Total amount:"
                ,"banana,20");
        List<String> actual = List.of(storage.toString().split("\n"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void storageTest_buy_allFruitsAreOverdue() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        Assert.assertFalse(buy.updateStorage(new Product(BANANA, 10, LocalDate.parse(EIGHTEENTH_OF_OCTOBER)), storage));
        List<String> expected = List.of(FIRST_OUTPUT_DATA
                ,"Total amount:"
                ,"banana,20");
        List<String> actual = List.of(storage.toString().split("\n"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void storageTest_buy_fromOneBox() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.updateStorage(new Product(BANANA, 10, LocalDate.parse(FIFTEENTH_OF_OCTOBER)), storage));
        List<String> expected = List.of("banana,10,2020-10-17"
                ,"Total amount:"
                ,"banana,10");
        List<String> actual = List.of(storage.toString().split("\n"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void storageTest_buy_fullBox() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(FIFTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(TENTH_OF_OCTOBER)), storage));
        Assert.assertEquals("", storage.toString());
    }

    @Test
    public void storageTest_buy_fromDifferentBox() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(EIGHTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.updateStorage(new Product(BANANA,
                40, LocalDate.parse(FIFTEENTH_OF_OCTOBER)), storage));
        Assert.assertEquals("", storage.toString());
    }

    @Test
    public void storageTest_buy_fromDifferentBox_withRemainder() {
        Storage storage = new Storage();
        Operation buy = new Buy();
        Operation supply = new Supply();
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(TENTH_OF_OCTOBER)), storage);
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(SEVENTEENTH_OF_OCTOBER)), storage);
        supply.updateStorage(new Product(BANANA, TWENTY, LocalDate.parse(EIGHTEENTH_OF_OCTOBER)), storage);
        Assert.assertTrue(buy.updateStorage(new Product(BANANA, 40, LocalDate.parse(FIFTEENTH_OF_OCTOBER)), storage));
        List<String> expected = List.of("banana,20,2020-10-10"
                ,"Total amount:"
                ,"banana,20");
        List<String> actual = List.of(storage.toString().split("\n"));
        Assert.assertEquals(expected, actual);
    }
}
