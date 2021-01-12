package strategy;

import dto.Activities;
import dto.Storage;
import exception.FruitShopException;
import model.CurrentBalance;
import model.Fruit;
import org.junit.Assert;
import org.junit.Test;

public class PurchaseStrategyTest {
    private static Fruit bananaFruit = new Fruit("banana");

    @Test
    public void checkAction_Ok() {
        PurchaseStrategy purchaseStrategy = new PurchaseStrategy();
        CurrentBalance currentBalance = new CurrentBalance();
        currentBalance.addBalance(bananaFruit, 100);
        purchaseStrategy.doAction(new Storage(
                Activities.PURCHASE, bananaFruit, 30), currentBalance);
        Integer actual = currentBalance.balanceMap.get(bananaFruit);
        Integer expected = 70;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = FruitShopException.class)
    public void notEnoughBalanceCheck_NotOk() {
        PurchaseStrategy purchaseStrategy = new PurchaseStrategy();
        CurrentBalance currentBalance = new CurrentBalance();
        currentBalance.addBalance(bananaFruit, 1);
        purchaseStrategy.doAction(new Storage(
                Activities.PURCHASE, bananaFruit, 30), currentBalance);
    }
}
