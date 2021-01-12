package servise;

import dto.Activities;
import dto.Storage;
import exception.FruitShopException;
import java.util.Arrays;
import java.util.List;
import model.Fruit;
import org.junit.Assert;
import org.junit.Test;

public class ParserImplTest {
    private static Fruit bananaFruit = new Fruit("banana");

    @Test(expected = FruitShopException.class)
    public void wrongFirstLine_NotOk() {
        List<String> stringsFromFile = Arrays.asList("b,banana,20", "b,apple,100");
        new ParserImpl().parse(stringsFromFile);
    }

    @Test(expected = FruitShopException.class)
    public void negativeQuantity_NotOk() {
        List<String> stringsFromFile = Arrays.asList("type,fruit,quantity", "b,banana,-20");
        new ParserImpl().parse(stringsFromFile);
    }

    @Test
    public void checkBalanceCase_Ok() {
        List<String> stringsFromFile = Arrays.asList("type,fruit,quantity", "b,banana,20");
        List<Storage> actual = new ParserImpl().parse(stringsFromFile);
        List<Storage> expected = Arrays.asList(
                new Storage(Activities.BALANCE, bananaFruit, 20));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPurchaseCase_Ok() {
        List<String> stringsFromFile = Arrays.asList(
                "type,fruit,quantity", "b,banana,20", "p,banana,7");
        List<Storage> actual = new ParserImpl().parse(stringsFromFile);
        List<Storage> expected = Arrays.asList(
                new Storage(Activities.BALANCE, bananaFruit, 20),
                new Storage(Activities.PURCHASE, bananaFruit, 7));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkReturnCase_Ok() {
        List<String> stringsFromFile = Arrays.asList(
                "type,fruit,quantity", "b,banana,20", "r,banana,7");
        List<Storage> actual = new ParserImpl().parse(stringsFromFile);
        List<Storage> expected = Arrays.asList(
                new Storage(Activities.BALANCE, bananaFruit, 20),
                new Storage(Activities.RETURN, bananaFruit, 7));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkSupplyCase_Ok() {
        List<String> stringsFromFile = Arrays.asList(
                "type,fruit,quantity", "b,banana,20", "s,banana,7");
        List<Storage> actual = new ParserImpl().parse(stringsFromFile);
        List<Storage> expected = Arrays.asList(
                new Storage(Activities.BALANCE, bananaFruit, 20),
                new Storage(Activities.SUPPLY, bananaFruit, 7));
        Assert.assertEquals(expected, actual);
    }
}
