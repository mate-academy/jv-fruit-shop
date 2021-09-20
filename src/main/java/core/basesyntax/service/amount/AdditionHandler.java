package core.basesyntax.service.amount;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.Report;
import java.util.Map;

public class AdditionHandler implements AmountHandler {
    private static final Map<String, Integer> REPORT_RAW_DATA = Report.REPORT_RAW_DATA;

    @Override
    public void apply(FruitRecord record) {
        String fruitName = record.getFruit().getFruitName();
        int currentAmount = REPORT_RAW_DATA.get(fruitName) == null
                ? 0 : REPORT_RAW_DATA.get(fruitName);
        int updatedAmount = currentAmount + record.getAmount();
        REPORT_RAW_DATA.put(fruitName, updatedAmount);
    }
}
