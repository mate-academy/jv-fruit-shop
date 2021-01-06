package core.basesyntax.service.impl.servicetest;

import static org.junit.Assert.assertEquals;

import core.basesyntax.basesyntaxdb.Storage;
import core.basesyntax.exception.OverBuyException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceImplTest {
    private static FruitService fruitService;

    @BeforeClass
    public static void beforeAll() {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new BalanceStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        operationStrategyMap.put(Operation.RETURN, new ReturnStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        fruitService = new FruitServiceImpl(operationStrategyMap);
    }

    @Test
    public void applyOperation_Ok() {
        TransactionDto firstTestTransaction = new TransactionDto();
        firstTestTransaction.setOperation(Operation.BALANCE);
        firstTestTransaction.setFruit(new Fruit("apple"));
        firstTestTransaction.setQuantity(100);

        TransactionDto secondTestTransaction = new TransactionDto();
        secondTestTransaction.setOperation(Operation.SUPPLY);
        secondTestTransaction.setFruit(new Fruit("apple"));
        secondTestTransaction.setQuantity(100);

        TransactionDto thirdTestTransaction = new TransactionDto();
        thirdTestTransaction.setOperation(Operation.PURCHASE);
        thirdTestTransaction.setFruit(new Fruit("apple"));
        thirdTestTransaction.setQuantity(100);

        TransactionDto fourthTestTransaction = new TransactionDto();
        fourthTestTransaction.setOperation(Operation.RETURN);
        fourthTestTransaction.setFruit(new Fruit("apple"));
        fourthTestTransaction.setQuantity(100);

        fruitService.applyOperationOnFruitDto(List.of(firstTestTransaction,
                secondTestTransaction, thirdTestTransaction, fourthTestTransaction
        ));
        assertEquals(200, Storage.fruitList.size());
    }

    @Before
    public void clearStorage() {
        Storage.fruitList.clear();
    }

    @Test(expected = OverBuyException.class)
    public void applyOperation_NotOk() {
        TransactionDto firstTestTransaction = new TransactionDto();
        firstTestTransaction.setOperation(Operation.BALANCE);
        firstTestTransaction.setFruit(new Fruit("apple"));
        firstTestTransaction.setQuantity(100);
        fruitService.applyOperationOnFruitDto(List.of(firstTestTransaction));
        TransactionDto secondTestTransaction = new TransactionDto();
        secondTestTransaction.setOperation(Operation.PURCHASE);
        secondTestTransaction.setFruit(new Fruit("apple"));
        secondTestTransaction.setQuantity(1000);
        fruitService.applyOperationOnFruitDto(List.of(
                secondTestTransaction));
    }

    @Test
    public void getFruitReport_twoValue_ok() {
        Storage.fruitList.add(new Fruit("banana"));
        Storage.fruitList.add(new Fruit("apple"));
        assertEquals(2, fruitService.getDefaultReport().size());
    }
}
