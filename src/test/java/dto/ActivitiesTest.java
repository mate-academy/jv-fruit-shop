package dto;

import exception.FruitShopException;
import org.junit.Assert;
import org.junit.Test;

public class ActivitiesTest {
    @Test
    public void createActivity_Ok() {
        Activities actual = Activities.of('b');
        Activities expected = Activities.BALANCE;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = FruitShopException.class)
    public void checkWrongActivityCreation_NotOk() {
        Activities actual = Activities.of('x');
    }
}
