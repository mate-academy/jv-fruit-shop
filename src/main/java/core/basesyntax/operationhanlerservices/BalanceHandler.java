package core.basesyntax.operationhanlerservices;

import core.basesyntax.model.FruitRecordDto;
import java.util.Map;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(FruitRecordDto fruitRecordDto, Map<String, Integer> storage) {
        storage.put(fruitRecordDto.getFruitName(), fruitRecordDto.getAmount());
    }
}
