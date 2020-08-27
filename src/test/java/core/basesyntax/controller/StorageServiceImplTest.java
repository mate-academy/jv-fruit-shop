package core.basesyntax.controller;

import core.basesyntax.model.Product;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StorageServiceImplTest {
    private static StorageService<Product> storageService;

    @BeforeClass
    public static void initialCsvUtils() {
        storageService = new StorageServiceImpl();
    }

    @Test
    public void shouldReturnFalseWhenNullParameter() {
        Assert.assertFalse(storageService.put(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenMinusParameter() {
        storageService.retrieve(-1);
    }
}
