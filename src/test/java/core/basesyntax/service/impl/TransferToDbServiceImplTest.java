package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.service.TransferToDbService;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceProcessor;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseProcessor;
import core.basesyntax.strategy.impl.ReturnProcessor;
import core.basesyntax.strategy.impl.SupplyProcessor;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("TransferToDbImplTest")
class TransferToDbServiceImplTest {
    private static final OperationStrategy STRATEGY = new OperationStrategyImpl(Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceProcessor(new ProductDaoImpl()),
            FruitTransaction.Operation.SUPPLY, new SupplyProcessor(new ProductDaoImpl()),
            FruitTransaction.Operation.PURCHASE, new PurchaseProcessor(new ProductDaoImpl()),
            FruitTransaction.Operation.RETURN, new ReturnProcessor(new ProductDaoImpl())));
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
    void transfer_transferToDb_ok() {
        List<FruitTransaction> transactions = List.of(
                new FruitTransaction(BALANCE, BANANA, 20),
                new FruitTransaction(SUPPLY, BANANA, 20),
                new FruitTransaction(RETURN, BANANA, 10),
                new FruitTransaction(PURCHASE, BANANA, 30),
                new FruitTransaction(BALANCE, APPLE, 20),
                new FruitTransaction(SUPPLY, APPLE, 20),
                new FruitTransaction(RETURN, APPLE, 10),
                new FruitTransaction(PURCHASE, APPLE, 30));
        TransferToDbService transfer = new TransferToDbServiceImpl(STRATEGY);
        transfer.transfer(transactions);
        Map<Product, Integer> expected = Map.of(BANANA, 20, APPLE, 20);
        Map<Product, Integer> actual = Map.of(BANANA, DAO.get(BANANA), APPLE, DAO.get(APPLE));
        assertEquals(expected, actual);
    }
}
