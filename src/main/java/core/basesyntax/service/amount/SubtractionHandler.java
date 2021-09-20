package core.basesyntax.service.amount;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.Report;
import java.util.Map;

public class SubtractionHandler implements AmountHandler {
    private static final Map<String, Integer> REPORT_RAW_DATA = Report.REPORT_RAW_DATA;

    @Override
    public void apply(FruitRecord record) {
        String fruitName = record.getFruit().getFruitName();
        int currentAmount = REPORT_RAW_DATA.get(fruitName) == null
                ? 0 : REPORT_RAW_DATA.get(fruitName);
        int updatedAmount = currentAmount - record.getAmount();
        if (updatedAmount < 0) {
            throw new RuntimeException("It isn't possible to buy fruits!"
                    + System.lineSeparator()
                    + "Is available: " + currentAmount
                    + " " + fruitName
                    + System.lineSeparator()
                    + "Trying to buy: " + record.getAmount()
                    + " " + fruitName);
        }
        REPORT_RAW_DATA.put(fruitName, updatedAmount);
    }
}
