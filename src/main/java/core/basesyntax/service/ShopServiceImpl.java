package core.basesyntax.service;

import core.basesyntax.dao.FruitStorage;
import core.basesyntax.model.Operation;
import java.math.BigDecimal;

public class ShopServiceImpl implements ShopService {

    @Override
    public void transfer(Operation operation, String fruit, BigDecimal quantity) {
        BigDecimal current = FruitStorage.storage.getOrDefault(fruit, BigDecimal.ZERO);

        switch (operation) {
            case BALANCE:
                FruitStorage.storage.put(fruit, quantity);
                break;
            case SUPPLY:
            case RETURN:
                FruitStorage.storage.put(fruit, current.add(quantity));
                break;
            case PURCHASE:
                if (current.compareTo(quantity) < 0) {
                    throw new RuntimeException("Not enough stock for: " + fruit);
                }
                FruitStorage.storage.put(fruit, current.subtract(quantity));
                break;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }
}
