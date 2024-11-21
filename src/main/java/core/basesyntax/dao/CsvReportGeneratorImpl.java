package core.basesyntax.dao;

import static core.basesyntax.storage.Storage.storageOfFruits;

import java.util.Map;

public class CsvReportGeneratorImpl implements CsvReportGenerator {
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String generateReport(String fileName) {
        StringBuilder reportDataBuilder = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> fruitNameQuantityEntry : storageOfFruits.entrySet()) {
            String fruitName = fruitNameQuantityEntry.getKey();
            Integer quantity = fruitNameQuantityEntry.getValue();
            reportDataBuilder.append(fruitName).append(COMMA).append(quantity)
                    .append(System.lineSeparator());
        }
        return reportDataBuilder.toString();
    }
}
