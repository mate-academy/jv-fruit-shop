package strategy;

import dto.Activities;
import dto.Storage;
import model.CurrentBalance;
import model.Fruit;
import org.junit.Assert;
import org.junit.Test;

public class BalanceStrategyTest {
    private static Fruit bananaFruit = new Fruit("banana");

    @Test
    public void checkAction_Ok() {
        BalanceStrategy balanceStrategy = new BalanceStrategy();
        CurrentBalance currentBalance = new CurrentBalance();
        balanceStrategy.doAction(new Storage(Activities.BALANCE, bananaFruit, 100), currentBalance);
        Integer actual = currentBalance.balanceMap.get(bananaFruit);
        Integer expected = 100;
        Assert.assertEquals(expected, actual);
    }
}
