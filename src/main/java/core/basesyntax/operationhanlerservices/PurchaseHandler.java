package core.basesyntax.operationhanlerservices;

import core.basesyntax.model.FruitRecordDto;
import java.util.Map;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void apply(FruitRecordDto fruitRecordDto, Map<String, Integer> storage) {
        if (fruitRecordDto.getAmount() > storage.get(fruitRecordDto.getFruitName())) {
            throw new RuntimeException("purchase can't be < balance");
        }
        storage.put(fruitRecordDto.getFruitName(),
                    storage.get(fruitRecordDto.getFruitName()) - fruitRecordDto.getAmount());
    }
}
