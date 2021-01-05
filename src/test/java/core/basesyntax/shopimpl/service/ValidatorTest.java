package core.basesyntax.shopimpl.service;

import core.basesyntax.shopimpl.entity.Fruit;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ValidatorTest {
    
    @Test(expected = Exception.class)
    public void transactionValidatorInvalidTransaction() throws Exception {
        Map<Fruit, Integer> map = new HashMap<>();
        map.put(new Fruit("tasty fruit"), 0);
        Validator.transactionValidator(new Fruit("tasty fruit"), 10, map);
        map.put(new Fruit("tasty fruit"), 20);
        Validator.transactionValidator(new Fruit("tasty fruit"), 10, map);
    }
    
    @Test(expected = Exception.class)
    public void transactionValidatorValidTransaction() throws Exception {
        Map<Fruit, Integer> map = new HashMap<>();
        map.put(new Fruit("tasty fruit"), 20);
        Validator.transactionValidator(new Fruit("tasty fruit"), 10, map);
    }
}
