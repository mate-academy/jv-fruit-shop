package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class ReturnServiceTest {
    public static final Fruit FRUIT = new Fruit();

    @Before
    public void setUpFruit() {
        ListStorage.listStorage.clear();
        FRUIT.setName("banana");
        FRUIT.setAmount(1);
        FRUIT.setExpirationDate(LocalDate.of(2020, 5, 21));
    }

    @Test
    public void addToStorageOk() {
        ReturnService returnService = new ReturnService();
        returnService.operationWithProduct(FRUIT);
        Assert.assertEquals(1, ListStorage.listStorage.size());
        Assert.assertEquals(FRUIT, ListStorage.listStorage.get(0));
    }
}