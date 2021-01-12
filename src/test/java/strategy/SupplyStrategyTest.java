package strategy;

import dto.Activities;
import dto.Storage;
import model.CurrentBalance;
import model.Fruit;
import org.junit.Assert;
import org.junit.Test;

public class SupplyStrategyTest {
    private static Fruit bananaFruit = new Fruit("banana");

    @Test
    public void checkAction_Ok() {
        SupplyStrategy supplyStrategy = new SupplyStrategy();
        CurrentBalance currentBalance = new CurrentBalance();
        currentBalance.addBalance(bananaFruit, 100);
        supplyStrategy.doAction(new Storage(Activities.RETURN, bananaFruit, 30), currentBalance);
        Integer actual = currentBalance.balanceMap.get(bananaFruit);
        Integer expected = 130;
        Assert.assertEquals(expected, actual);
    }
}
