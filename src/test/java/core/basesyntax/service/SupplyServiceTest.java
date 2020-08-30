package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListShopStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class SupplyServiceTest {
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
        SupplyService supplyService = new SupplyService();
        supplyService.serviceProduct(FRUIT);
        Assert.assertEquals(1, ListShopStorage.listStorage.size());
        Assert.assertEquals(FRUIT.getName(), ListShopStorage.listStorage.get(0).getName());
        Assert.assertEquals(FRUIT.getAmount(), ListShopStorage.listStorage.get(0).getAmount());
        Assert.assertEquals(FRUIT.getExpirationDate(), ListShopStorage.listStorage.get(0).getExpirationDate());
    }
}
