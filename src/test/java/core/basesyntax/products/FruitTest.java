package core.basesyntax.products;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class FruitTest {
    private static final String NAME_BANANA = "Banana";
    private static final String NAME_ORANGE = "Orange";
    private static final int AMOUNT_10 = 10;
    private static final int AMOUNT_20 = 20;
    private static final LocalDate LOCAL_DATE_BEFORE = LocalDate.of(2020,10,17);
    private static final LocalDate LOCAL_DATE_AFTER = LocalDate.of(2025,12,11);
    private static Fruit testFruit;

    @Before
    public void setUp() {
        testFruit = new Fruit(NAME_BANANA, AMOUNT_10, LOCAL_DATE_BEFORE);
    }

    @Test
    public void getName() {
        Assert.assertEquals(testFruit.getName(), NAME_BANANA);
    }

    @Test
    public void setName() {
        testFruit.setName(NAME_ORANGE);
        Assert.assertEquals(NAME_ORANGE, testFruit.getName());
    }

    @Test
    public void getAmount() {
        Assert.assertEquals(AMOUNT_10, testFruit.getAmount());
    }

    @Test
    public void setAmount() {
        testFruit.setAmount(AMOUNT_20);
        Assert.assertEquals(AMOUNT_20, testFruit.getAmount());
    }

    @Test
    public void getDate() {
        Assert.assertEquals(LOCAL_DATE_BEFORE, testFruit.getExpirationDate());
    }

    @Test
    public void setDate() {
        testFruit.setExpirationDate(LOCAL_DATE_AFTER);
        Assert.assertEquals(LOCAL_DATE_AFTER, testFruit.getExpirationDate());
    }
}