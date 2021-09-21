package operation;

import model.Record;
import report.FruitBalance;

public class DecreaseHandler implements OperationHandler {
    @Override
    public void apply(Record record) {
        String fruit = record.getFruit();
        int currentAmount = FruitBalance.FRUIT_BALANCE.get(fruit) == null
                ? 0 : FruitBalance.FRUIT_BALANCE.get(fruit);
        int newAmount = currentAmount - record.getAmount();
        if (newAmount < 0) {
            throw new RuntimeException("Can't buy this amount of fruits: "
                    + record.getAmount());
        }
        FruitBalance.FRUIT_BALANCE.put(fruit, newAmount);
    }
}
