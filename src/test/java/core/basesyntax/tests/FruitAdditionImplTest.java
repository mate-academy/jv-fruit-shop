package core.basesyntax.tests;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operations;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationWithFruits;
import core.basesyntax.service.impl.FruitsAdditionImpl;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitAdditionImplTest {
    private static OperationWithFruits operation;
    private static Transaction bananaTransaction;
    private static Transaction kiwiTransaction;
    private static Transaction appleTransaction;

    @BeforeClass
    public static void beforeClass() {
        operation = new FruitsAdditionImpl();
        bananaTransaction = new Transaction(Operations.BALANCE, new Fruit("banana"), 10);
        kiwiTransaction = new Transaction(Operations.SUPPLY, new Fruit("kiwi"), 20);
        appleTransaction = new Transaction(Operations.RETURN, new Fruit("apple"), 30);
    }

    @Test
    public void makeFruitAddition() {
        operation.apply(bananaTransaction);
        operation.apply(kiwiTransaction);
        operation.apply(appleTransaction);
        operation.apply(bananaTransaction);
        operation.apply(kiwiTransaction);
        operation.apply(appleTransaction);
        int banana = Storage.storage.get(bananaTransaction.getFruitName());
        int kiwi = Storage.storage.get(kiwiTransaction.getFruitName());
        int apple = Storage.storage.get(appleTransaction.getFruitName());
        assertEquals(20, banana);
        assertEquals(40, kiwi);
        assertEquals(60, apple);
    }

    @After
    public void clearStorage() {
        Storage.storage.clear();
    }
}
