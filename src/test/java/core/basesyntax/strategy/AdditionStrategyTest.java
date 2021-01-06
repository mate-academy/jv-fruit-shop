package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdditionStrategyTest {
    private final OperationStrategy strategy = new AdditionStrategy();
    private final TransactionDto transactionDto = new TransactionDto();

    @BeforeClass
    public static void beforeClass() throws Exception {
        Fruit banana = new Fruit();
        banana.setName("banana");
        Storage.fruits.put(banana, 30);
    }

    @Test
    public void correctAdditionStrategy() {
        Fruit fruit = new Fruit();
        fruit.setName("banana");
        transactionDto.setQuantity(20);
        transactionDto.setOperation(Operation.PURCHASE);
        transactionDto.setFruit(fruit);
        strategy.apply(transactionDto);
        int actual = Storage.fruits.get(fruit);
        Assert.assertEquals(50, actual);
        Storage.fruits.clear();
    }

    @Test
    public void addNewFruitAdditionStrategy() {
        Fruit fruit = new Fruit();
        fruit.setName("apple");
        transactionDto.setQuantity(20);
        transactionDto.setOperation(Operation.PURCHASE);
        transactionDto.setFruit(fruit);
        strategy.apply(transactionDto);
        int actualApple = Storage.fruits.get(fruit);
        Assert.assertEquals(20, actualApple);
        Storage.fruits.clear();
    }
}
