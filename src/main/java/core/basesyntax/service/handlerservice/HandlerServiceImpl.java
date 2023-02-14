package core.basesyntax.service.handlerservice;

import core.basesyntax.service.handler.OperationHandler;
import java.util.Map;

public class HandlerServiceImpl implements HandlerService {
    private final Map<String, OperationHandler> stringStrategyActivityMap;

    public HandlerServiceImpl(Map<String, OperationHandler> stringStrategyActivityMap) {
        this.stringStrategyActivityMap = stringStrategyActivityMap;
    }

    @Override
    public OperationHandler getSumFruit(String activity) {
        return stringStrategyActivityMap.get(activity);
    }
}
