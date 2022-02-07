package fruitshop.service.data;

import fruitshop.model.FruitTransaction;
import fruitshop.model.Operation;
import fruitshop.strategy.StrategyService;
import java.util.List;
import java.util.Map;

public interface ProcessDataService {
    void process(List<FruitTransaction> list, Map<Operation, StrategyService> operationsMap);
}
