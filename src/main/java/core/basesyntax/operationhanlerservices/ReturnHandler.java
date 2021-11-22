package core.basesyntax.operationhanlerservices;

import core.basesyntax.model.FruitRecordDto;
import java.util.Map;

public class ReturnHandler implements OperationHandler {
    @Override
    public void apply(FruitRecordDto fruitRecordDto, Map<String, Integer> storage) {
        if (fruitRecordDto.getAmount() < 0) {
            throw new RuntimeException("Return can't be negative");
        }
        storage.put(fruitRecordDto.getFruitName(),
                    storage.get(fruitRecordDto.getFruitName()) + fruitRecordDto.getAmount());
    }
}
