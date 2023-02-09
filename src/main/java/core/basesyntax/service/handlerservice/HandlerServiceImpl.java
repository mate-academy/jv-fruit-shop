package core.basesyntax.service.handlerservice;

import core.basesyntax.service.handler.HandlerByActivity;
import java.util.Map;

public class HandlerServiceImpl implements HandlerService {
    private final Map<String, HandlerByActivity> stringStrategyActivityMap;

    public HandlerServiceImpl(Map<String, HandlerByActivity> stringStrategyActivityMap) {
        this.stringStrategyActivityMap = stringStrategyActivityMap;
    }

    @Override
    public HandlerByActivity getSumFruit(String activity) {
        return stringStrategyActivityMap.get(activity);
    }
}
