package core.basesyntax.service.handler;

import java.math.BigDecimal;

public class Balance implements HandlerByActivity {

    @Override
    public BigDecimal getSumFruits(BigDecimal bigDecimalActivity) {
        return bigDecimalActivity.plus();
    }
}
