package service.impl;

import java.util.Map;
import java.util.StringJoiner;
import service.ReportGenerator;
import storage.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String PRODUCT_AMOUNT = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        Map<String, Integer> fruitBalance = Storage.getFruitDbResult();

        StringJoiner reportBuilder = new StringJoiner(System.lineSeparator());
        reportBuilder.add(PRODUCT_AMOUNT);

        for (Map.Entry<String, Integer> entry : fruitBalance.entrySet()) {
            reportBuilder.add(entry.getKey() + COMMA + entry.getValue());
        }

        return reportBuilder.toString();
    }

}
