package fshop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FoodTest {
    @Test
    void createObj() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new Food(null, 10));
        Assertions.assertThrows(NullPointerException.class,
                () -> new Food("Apple", null));
    }

    @Test
    void check_identityName() {
        Food actual = new Food("Apple", 10);
        Assertions.assertEquals("Apple", actual.getName());
    }

    @Test
    void check_identityNumber() {
        Food actual = new Food("Apple", 10);
        Assertions.assertEquals(10, actual.getNumber());
    }

    @Test
    void set_checkName_null() {
        Food actual = new Food("Apple", 10);
        Assertions.assertThrows(NullPointerException.class, () -> actual.setName(null));
    }

    @Test
    void set_checkNumber_null() {
        Food actual = new Food("Apple", 10);
        Assertions.assertThrows(NullPointerException.class, () -> actual.setNumber(null));
    }

    @Test
    void set_checkNumber_ok() {
        Food actual = new Food("Apple", 10);
        actual.setNumber(20);
        Assertions.assertEquals(20, actual.getNumber());
    }

    @Test
    void set_checkName_ok() {
        Food actual = new Food("Apple", 10);
        actual.setName("Banana");
        Assertions.assertEquals("Banana", actual.getName());
    }
}
