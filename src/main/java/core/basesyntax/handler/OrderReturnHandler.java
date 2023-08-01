package core.basesyntax.handler;

import java.math.BigDecimal;

public interface OrderReturnHandler {
    boolean returnOrder(String fruitName, BigDecimal priceToReturn);
}
