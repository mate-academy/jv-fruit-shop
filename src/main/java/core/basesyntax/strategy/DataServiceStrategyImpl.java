package core.basesyntax.strategy;

import core.basesyntax.service.dataservice.DataService;
import java.util.Map;

public class DataServiceStrategyImpl implements DataServiceStrategy {
    private Map<String, DataService> dataServiceMap;

    public DataServiceStrategyImpl(Map<String, DataService> dataServiceMap) {
        this.dataServiceMap = dataServiceMap;
    }

    @Override
    public DataService get(String operationType) {
        return dataServiceMap.get(operationType);
    }
}
