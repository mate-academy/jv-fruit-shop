package core.basesyntax.handler;

import java.math.BigDecimal;

public interface PurchaseHandler {
    boolean purchase(String fruitName, BigDecimal priceToSubtract);
}
