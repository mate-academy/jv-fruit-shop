package app.model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FruitTest {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static Fruit firstBanana;
    private static Fruit secondBanana;

    @BeforeClass
    public static void start() {
        firstBanana = new Fruit("banana", 100, LocalDate.parse("2020-08-27", formatter));
        secondBanana = new Fruit("banana", 100, LocalDate.parse("2020-08-27", formatter));
    }

    @Test
    public void testFruitEquals() {
        Assert.assertEquals(firstBanana, secondBanana);
    }

    @Test
    public void testFruitHashCode() {
        Assert.assertEquals(firstBanana.hashCode(), secondBanana.hashCode());
    }

    @Test
    public void getName() {
        Assert.assertEquals("banana", firstBanana.getName());
    }

    @Test
    public void getQuantity() {
        Assert.assertEquals(100, firstBanana.getQuantity());
    }
}