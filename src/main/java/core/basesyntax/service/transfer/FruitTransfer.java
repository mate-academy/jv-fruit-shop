package core.basesyntax.service.transfer;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.strategy.OperationStrategy;

import java.util.List;
import java.util.Map;

public interface FruitTransfer {
    Map<String, Integer> transfer(String fromFileName); //(List<FruitRecord> fruitRecords, OperationStrategy operationStrategy);
}
