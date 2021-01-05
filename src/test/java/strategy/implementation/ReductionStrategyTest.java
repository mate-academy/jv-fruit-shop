package strategy.implementation;

import db.FruitStorage;
import exception.NegativeBalanceException;
import exception.NoSuchFruitException;
import model.Fruit;
import model.FruitTransactionDto;
import model.Operation;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReductionStrategyTest {
    private static ReductionStrategy reductionStrategy;
    private static FruitTransactionDto papayaDto;
    private static FruitTransactionDto durianDto;
    private static FruitTransactionDto amountMoreThanBalancePapaya;
    private static FruitTransactionDto invalidFruit;

    @BeforeClass
    public static void beforeClass() {
        reductionStrategy = new ReductionStrategy();
        FruitStorage.fruitStorage.put(new Fruit("papaya"), 100);
        FruitStorage.fruitStorage.put(new Fruit("durian"), 50);
        papayaDto = new FruitTransactionDto(Operation.PURCHASE,
                new Fruit("papaya"), 20);
        durianDto = new FruitTransactionDto(Operation.PURCHASE,
                new Fruit("durian"), 10);
        amountMoreThanBalancePapaya = new FruitTransactionDto(Operation.PURCHASE,
                papayaDto.getFruit(), 200);
        invalidFruit = new FruitTransactionDto(Operation.PURCHASE,new Fruit("apple"), 10);
    }

    @Test
    public void applyReductionStrategy_Ok() {
        reductionStrategy.apply(papayaDto);
        reductionStrategy.apply(durianDto);
        int papayaAmount = FruitStorage.fruitStorage.get(papayaDto.getFruit());
        int durianAmount = FruitStorage.fruitStorage.get(durianDto.getFruit());
        Assert.assertEquals(80, papayaAmount);
        Assert.assertEquals(40, durianAmount);
    }

    @Test(expected = NegativeBalanceException.class)
    public void applyReductionStrategy_NotOk() {
        reductionStrategy.apply(amountMoreThanBalancePapaya);
    }

    @Test(expected = NoSuchFruitException.class)
    public void applyReductionInvalid_Fruit_Ok() {
        reductionStrategy.apply(invalidFruit);
    }

    @AfterClass
    public static void afterClass() {
        FruitStorage.fruitStorage.clear();
    }
}
