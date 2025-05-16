package core.basesyntax.service;

import core.basesyntax.model.Operation;
import java.math.BigDecimal;

public interface ShopService {
    void transfer(Operation operation, String fruit, BigDecimal quantity);
}
