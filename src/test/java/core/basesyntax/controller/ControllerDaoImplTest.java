package core.basesyntax.controller;

import core.basesyntax.model.Product;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ControllerDaoImplTest {
    private static ControllerDao<Product> controllerDao;

    @BeforeClass
    public static void initialCsvUtils() {
        controllerDao = new ControllerDaoImpl();
    }

    @Test
    public void shouldReturnFalseWhenNullParameter() {
        Assert.assertFalse(controllerDao.put(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenMinusParameter() {
        controllerDao.get(-1);
    }
}
