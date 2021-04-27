package fshop.model;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class FoodTest {
    @Test(expected = NullPointerException.class)
    public void createObj() {
        new Food(null, 10);
        new Food("Apple", null);
    }

    @Test
    public void check_identityName() {
        Food actual = new Food("Apple", 10);
        assertEquals("Apple", actual.getName());
    }

    @Test
    public void check_identityNumber() {
        Food actual = new Food("Apple", 10);
        assertEquals(Integer.valueOf(10), actual.getNumber());
    }

    @Test (expected = NullPointerException.class)
    public void set_checkName_null() {
        Food actual = new Food("Apple", 10);
        actual.setName(null);
    }

    @Test (expected = NullPointerException.class)
    public void set_checkNumber_null() {
        Food actual = new Food("Apple", 10);
        actual.setNumber(null);
    }

    @Test
    public void set_checkNumber_ok() {
        Food actual = new Food("Apple", 10);
        actual.setNumber(20);
        assertEquals(Integer.valueOf(20), actual.getNumber());
    }

    @Test
    public void set_checkName_ok() {
        Food actual = new Food("Apple", 10);
        actual.setName("Banana");
        assertEquals("Banana", actual.getName());
    }
}
