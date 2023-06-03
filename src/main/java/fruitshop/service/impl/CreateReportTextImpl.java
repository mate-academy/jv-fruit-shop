package fruitshop.service.impl;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;
import fruitshop.service.CreateReportText;
import fruitshop.strategy.impl.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class CreateReportTextImpl implements CreateReportText {
    private Map<String, Integer> result = new HashMap<>();

    @Override
    public Map<String, Integer> createReportText() {
        for (Map.Entry<FruitTransaction, OperationStrategy> entry : Storage.fruits.entrySet()) {
            result.put(entry.getKey().getFruit(), entry.getValue().quantity(entry.getKey()));
        }
        return result;
    }
}
