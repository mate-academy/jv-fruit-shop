package core.basesyntax.shopimpl.service;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.shopimpl.entity.Fruit;
import core.basesyntax.shopimpl.entity.IllegalPurchaseAmountException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ValidatorTest {
    
    @Test(expected = IllegalPurchaseAmountException.class)
    public void transactionValidatorInvalidTransaction() throws Exception {
        Map<AbstractItem, Integer> map = new HashMap<>();
        map.put(new Fruit("tasty fruit"), 0);
        Validator.transactionValidator(new Fruit("tasty fruit"), 10, map);
        map.put(new Fruit("tasty fruit"), 20);
        Validator.transactionValidator(new Fruit("tasty fruit"), 10, map);
    }
    
    @Test
    public void transactionValidatorValidTransaction() throws Exception {
        Map<AbstractItem, Integer> map = new HashMap<>();
        map.put(new Fruit("tasty fruit"), 20);
        Validator.transactionValidator(new Fruit("tasty fruit"), 10, map);
    }
}
