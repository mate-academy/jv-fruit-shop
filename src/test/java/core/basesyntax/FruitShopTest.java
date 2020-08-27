package core.basesyntax;

import org.junit.Test;

import static org.junit.Assert.*;

public class FruitShopTest {
    private static final String WRONG_DATE_FILE = "src/test/resources/wrongDateFile.csv";
    private static final String WRONG_STOCK = "src/test/resources/wrongStockFile.csv";

    @Test
    public void normalFileTest(){

    }

    @Test (expected = RuntimeException.class)
    public void fileWhichWrongDate(){
        FruitShop fruitShop = new FruitShop(WRONG_DATE_FILE);
        fruitShop.start();
    }

    @Test (expected = RuntimeException.class)
    public void fileWhichWrongStock(){
        FruitShop fruitShop = new FruitShop(WRONG_STOCK);
        fruitShop.start();
    }

}