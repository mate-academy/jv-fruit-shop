package service.activity;

import java.util.Map;
import model.FruitRecord;

public class BalanceHandler implements ActivityHandler {
    @Override
    public void use(FruitRecord fruitRecord, Map<String, Integer> report) {
        report.put(fruitRecord.getFruitName(), fruitRecord.getAmount());
    }
}
