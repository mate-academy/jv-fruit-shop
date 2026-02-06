package basesyntax.service.impl;

import basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String generate(Map<String, Integer> fruitStorage) {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
