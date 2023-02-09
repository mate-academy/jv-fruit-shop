package core.basesyntax.service.handler;

import java.math.BigDecimal;

public class Purchase implements HandlerByActivity {

    @Override
    public BigDecimal getSumFruits(BigDecimal bigDecimalActivity) {
        return bigDecimalActivity.negate();
    }
}
