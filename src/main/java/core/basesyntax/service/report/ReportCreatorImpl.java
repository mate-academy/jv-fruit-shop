package core.basesyntax.service.report;

import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {

    @Override
    public String createReport(Map<String, Integer> fruitTypesAndQuantity) {
        StringBuilder builder = new StringBuilder();
        builder.append(FIRST_LINE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitTypesAndQuantity.entrySet()) {
            if (entry.getValue() < 0) {
                throw new RuntimeException("Quantity of " + entry.getKey()
                        + " can't be less than 0");
            }
            builder.append(entry.getKey()).append(",").append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
