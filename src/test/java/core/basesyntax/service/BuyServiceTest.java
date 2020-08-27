package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class BuyServiceTest {
    private static final LocalDate FIRST_DATE = LocalDate.of(2020, 12, 12);
    private static final LocalDate SECOND_DATE = LocalDate.of(2020, 11, 21);
    private static final LocalDate THIRD_DATE = LocalDate.of(2020, 11, 22);
    private static final LocalDate FORTH_DATE = LocalDate.of(2020, 12, 22);
    private static final Fruit FRUIT_FIRST = new Fruit();
    private static final Fruit FRUIT_SECOND = new Fruit();
    private static final Fruit FRUIT_TO_BUY_OK = new Fruit();
    private static Fruit FRUIT_TO_BUY_NOT_OK = new Fruit();

    @Before
    public void setUpClass() {
        FRUIT_FIRST.setName("banana");
        FRUIT_FIRST.setAmount(1);
        FRUIT_FIRST.setExpirationDate(FIRST_DATE);
        FRUIT_SECOND.setName("banana");
        FRUIT_SECOND.setAmount(1);
        FRUIT_SECOND.setExpirationDate(SECOND_DATE);
        FRUIT_TO_BUY_OK.setName("banana");
        FRUIT_TO_BUY_OK.setAmount(1);
        FRUIT_TO_BUY_OK.setExpirationDate(THIRD_DATE);
        FRUIT_TO_BUY_NOT_OK.setName("banana");
        FRUIT_TO_BUY_NOT_OK.setAmount(1);
        FRUIT_TO_BUY_NOT_OK.setExpirationDate(THIRD_DATE);


        ListStorage.listStorage.clear();
        ListStorage.listStorage.add(FRUIT_FIRST);
        ListStorage.listStorage.add(FRUIT_SECOND);
    }

    @Test
    public void operationBuyProductOk() {
        BuyService testBuyService = new BuyService();
        testBuyService.operationWithProduct(FRUIT_TO_BUY_OK);
        Assert.assertEquals(1, ListStorage.listStorage.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void operationBuyProductTooMany() {
        FRUIT_TO_BUY_NOT_OK.setAmount(5);
        BuyService testBuyService = new BuyService();
        testBuyService.operationWithProduct(FRUIT_TO_BUY_NOT_OK);
        Assert.assertEquals(2, ListStorage.listStorage.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void operationBuyProductLateDate() {
        FRUIT_TO_BUY_NOT_OK.setExpirationDate(FORTH_DATE);
        BuyService testBuyService = new BuyService();
        testBuyService.operationWithProduct(FRUIT_TO_BUY_NOT_OK);
        Assert.assertEquals(1, ListStorage.listStorage.size());
    }
}