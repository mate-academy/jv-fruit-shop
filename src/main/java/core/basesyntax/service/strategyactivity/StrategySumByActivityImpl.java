package core.basesyntax.service.strategyactivity;

import core.basesyntax.service.activity.CategoryActivity;
import java.util.Map;

public class StrategySumByActivityImpl implements StrategySumByActivity {
    private final Map<String, CategoryActivity> stringStrategyActivityMap;

    public StrategySumByActivityImpl(Map<String, CategoryActivity> stringStrategyActivityMap) {
        this.stringStrategyActivityMap = stringStrategyActivityMap;
    }

    @Override
    public CategoryActivity getSumFruit(String activity) {
        return stringStrategyActivityMap.get(activity);
    }
}
