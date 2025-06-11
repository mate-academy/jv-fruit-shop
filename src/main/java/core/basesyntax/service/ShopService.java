package core.basesyntax.service;

import core.basesyntax.model.Operation;

public interface ShopService {
    void transfer(Operation operation, String fruit, Integer quantity);
}
