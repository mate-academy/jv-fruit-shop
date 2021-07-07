package core.basesyntax;

import core.basesyntax.model.Fruit;
import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FruitShopTest {
    private static final String NORMAL_FILE = "src/test/resources/file.csv";
    private static final String WRONG_DATE_FILE = "src/test/resources/wrongDateFile.csv";
    private static final String WRONG_STOCK_FILE = "src/test/resources/wrongStockFile.csv";
    private static final String EMPTY_FILE = "src/test/resources/empty.csv";
    private static final String STOCK = "src/main/resources/stock.csv";
    private static final String STOCK_NORMAL = "src/test/resources/normal.csv";
    private static final String BALANCE_IS_LESS_THAN_BYU ="src/test/resources/lessbalance.csv";

    @Test
    public void normalFileTest() {
        FruitShop fruitShop = new FruitShop(NORMAL_FILE);
        try {
            fruitShop.start();
            BufferedReader shopQuantityFile = new BufferedReader(new FileReader(STOCK));
            BufferedReader preparedFile = new BufferedReader(new FileReader(STOCK_NORMAL));
            Assert.assertEquals("The result of the work does not match the expected", shopQuantityFile.readLine(), preparedFile.readLine());
        } catch (IOException e) {
            throw new RuntimeException("No access to test files");
        }
    }

    @Test(expected = RuntimeException.class)
    public void fileWhichWrongDateTest() {
        FruitShop fruitShop = new FruitShop(WRONG_DATE_FILE);
        fruitShop.start();
    }


    @Test(expected = RuntimeException.class)
    public void setBalanceIsLessThanByuTest() {
        FruitShop fruitShop = new FruitShop(BALANCE_IS_LESS_THAN_BYU);
        fruitShop.start();
    }

    @Test(expected = RuntimeException.class)
    public void fileWhichWrongStock() {
        FruitShop fruitShop = new FruitShop(WRONG_STOCK_FILE);
        fruitShop.start();
    }

    @Test(expected = RuntimeException.class)
    public void fileIsNotFoundTest() {
        FruitShop fruitShop = new FruitShop("bla-bla.xx.f");
        fruitShop.start();
    }

    @Test
    public void fileIsEmptyTest() {
        FruitShop fruitShop = new FruitShop(EMPTY_FILE);
        try {
            fruitShop.start();
            BufferedReader shopQuantityFile = new BufferedReader(new FileReader(STOCK));
            BufferedReader preparedFile = new BufferedReader(new FileReader(STOCK_NORMAL));
            Assert.assertEquals("The result of the work does not match the expected", shopQuantityFile.readLine(), preparedFile.readLine());
        } catch (IOException e) {
            throw new RuntimeException("No access to test files");
        }
    }

    @Test
    public void fruinTest() {
        LocalDate date = LocalDate.now();
        Fruit fruit = new Fruit("banana",50,date);
        Assert.assertEquals(fruit.getType(),"banana");
        Assert.assertTrue("Dates do not match", date.isEqual(fruit.getDate()));
        Assert.assertEquals("Wrong quantity expected 50", 50, fruit.getStockBalance());
    }

    @Test
    public void fruinSetterTest() {
        LocalDate date = LocalDate.now();
        Fruit fruit = new Fruit("banana",50,date);
        fruit.setStock_balance(45);
        Assert.assertEquals("Wrong quantity expected 50", 45, fruit.getStockBalance());
    }

    @Test
    public void fruitEqualsSameObjectTest(){
        LocalDate date = LocalDate.now();
        Fruit fruit = new Fruit("banana",50,date);
        Fruit fruit2 = new Fruit("banana",72,date);
        Assert.assertEquals(fruit, fruit2);
    }

    @Test
    public void fruitEqualsAsHimself(){
        LocalDate date = LocalDate.now();
        Fruit fruit = new Fruit("banana",50,date);
        Assert.assertEquals(fruit, fruit);
    }

    @Test
    public void fruitEqualsAsNull(){
        LocalDate date = LocalDate.now();
        Fruit fruit = new Fruit("banana",50,date);
        Assert.assertNotEquals(fruit, null);
    }

    @Test
    public void fruitEqualsDifferentObjectTest(){
        LocalDate date = LocalDate.now();
        Fruit fruit = new Fruit("apple",50,date);
        Fruit fruit2 = new Fruit("banana",72,date);
        Assert.assertNotEquals(fruit, fruit2);
    }

    @Test
    public void storageTest(){
        Storage storage = new Storage();
        Assert.assertEquals(storage.getFruits(), new ArrayList<>());
    }

    @Test
    public void fruitHashcodeTest(){
        LocalDate date = LocalDate.now();
        Fruit fruit = new Fruit("banana",50,date);
        Fruit fruit2 = new Fruit("banana",72,date);
        Assert.assertEquals(fruit.hashCode(), fruit2.hashCode());
    }

    @Test
    public void fruitCompareToTest(){
        LocalDate date = LocalDate.now();
        LocalDate date1 = date.minusDays(15);
        LocalDate date2 = date.plusDays(15);
        Fruit fruit = new Fruit("banana",50,date);
        Fruit fruit2 = new Fruit("banana",72,date);
        Fruit fruitOlder = new Fruit("banana",72,date2);
        Fruit fruitYanger = new Fruit("banana",72,date1);
        Assert.assertEquals(0, fruit.compareTo(fruit2));
        Assert.assertEquals(-1, fruit.compareTo(fruitOlder));
        Assert.assertEquals(1, fruit.compareTo(fruitYanger));
    }
}
