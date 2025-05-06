package service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import db.Storage;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ShopService;
import strategy.BalanceOperation;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

class ShopServiceImplTest {
    private ShopService shopService;

    @BeforeEach
    void setUp() {
        shopService = new ShopServiceImpl(new OperationStrategyImpl(Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperation(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
                FruitTransaction.Operation.RETURN, new ReturnOperation(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation())));
        Storage.storage.clear();
    }

    @AfterEach
    void tearDown() {
        Storage.storage.clear();
    }

    @Test
    void successTransaction_correctToUpdateStorage_Ok() {
        List<FruitTransaction> fruitTransactions = List.of(
                new FruitTransaction(FruitTransaction.Operation.BALANCE, "apple", 100),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "apple", 10),
                new FruitTransaction(FruitTransaction.Operation.SUPPLY, "apple", 20),
                new FruitTransaction(FruitTransaction.Operation.RETURN, "apple", 5));
        shopService.process(fruitTransactions);
        assertEquals(115, Storage.storage.get("apple"));
    }

    @Test
    void successTransaction_correctEmptyStorage_Ok() {
        shopService.process(List.of());
        assertEquals(0, Storage.storage.size());
    }
}
