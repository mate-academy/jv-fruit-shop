package strategy;

import dto.Activities;
import dto.Storage;
import model.CurrentBalance;
import model.Fruit;
import org.junit.Assert;
import org.junit.Test;

public class ReturnStrategyTest {
    private static Fruit bananaFruit = new Fruit("banana");

    @Test
    public void checkAction_Ok() {
        ReturnStrategy returnStrategy = new ReturnStrategy();
        CurrentBalance currentBalance = new CurrentBalance();
        currentBalance.addBalance(bananaFruit, 100);
        returnStrategy.doAction(new Storage(Activities.RETURN, bananaFruit, 30), currentBalance);
        Integer actual = currentBalance.balanceMap.get(bananaFruit);
        Integer expected = 130;
        Assert.assertEquals(expected, actual);
    }
}
