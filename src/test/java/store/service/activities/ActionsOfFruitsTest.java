package store.service.activities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.service.files.WorkWithCsv;

public class ActionsOfFruitsTest {
    private WorkWithCsv workWithCsv;

    @BeforeEach
    void createObject() {
        workWithCsv = new WorkWithCsv();
        workWithCsv.readFromTempFile();
    }

    @Test
    void cost_notExistFruit() {
        Assertions.assertThrows(NullPointerException.class,
                () -> workWithCsv.getActionsOfFruits().getCostOfFruits("bananas"));
    }

    @Test
    void cost_existFruit() {
        Integer actual = workWithCsv.getActionsOfFruits().getCostOfFruits("banana");
        Assertions.assertEquals(20, actual);
    }

    @Test
    void remnant_test1() {
        Integer actual = workWithCsv.getActionsOfFruits()
                .returnFruits("r", "apple", 0);
        Assertions.assertEquals(100, actual);
    }

    @Test
    void remnant_test2() {
        Integer actual = workWithCsv.getActionsOfFruits()
                .returnFruits("r", "apple", 10);
        Assertions.assertEquals(110, actual);
    }

    @Test
    void remnant_test3() {
        Integer actual = workWithCsv.getActionsOfFruits()
                .returnFruits("r", "apple", 20);
        Assertions.assertEquals(120, actual);
    }

    @Test
    void remnant_test3_notExistAction() {
        Integer actual = workWithCsv.getActionsOfFruits()
                .returnFruits("w", "apple", 40);
        Assertions.assertEquals(0, actual);
    }

    @Test
    void buy_test1() {
        Integer actual = workWithCsv.getActionsOfFruits()
                .buyFruits("p", "banana", 0);
        Assertions.assertEquals(20, actual);
    }

    @Test
    void buy_test2() {
        Integer actual = workWithCsv.getActionsOfFruits()
                .buyFruits("p", "banana", 10);
        Assertions.assertEquals(10, actual);
    }

    @Test
    void buy_test3() {
        Integer actual = workWithCsv.getActionsOfFruits()
                .buyFruits("p", "apple", 20);
        Assertions.assertEquals(80, actual);
    }

    @Test
    void buy_test3_notExistAction() {
        Integer actual = workWithCsv.getActionsOfFruits()
                .buyFruits("asd", "apple", 40);
        Assertions.assertEquals(0, actual);
    }

    @Test
    void supply_test1() {
        Integer actual = workWithCsv.getActionsOfFruits()
                .supplyFruits("s", "banana", 100);
        Assertions.assertEquals(120, actual);
    }

    @Test
    void supply_test2() {
        Integer actual = workWithCsv.getActionsOfFruits()
                .supplyFruits("s", "banana", 1000);
        Assertions.assertEquals(1020, actual);
    }

    @Test
    void supply_test3() {
        Integer actual = workWithCsv.getActionsOfFruits()
                .supplyFruits("s", "apple", 3210);
        Assertions.assertEquals(3310, actual);
    }

    @Test
    void supply_test3_notExistAction() {
        Integer actual = workWithCsv.getActionsOfFruits()
                .supplyFruits("asd", "apple", 40);
        Assertions.assertEquals(0, actual);
    }
}
