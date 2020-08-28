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

    @Test
    public void normalFileTest() {
        FruitShop fruitShop = new FruitShop(NORMAL_FILE);
        try {
            fruitShop.start();
            BufferedReader shopQuantityFile = new BufferedReader(new FileReader(STOCK));
            BufferedReader preparedFile = new BufferedReader(new FileReader(STOCK_NORMAL));
            Assert.assertEquals("Результат работы не совпадает с ожидаемым", shopQuantityFile.readLine(), preparedFile.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Нет доступа к тестовым файлам");
        }

    }

    @Test(expected = RuntimeException.class)
    public void fileWhichWrongDate() {
        FruitShop fruitShop = new FruitShop(WRONG_DATE_FILE);
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
            Assert.assertEquals("Результат работы не совпадает с ожидаемым", shopQuantityFile.readLine(), preparedFile.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Нет доступа к тестовым файлам");
        }
    }

    @Test
    public void fruinTest() {
        LocalDate date = LocalDate.now();
        Fruit fruit = new Fruit("banana",50,date);
        Assert.assertEquals(fruit.getType(),"banana");
        Assert.assertTrue("Даты не совпадаеют", date.isEqual(fruit.getDate()));
        Assert.assertEquals("Неправильное количество ожидалось 50", 50, fruit.getStock_balance());
    }

    @Test
    public void fruinSetterTest() {
        LocalDate date = LocalDate.now();
        Fruit fruit = new Fruit("banana",50,date);
        fruit.setStock_balance(45);
        Assert.assertEquals("Неправильное количество ожидалось 50", 45, fruit.getStock_balance());
    }

    @Test
    public void fruitEqualsTest(){
        LocalDate date = LocalDate.now();
        Fruit fruit = new Fruit("banana",50,date);
        Fruit fruit2 = new Fruit("banana",72,date);
        Assert.assertTrue(fruit.equals(fruit2));
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
        Assert.assertTrue(fruit.hashCode()== fruit2.hashCode());
    }

    @Test
    public void fruitCompareToTest(){
        LocalDate date = LocalDate.now();
        Fruit fruit = new Fruit("banana",50,date);
        Fruit fruit2 = new Fruit("banana",72,date);
        Assert.assertTrue(fruit.compareTo(fruit2)==0);
    }
}