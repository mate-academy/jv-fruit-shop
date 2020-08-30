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
    private Transaction transaction = new Transaction("b", "banana", "200", "2010-11-20");
    private FruitStorageService fruitStorageService = new FruitStorageService();
    private FruitStorage fruitStorage = new FruitStorage();

    @Test
    public void addTest() {
        List<Transaction> expected = new ArrayList<>();
        expected.add(transaction);
        fruitStorageService.addToStorage(transaction);
        Assert.assertEquals(expected, fruitStorage.getStorage());
    }


    @Test
    public void removeTest() {
        fruitStorage.getStorage().clear();
        fruitStorage.getStorage().add(transaction);
        fruitStorageService.removeFromStorage(transaction);
        Assert.assertEquals(new ArrayList<>(), fruitStorage.getStorage());
    }

    @AfterClass
    public static void clear() {
        FruitStorage fruitStorage = new FruitStorage();
        fruitStorage.getStorage().clear();
    }
}
