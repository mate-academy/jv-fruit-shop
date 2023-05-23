package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.service.TransferToDb;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class TransferToDbImplTest {
    private static final OperationStrategy STRATEGY = new OperationStrategyImpl();
    private static final ProductDao<Product, Integer> DAO = new ProductDaoImpl();
    private static final Product BANANA = Product.BANANA;
    private static final Product APPLE = Product.APPLE;
    public static final FruitTransaction.Operation BALANCE = FruitTransaction.Operation.BALANCE;
    public static final FruitTransaction.Operation SUPPLY = FruitTransaction.Operation.SUPPLY;
    public static final FruitTransaction.Operation RETURN = FruitTransaction.Operation.RETURN;
    public static final FruitTransaction.Operation PURCHASE = FruitTransaction.Operation.PURCHASE;

    @AfterEach
    void tearDown() {
        DAO.clear();
    }

    @DisplayName("Test transfer to DB")
    @Order(1)
    @Test
    void transfer_transfer() {
        List<FruitTransaction> transactions = List.of(
                new FruitTransaction(BALANCE, BANANA, 20),
                new FruitTransaction(SUPPLY, BANANA, 20),
                new FruitTransaction(RETURN, BANANA, 10),
                new FruitTransaction(PURCHASE, BANANA, 30),
                new FruitTransaction(BALANCE, APPLE, 20),
                new FruitTransaction(SUPPLY, APPLE, 20),
                new FruitTransaction(RETURN, APPLE, 10),
                new FruitTransaction(PURCHASE, APPLE, 30));
        TransferToDb transfer = new TransferToDbImpl(STRATEGY);
        transfer.transfer(transactions);
        Map<Product, Integer> expected = Map.of(BANANA, 20, APPLE, 20);
        Map<Product, Integer> actual = Map.of(BANANA, DAO.get(BANANA), APPLE, DAO.get(APPLE));
        assertEquals(expected, actual);
    }
}
