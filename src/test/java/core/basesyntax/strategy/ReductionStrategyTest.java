package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReductionStrategyTest {
    private OperationStrategy reductionStrategy = new ReductionStrategy();
    private TransactionDto transactionDto = new TransactionDto();

    @BeforeClass
    public static void beforeClass() throws Exception {
        Fruit banana = new Fruit();
        banana.setName("banana");
        Storage.fruits.put(banana, 30);
    }

    @Test
    public void correctReductionStrategy() {
        Fruit fruit = new Fruit();
        fruit.setName("banana");
        transactionDto.setQuantity(20);
        transactionDto.setOperation(Operation.PURCHASE);
        transactionDto.setFruit(fruit);
        reductionStrategy.apply(transactionDto);
        int actual = Storage.fruits.get(fruit);
        Assert.assertEquals(10, actual);
        Storage.fruits.clear();
    }

    @Test(expected = RuntimeException.class)
    public void notHaveFruitReductionStrategy() {
        Fruit fruit = new Fruit();
        fruit.setName("apple");
        transactionDto.setQuantity(20);
        transactionDto.setOperation(Operation.PURCHASE);
        transactionDto.setFruit(fruit);
        reductionStrategy.apply(transactionDto);
    }

    @Test(expected = RuntimeException.class)
    public void fewFruitReductionStrategy() {
        Fruit fruit = new Fruit();
        fruit.setName("banana");
        transactionDto.setQuantity(40);
        transactionDto.setOperation(Operation.PURCHASE);
        transactionDto.setFruit(fruit);
        reductionStrategy.apply(transactionDto);
    }
}
