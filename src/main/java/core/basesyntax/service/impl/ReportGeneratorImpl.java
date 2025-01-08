package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Map<String, Integer> fruitMap) {
        String result = "fruit,quantity" + System.lineSeparator();
        for (Map.Entry<String, Integer> entry : fruitMap.entrySet()) {
            if (entry.getValue() < 0) {
                throw new RuntimeException("Negative quantity value!");
            }
            result = result + entry.getKey() + "," + entry.getValue()
                    + System.lineSeparator();
        }
        return result;
    }
}
