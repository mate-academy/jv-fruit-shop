package core.basesyntax.shop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.shop.db.Storage;
import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.model.Operation;
import core.basesyntax.shop.model.TransactionDto;
import core.basesyntax.shop.strategy.AdditionStrategy;
import core.basesyntax.shop.strategy.OperationStrategy;
import core.basesyntax.shop.strategy.ReductionStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ShopServiceImplTest {
    public static final String DAY_ACTIVITY = "src/test/resources/NormalDayActivity.csv";
    private static List<TransactionDto> expectedTransactionDtos;
    private static ShopService service;

    @BeforeAll
    public static void beforeAll() {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());

        expectedTransactionDtos = new ArrayList<>();
        expectedTransactionDtos.add(new TransactionDto(Operation.BALANCE,
                new Fruit("banana"), 20));
        expectedTransactionDtos.add(new TransactionDto(Operation.BALANCE,
                new Fruit("apple"), 100));
        expectedTransactionDtos.add(new TransactionDto(Operation.SUPPLY,
                new Fruit("banana"), 100));
        expectedTransactionDtos.add(new TransactionDto(Operation.PURCHASE,
                new Fruit("banana"), 13));
        expectedTransactionDtos.add(new TransactionDto(Operation.RETURN,
                new Fruit("apple"), 10));
        expectedTransactionDtos.add(new TransactionDto(Operation.PURCHASE,
                new Fruit("apple"), 20));
        expectedTransactionDtos.add(new TransactionDto(Operation.PURCHASE,
                new Fruit("banana"), 5));
        expectedTransactionDtos.add(new TransactionDto(Operation.SUPPLY,
                new Fruit("banana"), 50));

        service = new ShopServiceImpl(operationStrategyMap);
    }

    @Test
    public void applyOperationOnFruitsDto() {
        Fruit apple = new Fruit("apple");
        Fruit banana = new Fruit("banana");
        service.applyOperationOnFruitsDto(expectedTransactionDtos);
        assertEquals(90, Storage.fruitBalance.get(apple));
        assertEquals(152, Storage.fruitBalance.get(banana));
    }
}
