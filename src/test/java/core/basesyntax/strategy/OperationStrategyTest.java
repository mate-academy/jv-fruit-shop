package core.basesyntax.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class OperationStrategyTest {
    private static OperationStrategy additionStrategy;
    private static OperationStrategy reductionStrategy;

    @BeforeClass
    public static void beforeClass() throws Exception {
        additionStrategy = new AdditionStrategy();
        reductionStrategy = new ReductionStrategy();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        Storage.fruits.clear();
    }

    @Test
    public void additionStrategy_Ok() {
        Map<Fruit, Integer> expect = new HashMap<>();
        expect.put(new Fruit("banana"), 80);
        TransactionDto dto = new TransactionDto(Operation.fromString("b"), new Fruit("banana"), 20);
        Integer amount = Optional.ofNullable(Storage.fruits.get(dto.getFruit())).orElse(0);
        Storage.fruits.put(dto.getFruit(), amount + dto.getQuantity());
        additionStrategy.apply(dto);
        assertEquals(expect, Storage.fruits);
    }

    @Test
    public void additionStrategy_NotOk() {
        Map<Fruit, Integer> expect = new HashMap<>();
        expect.put(new Fruit("banana"), 10);
        TransactionDto dto = new TransactionDto(Operation.fromString("b"), new Fruit("banana"), 20);
        Integer amount = Optional.ofNullable(Storage.fruits.get(dto.getFruit())).orElse(0);
        Storage.fruits.put(dto.getFruit(), amount + dto.getQuantity());
        additionStrategy.apply(dto);
        assertNotEquals(expect, Storage.fruits);
    }

    @Test
    public void reductionStrategy_Ok() {
        Map<Fruit, Integer> expect = new HashMap<>();
        expect.put(new Fruit("banana"), 40);
        TransactionDto dto = new TransactionDto(Operation.fromString("p"), new Fruit("banana"), 30);
        int newAmount = 100 - dto.getQuantity();
        Storage.fruits.put(dto.getFruit(), newAmount);
        reductionStrategy.apply(dto);
        assertEquals(expect, Storage.fruits);
    }

    @Test
    public void reductionStrategy_NotOk() {
        Map<Fruit, Integer> expect = new HashMap<>();
        expect.put(new Fruit("banana"), 10);
        TransactionDto dto = new TransactionDto(Operation.fromString("p"), new Fruit("banana"), 30);
        int newAmount = 100 - dto.getQuantity();
        Storage.fruits.put(dto.getFruit(), newAmount);
        reductionStrategy.apply(dto);
        assertNotEquals(expect, Storage.fruits);
    }

    @Test(expected = RuntimeException.class)
    public void reductionStrategyException_NotOk() {
        TransactionDto dto = new TransactionDto(Operation.fromString("p"), new Fruit("banana"), 30);
        int newAmount = 10 - dto.getQuantity();
        Storage.fruits.put(dto.getFruit(), newAmount);
        reductionStrategy.apply(dto);
    }
}
