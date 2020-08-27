package core.basesyntax;

import core.basesyntax.fruitservice.FruitStorage;
import core.basesyntax.fruitservice.FruitStorageService;
import core.basesyntax.fruitservice.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class FruitStorageServiceTest {
    private Transaction transaction = Transaction.build("b", "banana", "200", "2010-11-20");
    private FruitStorageService fruitStorageService = new FruitStorageService();
    private FruitStorage fruitStorage = new FruitStorage();

    @Test
    public void addTest() {
        List<Transaction> list1 = new ArrayList<>();
        list1.add(transaction);
        fruitStorageService.addToStorage(transaction);
        List<Transaction> list = FruitStorage.getStorage();
        Assert.assertEquals(list, list1);
    }

    @After
    public void ClearAfterAddition() {
        FruitStorage fruitStorage = new FruitStorage();
        fruitStorage.getStorage().clear();
    }

    @Test
    public void removeTest() {
        fruitStorageService.addToStorage(transaction);
        fruitStorageService.removeFromStorage(transaction);
        Assert.assertEquals(new ArrayList<>(), fruitStorage.getStorage());
    }

    @AfterClass
    public static void Clear() {
        FruitStorage fruitStorage = new FruitStorage();
        fruitStorage.getStorage().clear();
    }
}