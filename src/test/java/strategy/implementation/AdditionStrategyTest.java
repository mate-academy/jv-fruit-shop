package strategy.implementation;

import db.FruitStorage;
import model.Fruit;
import model.FruitTransactionDto;
import model.Operation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdditionStrategyTest {
    private static AdditionStrategy additionStrategy;
    private static FruitTransactionDto papayaDto;
    private static FruitTransactionDto durianDto;

    @BeforeClass
    public static void beforeClass() {
        additionStrategy = new AdditionStrategy();
        papayaDto = new FruitTransactionDto(Operation.BALANCE,
                new Fruit("papaya"), 200);
        durianDto = new FruitTransactionDto(Operation.SUPPLY,
                new Fruit("durian"), 100);
    }

    @Test
    public void applyAdditionStrategy_Ok() {
        additionStrategy.apply(papayaDto);
        additionStrategy.apply(durianDto);
        int papayaAmount = FruitStorage.fruitStorage.get(papayaDto.getFruit());
        int durianAmount = FruitStorage.fruitStorage.get(durianDto.getFruit());
        Assert.assertEquals(200, papayaAmount);
        Assert.assertEquals(100, durianAmount);
    }
}
