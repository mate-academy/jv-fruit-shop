package core.basesyntax.service;

import core.basesyntax.*;
import org.junit.After;
import org.junit.BeforeClass;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateFruitStorageServiceTest {
    static UpdateFruitStorageService updateService;
    static List<AbstractTransaction> transactions = new ArrayList<>();
    static List<AbstractTransaction> empty_list = new ArrayList<>();

    @BeforeClass
    public static void setUp() {
        updateService = new UpdateFruitStorageService();
        AbstractTransaction supplyTransaction = new SupplyTransaction();
        AbstractTransaction buyTransaction = new BuyTransaction();
        AbstractTransaction returnTransaction = new ReturnTransaction();
        supplyTransaction.setFruitType("banana");
        supplyTransaction.setDate(LocalDate.of(2020, 11, 01));
        supplyTransaction.setQuantity(100);
        buyTransaction.setFruitType("banana");
        buyTransaction.setDate(LocalDate.of(2020, 10, 10));
        buyTransaction.setQuantity(15);
        returnTransaction.setFruitType("banana");
        returnTransaction.setDate(LocalDate.of(2020, 11, 01));
        returnTransaction.setQuantity(2);
        transactions.add(supplyTransaction);
        transactions.add(buyTransaction);
        transactions.add(returnTransaction);
    }

    @After
    public void clearStock() {
        FruitStorage.clearStock();
    }

    @Test
    public void updateStock_correctWork() {
        Map<FruitBatch, Integer> expectedResult = new HashMap<>();
        expectedResult.put(new FruitBatch("banana", LocalDate.of(2020, 11,
                01)), 87);
        updateService.updateStock(transactions);
        Map<FruitBatch, Integer> actualResult = FruitStorage.getFruits();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void changeStock_emptyList() {
        updateService.updateStock(empty_list);
        Map<FruitBatch, Integer> expectedResult = new HashMap<>();
        Map<FruitBatch, Integer> actualResult = FruitStorage.getFruits();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
