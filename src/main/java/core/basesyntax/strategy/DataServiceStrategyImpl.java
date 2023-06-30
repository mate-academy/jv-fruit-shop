package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.dataservice.DataService;
import java.util.Map;

public class DataServiceStrategyImpl implements DataServiceStrategy {
    private Map<FruitTransaction.Operation, DataService> dataServiceMap;

    public DataServiceStrategyImpl(Map<FruitTransaction.Operation, DataService> dataServiceMap) {
        this.dataServiceMap = dataServiceMap;
    }

    @Override
    public DataService get(FruitTransaction.Operation operationType) {
        return dataServiceMap.get(operationType);
    }
}
