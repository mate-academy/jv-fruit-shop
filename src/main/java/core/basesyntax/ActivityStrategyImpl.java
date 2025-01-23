package core.basesyntax;

import core.basesyntax.models.Product;
import core.basesyntax.models.activities.ActivityHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<Product.TypeOfActivity, ActivityHandler> handlerMap;

    public ActivityStrategyImpl(Map<Product.TypeOfActivity, ActivityHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public ActivityHandler getActivity(Product.TypeOfActivity type) {
        return handlerMap.get(type);
    }
}
