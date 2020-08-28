package app.model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;

public class SupplyFruitTest {
    private static SupplyFruit firstBanana;
    private static SupplyFruit secondBanana;

    @BeforeClass
    public static void start() {
        firstBanana = new SupplyFruit("banana", 100, LocalDate.parse("2020-08-27"));
        secondBanana = new SupplyFruit("banana", 100, LocalDate.parse("2020-08-27"));
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
        Assert.assertEquals("banana", firstBanana.getFruitName());
    }

    @Test
    public void getQuantity() {
        Assert.assertEquals(100, firstBanana.getQuantity());
    }
}