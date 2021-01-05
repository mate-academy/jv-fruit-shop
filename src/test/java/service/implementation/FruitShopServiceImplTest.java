package service.implementation;

import db.FruitStorage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruit;
import model.FruitTransactionDto;
import model.Operation;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.DataReader;
import service.FruitShopService;
import strategy.OperationStrategy;
import strategy.implementation.AdditionStrategy;
import strategy.implementation.ReductionStrategy;

public class FruitShopServiceImplTest {
    private static final String VALID_INPUT_CSV = "src/test/resources/valid_input.csv";
    private static final DataReader dataReader = new CsvDataReaderImpl();
    private static Fruit papaya;
    private static Fruit durian;
    private static FruitShopService fruitShopService;
    private static List<FruitTransactionDto> transactionDtos;
    Map<Fruit, Integer> expectedFruitMap;

    @Before
    public void setUp() {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());
        fruitShopService = new FruitShopServiceImpl(operationStrategyMap);
        transactionDtos = new ArrayList<>(dataReader.readFromFile(VALID_INPUT_CSV));
        expectedFruitMap = new HashMap<>();
        papaya = new Fruit("papaya");
        durian = new Fruit("durian");
    }

    @Test
    public void applyDifferentOperations_Ok() {
        fruitShopService.applyOperationsOnFruitsDto(transactionDtos);
        Assert.assertEquals(213, (FruitStorage.getFruitStorage().get(papaya).intValue()));
        Assert.assertEquals(108, (FruitStorage.getFruitStorage().get(durian).intValue()));
    }

    @Test
    public void getFruitReport_Ok() {
        FruitStorage.fruitStorage.put(papaya, 213);
        FruitStorage.fruitStorage.put(durian, 108);
        expectedFruitMap.put(papaya, 213);
        expectedFruitMap.put(durian, 108);
        Assert.assertEquals(expectedFruitMap, FruitStorage.getFruitStorage());
    }

    @AfterClass
    public static void afterClass() {
        FruitStorage.fruitStorage.clear();
    }
}
