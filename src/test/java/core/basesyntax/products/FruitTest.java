package core.basesyntax.products;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class FruitTest {
    private static final String NAME_BANANA = "Banana";
    private static final String NAME_ORANGE = "Orange";
    private static final int AMOUNT_10 = 10;
    private static final int AMOUNT_20 = 20;
    private static final LocalDate LOCAL_DATE_BEFORE = LocalDate.ofEpochDay(2020 - 10 - 17);
    private static final LocalDate LOCAL_DATE_AFTER = LocalDate.ofEpochDay(2025 - 12 - 11);
    private static Fruit testFruit;

    @BeforeClass
    public static void setUp() {
        testFruit = new Fruit(NAME_BANANA, AMOUNT_10, LOCAL_DATE_BEFORE);
    }

    @Test
    public void getName() {
        Assert.assertEquals(testFruit.getName(),NAME_BANANA);
    }

    @Test
    public void setName() {
        testFruit.setName(NAME_ORANGE);
        Assert.assertEquals(NAME_ORANGE,testFruit.getName());
    }

    @Test
    public void getAmount() {
        Assert.assertEquals(testFruit.getAmount(), AMOUNT_10);
    }

    @Test
    public void setAmount() {
        testFruit.setAmount(AMOUNT_20);
        Assert.assertEquals(AMOUNT_20, testFruit.getAmount());
    }

    @Test
    public void getDate() {
        Assert.assertEquals(LOCAL_DATE_BEFORE, testFruit.getDate());
    }

    @Test
    public void setDate() {
        testFruit.setDate(LOCAL_DATE_AFTER);
        Assert.assertEquals(LOCAL_DATE_AFTER, testFruit.getDate());
    }
}