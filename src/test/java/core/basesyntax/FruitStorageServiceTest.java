package core.basesyntax;

import core.basesyntax.fruitservice.FruitStorage;
import core.basesyntax.fruitservice.FruitStorageService;
import core.basesyntax.fruitservice.Transaction;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class FruitStorageServiceTest {
    private Transaction transaction = new Transaction("b", "banana", "200", "2010-11-20");
    private Transaction transaction1 = new Transaction("b", "banana", "150", "2020-12-23");
    private Transaction transaction2 = new Transaction("b", "banana", "365", "2020-10-15");
    private FruitStorageService fruitStorageService = new FruitStorageService();
    private FruitStorage fruitStorage = new FruitStorage();

    @Test
    public void addTest() {
        fruitStorage.getStorage().clear();
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

    @Test
    public void addAllToStorageTest() {
        List<Transaction> listOfTransaction = new ArrayList<>();
        List<Transaction> expected = new ArrayList<>();
        listOfTransaction.add(transaction);
        listOfTransaction.add(transaction1);
        listOfTransaction.add(transaction2);
        expected.addAll(listOfTransaction);
        fruitStorageService.addAllToStorage(listOfTransaction);
        Assert.assertEquals(expected, fruitStorage.getStorage());
    }

    @AfterClass
    public static void clear() {
        FruitStorage fruitStorage = new FruitStorage();
        fruitStorage.getStorage().clear();
    }
}
