package servise;

import dto.Activities;
import dto.Storage;
import exception.FruitShopException;
import java.util.Arrays;
import java.util.List;
import model.CurrentBalance;
import model.Fruit;
import org.junit.Assert;
import org.junit.Test;

public class ActivitiesHandlerTest {
    private static Fruit bananaFruit = new Fruit("banana");

    @Test
    public void checkBalanceCase_Ok() {
        ActivitiesHandler activitiesHandler = new ActivitiesHandler();
        CurrentBalance currentBalance = new CurrentBalance();
        List<Storage> storagesList = Arrays.asList(
                new Storage(Activities.BALANCE, bananaFruit, 100));
        activitiesHandler.handle(storagesList, currentBalance);
        Integer actual = currentBalance.balanceMap.get(bananaFruit);
        Integer expected = 100;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPurchaseCase_Ok() {
        ActivitiesHandler activitiesHandler = new ActivitiesHandler();
        CurrentBalance currentBalance = new CurrentBalance();
        List<Storage> storagesList = Arrays.asList(
                new Storage(Activities.BALANCE, bananaFruit, 100),
                new Storage(Activities.PURCHASE, bananaFruit, 30));
        activitiesHandler.handle(storagesList, currentBalance);
        Integer actual = currentBalance.balanceMap.get(bananaFruit);
        Integer expected = 70;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkReturnCase_Ok() {
        ActivitiesHandler activitiesHandler = new ActivitiesHandler();
        CurrentBalance currentBalance = new CurrentBalance();
        List<Storage> storagesList = Arrays.asList(
                new Storage(Activities.BALANCE, bananaFruit, 100),
                new Storage(Activities.RETURN, bananaFruit, 30));
        activitiesHandler.handle(storagesList, currentBalance);
        Integer actual = currentBalance.balanceMap.get(bananaFruit);
        Integer expected = 130;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkSupplyCase_Ok() {
        ActivitiesHandler activitiesHandler = new ActivitiesHandler();
        CurrentBalance currentBalance = new CurrentBalance();
        List<Storage> storagesList = Arrays.asList(
                new Storage(Activities.BALANCE, bananaFruit, 100),
                new Storage(Activities.SUPPLY, bananaFruit, 30));
        activitiesHandler.handle(storagesList, currentBalance);
        Integer actual = currentBalance.balanceMap.get(bananaFruit);
        Integer expected = 130;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = FruitShopException.class)
    public void balanceLineInTheMiddleOfTheFile_NotOk() {
        ActivitiesHandler activitiesHandler = new ActivitiesHandler();
        CurrentBalance currentBalance = new CurrentBalance();
        List<Storage> storagesList = Arrays.asList(
                new Storage(Activities.BALANCE, bananaFruit, 100),
                new Storage(Activities.SUPPLY, bananaFruit, 30),
                new Storage(Activities.BALANCE, bananaFruit, 200));
        activitiesHandler.handle(storagesList, currentBalance);
    }
}
