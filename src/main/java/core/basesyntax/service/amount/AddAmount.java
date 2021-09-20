package core.basesyntax.service.amount;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.Report;
import java.util.Map;

public class AddAmount implements AmountHandler {
    private static final Map<String, Integer> REPORT = Report.REPORT_TEMPLATE;

    @Override
    public void apply(FruitRecord record) {
        String fruitName = record.getFruit().getFruitName();
        int currentAmount = REPORT.get(fruitName) == null ? 0 : REPORT.get(fruitName);
        int updatedAmount = currentAmount + record.getAmount();
        Report.REPORT_TEMPLATE.put(fruitName, updatedAmount);
    }
}
