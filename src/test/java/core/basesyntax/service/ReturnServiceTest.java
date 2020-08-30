package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListShopStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class ReturnServiceTest {
    public static final Fruit FRUIT = new Fruit();

    @Before
    public void setUpFruit() {
        ListShopStorage.listStorage.clear();
        FRUIT.setName("banana");
        FRUIT.setAmount(1);
        FRUIT.setExpirationDate(LocalDate.of(2020, 5, 21));
    }

    @Test
    public void addToStorageOk() {
        ReturnService returnService = new ReturnService();
        returnService.serviceProduct(FRUIT);
        Assert.assertEquals(1, ListShopStorage.listStorage.size());
        Assert.assertEquals(FRUIT, ListShopStorage.listStorage.get(0));
    }
}
