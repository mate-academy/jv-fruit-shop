package core.basesyntax.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TransactionsTest {
    private static Transaction transaction;
    private static final String SUPPLY = "s";
    private static final String FRUIT_ORANGE = "orange";
    private static final Integer QUANTITY = 50;
    private static final String DATE = "2020-09-15";


    @Before
    public void before() {
        List<String> row = new ArrayList<>();
        row.add("buy");
        row.add("banana");
        row.add("100");
        row.add("2020-10-12");
        transaction = new Transaction(row);
    }

    @Test
    public void setOperationTest() {
        transaction.setOperation(SUPPLY);
        Assert.assertEquals(transaction.getOperation(), SUPPLY);
    }

    @Test
    public void setFruitTest() {
        transaction.setFruit(FRUIT_ORANGE);
        Assert.assertEquals(transaction.getFruit(), FRUIT_ORANGE);
    }

    @Test
    public void setDateTest() {
        transaction.setDate(DATE);
        Assert.assertEquals(transaction.getDate(), DATE);
    }

    @Test
    public void setQuantityTest() {
        transaction.setQuantity(QUANTITY);
        Assert.assertEquals(transaction.getQuantity(), QUANTITY);
    }
}
