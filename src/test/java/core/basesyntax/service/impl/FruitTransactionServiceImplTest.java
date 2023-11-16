package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.dao.impl.TransactionDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.strategy.FruitResolver;
import core.basesyntax.service.strategy.OperationResolver;
import core.basesyntax.service.strategy.impl.FruitResolverImpl;
import core.basesyntax.service.strategy.impl.OperationResolverImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FruitTransactionServiceImplTest {
    private static TransactionDao fruitTranslationDAO;
    private static TransactionServiceImpl fruitTransactionService;
    private static TransactionDao translationDao;
    private static OperationResolver operationResolver;
    private static FruitResolver fruitResolver;
    private static Map<String, Operation> operationMap = new HashMap<>();
    private static Map<String, Fruit> fruitMap = new HashMap<>();

    private FruitTransaction fruitBalance;
    private FruitTransaction fruitSupplier;
    private FruitTransaction fruitReturn;
    private FruitTransaction fruitPur;

    @BeforeAll
    static void beforeAll() {
        fruitTranslationDAO = new TransactionDaoImpl();
        translationDao = new TransactionDaoImpl();
        operationResolver = new OperationResolverImpl(operationMap);
        fruitResolver = new FruitResolverImpl(fruitMap);
        fruitTransactionService =
                new TransactionServiceImpl(translationDao, operationResolver, fruitResolver);
    }

    @BeforeEach
    void setUp() {
        fruitBalance = new FruitTransaction(Operation.BALANCE, Fruit.BANANA, 20);
        fruitSupplier = new FruitTransaction(Operation.SUPPLY, Fruit.BANANA, 30);
        fruitReturn = new FruitTransaction(Operation.RETURN, Fruit.BANANA, 15);
        fruitPur = new FruitTransaction(Operation.PURCHASE, Fruit.BANANA, 10);
        fruitTranslationDAO.add(fruitBalance);
        fruitTranslationDAO.add(fruitSupplier);
        fruitTranslationDAO.add(fruitReturn);
        fruitTranslationDAO.add(fruitPur);

        fruitMap.put("banana", Fruit.BANANA);
        fruitMap.put("apple", Fruit.APPLE);

        operationMap.put("b", Operation.BALANCE);
        operationMap.put("s", Operation.SUPPLY);
        operationMap.put("p", Operation.PURCHASE);
        operationMap.put("r", Operation.RETURN);
    }

    @Test
    void createNewTransaction_create_Ok() {
        String str = "b,banana,20";
        FruitTransaction actual = fruitTransactionService.createInstance(str);
        fruitTransactionService.createNewTransaction(actual);

        assertEquals(fruitBalance, actual);
    }

    @Test
    void createNewTransaction_OperationWrong_NotOk() {
    }

    @Test
    void createNewTransaction_OperationNullOrEmpty_NotOk() {
    }

    @Test
    void createNewTransaction_FruitWrong_NotOk() {
    }

    @Test
    void createNewTransaction_FruitNullOrEmpty_NotOk() {
    }

    @Test
    void createNewTransaction_QuantityNegative_NotOk() {
    }

    @Test
    void createNewTransaction_QuantityAsStringNullOrEmpty_Ok() {
    }

    @Test
    void findTranslationByOperationAndFruit_WillBe_Ok() {
        FruitTransaction fruitActual = fruitTransactionService
                .findTransactionByOperationAndFruit(fruitBalance);
        assertEquals(fruitBalance, fruitActual);
    }

    @Test
    void findTranslationByOperationAndFruit_NotFoundElement_NotOk() {
    }

    @Test
    void updateTransaction_Ok() {
        FruitTransaction fruitTransaction =
                new FruitTransaction(Operation.SUPPLY, Fruit.BANANA, 30);
        int expected = fruitTransaction.getQuantity() + fruitSupplier.getQuantity();
        fruitTransactionService.updateTransaction(fruitTransaction);
        FruitTransaction fruitActual =
                fruitTransactionService.findTransactionByOperationAndFruit(fruitTransaction);
        assertEquals(expected, fruitActual.getQuantity());
    }

    @Test
    void updateTransaction_removeOldElement_Ok() {
        List<FruitTransaction> allFruit = fruitTranslationDAO.getAll();
        FruitTransaction fruitTransaction =
                new FruitTransaction(Operation.SUPPLY, Fruit.BANANA, 30);
        fruitTransactionService.updateTransaction(fruitTransaction);
        List<FruitTransaction> allFruitActual = fruitTranslationDAO.getAll();
        assertEquals(allFruitActual.size(), allFruit.size());
    }
}
