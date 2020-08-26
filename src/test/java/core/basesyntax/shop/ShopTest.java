package core.basesyntax.shop;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class ShopTest {

    @Test
    public void emptyBalanceStorage() {
        Shop shop = new Shop(null);
        List<String> balanceStorage = shop.balanceStorage();
        Assert.assertEquals(0, balanceStorage.size());
    }
}