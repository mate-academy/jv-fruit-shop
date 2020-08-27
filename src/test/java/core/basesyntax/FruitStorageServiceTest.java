package core.basesyntax;

import core.basesyntax.fruitservice.FruitStorage;
import core.basesyntax.fruitservice.FruitStorageService;
import core.basesyntax.fruitservice.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FruitStorageServiceTest {
    private Transaction transaction = Transaction.build("b", "banana", "200", "2010-11-20");
    private FruitStorageService fruitStorageService = new FruitStorageService();

    @Test
    public void addTest() {
        List<Transaction> list1 = new ArrayList<>();
        list1.add(transaction);
        fruitStorageService.addToStorage(transaction);
        List<Transaction> list = FruitStorage.getStorage();
        Assert.assertEquals(list, list1);
    }

    @Test
    public void removeTest() {
        List<Transaction> list1 = new ArrayList<>();
        fruitStorageService.removeFromStorage(transaction);
        List<Transaction> list = new ArrayList<>();
        Assert.assertEquals(list, list1);
    }
}