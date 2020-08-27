package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class SupplyServiceTest {
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
        SupplyService supplyService = new SupplyService();
        supplyService.operationWithProduct(FRUIT);
        Assert.assertEquals(1, ListStorage.listStorage.size());
        Assert.assertEquals(FRUIT.getName(), ListStorage.listStorage.get(0).getName());
        Assert.assertEquals(FRUIT.getAmount(), ListStorage.listStorage.get(0).getAmount());
        Assert.assertEquals(FRUIT.getExpirationDate(), ListStorage.listStorage.get(0).getExpirationDate());
    }
}