package core.basesyntax;

import core.basesyntax.service.CreateReport;
import java.util.HashMap;
import java.util.Map;

public class CreateReportImpl implements CreateReport {

    public Map<String, Integer> countBalanceOfFruits(
            String fruit, int balance, int supply, int purches, int reture) {
        Map<String,Integer> reportFruits = new HashMap<>();
        int count = 0;
        if (fruit.equals(fruit)) {
            count = balance + supply - purches + reture;
        }
        reportFruits.put(fruit,count);
        return reportFruits;
    }
}
