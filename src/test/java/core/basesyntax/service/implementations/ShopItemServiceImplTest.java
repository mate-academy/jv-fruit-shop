package core.basesyntax.service.implementations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ShopItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShopItemServiceImplTest {
    public static ShopItem banana;
    public static ShopItem potato;
    public static ShopItemServiceImpl shopService;
    public static final String EXPECTED = "fruit,quantity" + System.lineSeparator()
            + "banana,20" + System.lineSeparator()
            + "potato,30";

    @BeforeClass
    public static void setUp() {
        banana = new ShopItem("banana");
        potato = new ShopItem("potato");
        shopService = new ShopItemServiceImpl(null);
    }

    @After
    public void tearDown() {
        Storage.storage.clear();
    }

    @Test
    public void testReport_Correct() {
        Storage.storage.put(banana, 20);
        Storage.storage.put(potato, 30);
        String stringReport = shopService.getStringReport();
        Assert.assertEquals(EXPECTED, stringReport);
    }

    @Test
    public void emptyReport_Correct() {
        Assert.assertEquals("fruit,quantity", shopService.getStringReport());
    }
}
