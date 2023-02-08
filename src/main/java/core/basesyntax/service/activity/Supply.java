package core.basesyntax.service.activity;

import java.math.BigDecimal;

public class Supply implements CategoryActivity {

    @Override
    public BigDecimal getSumFruits(BigDecimal bigDecimalActivity) {
        return bigDecimalActivity.plus();
    }
}
