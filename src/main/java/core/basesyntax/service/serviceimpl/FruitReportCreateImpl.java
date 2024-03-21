package core.basesyntax.service.serviceimpl;

import core.basesyntax.exception.NegativeBalanceException;
import core.basesyntax.service.interfaces.FruitReportCreate;
import java.util.HashMap;
import java.util.Map;

public class FruitReportCreateImpl implements FruitReportCreate {
    private static final String FIRST_CSV_REPORT_LINE = "fruit,quantity" + System.lineSeparator();
    private static final String DIVIDER = ",";

    public String createReport(HashMap<String, Integer> fruitQuantity) {
        StringBuilder builder = new StringBuilder(FIRST_CSV_REPORT_LINE);
        for (Map.Entry<String, Integer> fruits: fruitQuantity.entrySet()) {
            builder.append(fruits.getKey())
                    .append(DIVIDER)
                    .append(fruits.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
