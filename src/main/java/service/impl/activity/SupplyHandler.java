package service.impl.activity;

import java.util.Map;
import model.FruitRecord;

public class SupplyHandler implements ActivityHandler {

    @Override
    public void use(FruitRecord fruitRecord, Map<String, Integer> report) {
        report.put(fruitRecord.getFruitName(),
                CheckNullBalance.get(fruitRecord.getFruitName(), report) + fruitRecord.getAmount());
    }
}
