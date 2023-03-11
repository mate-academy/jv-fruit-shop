package strategy.activity;

import model.Record;
import report.FruitBalance;

public class ActivityHandlerSubstractionImpl implements ActivityHandler {
    @Override
    public void apply(Record record) {
        String fruitName = record.getFruitName();
        int currentBalance = FruitBalance.FRUIT_BALANCE.get(fruitName) == null ? 0
                : FruitBalance.FRUIT_BALANCE.get(fruitName);
        int newAmount = currentBalance - record.getFruitAmount();
        if (newAmount < 0) {
            throw new RuntimeException("Can't buy this amount of fruits: "
                    + record.getFruitAmount());
        }
        FruitBalance.FRUIT_BALANCE.put(fruitName,newAmount);
    }
}
