package core.basesyntax.service.implementations;

import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {

    @Override
    public String create(Map<String, Integer> map) {
        StringBuilder reportString = new StringBuilder();
        reportString.append("fruit,quantity\n");

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String fruit = entry.getKey();
            int quantity = entry.getValue();
            reportString.append(fruit).append(",").append(quantity).append("\n");
        }
        return reportString.toString();
    }
}
