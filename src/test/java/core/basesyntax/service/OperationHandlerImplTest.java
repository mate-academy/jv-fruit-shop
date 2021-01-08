package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.AdditionStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.SubtractionStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationHandlerImplTest {
    OperationHandler handler;

    @BeforeEach
    public void setUp() {
        Map<Operation, OperationStrategy> strategyMap = new HashMap<>();
        strategyMap.put(Operation.BALANCE, new AdditionStrategy());
        strategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        strategyMap.put(Operation.PURCHASE, new SubtractionStrategy());
        strategyMap.put(Operation.RETURN, new AdditionStrategy());
        handler = new OperationHandlerImpl(strategyMap);
        Storage.fruits.clear();

    }

    @Test
    public void handleBalanceEmpty() {
        Integer expected = 20;
        TransactionDto dto = new TransactionDto(Operation.BALANCE, new Fruit("banana"), 20);
        List<TransactionDto> list = new ArrayList<>();
        list.add(dto);
        handler.executeTransaction(list);
        Assertions.assertEquals(expected, Storage.fruits.get(new Fruit("banana")));
    }

    @Test
    public void handleSupplyEmpty() {
        Integer expected = 20;
        TransactionDto dto = new TransactionDto(Operation.SUPPLY, new Fruit("banana"), 20);
        List<TransactionDto> list = new ArrayList<>();
        list.add(dto);
        handler.executeTransaction(list);
        Assertions.assertEquals(expected, Storage.fruits.get(new Fruit("banana")));
    }

    @Test
    public void handleSupplyNotEmpty() {
        Storage.fruits.put(new Fruit("banana"), 40);
        Integer expected = 60;
        TransactionDto dto = new TransactionDto(Operation.SUPPLY, new Fruit("banana"), 20);
        List<TransactionDto> list = new ArrayList<>();

        list.add(dto);
        handler.executeTransaction(list);
        Assertions.assertEquals(expected, Storage.fruits.get(new Fruit("banana")));
    }

    @Test
    public void handleReturnEmpty() {
        Integer expected = 20;
        TransactionDto dto = new TransactionDto(Operation.RETURN, new Fruit("banana"), 20);
        List<TransactionDto> list = new ArrayList<>();
        list.add(dto);
        handler.executeTransaction(list);
        Assertions.assertEquals(expected, Storage.fruits.get(new Fruit("banana")));
    }

    @Test
    public void handleReturnNotEmpty() {
        Storage.fruits.put(new Fruit("banana"), 40);
        Integer expected = 60;
        TransactionDto dto = new TransactionDto(Operation.RETURN, new Fruit("banana"), 20);
        List<TransactionDto> list = new ArrayList<>();

        list.add(dto);
        handler.executeTransaction(list);
        Assertions.assertEquals(expected, Storage.fruits.get(new Fruit("banana")));
    }

    @Test
    public void handleReturnPurchase() {
        Storage.fruits.put(new Fruit("banana"), 40);
        Integer expected = 20;
        TransactionDto dto = new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 20);
        List<TransactionDto> list = new ArrayList<>();

        list.add(dto);
        handler.executeTransaction(list);
        Assertions.assertEquals(expected, Storage.fruits.get(new Fruit("banana")));
    }
}
