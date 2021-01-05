package core.basesyntax.tests;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operations;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationWithFruits;
import core.basesyntax.service.impl.FruitsReductionImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitReductionImplTest {
    private static OperationWithFruits operation;
    private static Transaction bananaTransaction;
    private static Transaction kiwiTransaction;

    @BeforeClass
    public static void beforeClass() {
        operation = new FruitsReductionImpl();
        bananaTransaction = new Transaction(Operations.PURCHASE, new Fruit("banana"), 10);
        kiwiTransaction = new Transaction(Operations.PURCHASE, new Fruit("kiwi"), 15);
    }

    @Before
    public void putOnBalance() {
        Storage.storage.put(new Fruit("banana"), 20);
        Storage.storage.put(new Fruit("kiwi"), 20);
    }

    @Test
    public void makeFruitReduction() {
        operation.apply(bananaTransaction);
        operation.apply(kiwiTransaction);
        int banana = Storage.storage.get(bananaTransaction.getFruitName());
        int kiwi = Storage.storage.get(kiwiTransaction.getFruitName());
        assertEquals(10, banana);
        assertEquals(5, kiwi);
    }

    @Test(expected = RuntimeException.class)
    public void makeNegativeBalance_NotOK() {
        operation.apply(kiwiTransaction);
        operation.apply(kiwiTransaction);
    }

    @After
    public void clearStorage() {
        Storage.storage.clear();
    }
}
