package service.impl;

import static db.Storage.fruits;

import java.util.Map;
import service.CreateReportService;

public class CreateReportImpl implements CreateReportService {
    private static final String HEADER_FRUIT = "fruitTransaction,";
    private static final String HEADER_QUANTITY = "quantity";

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER_FRUIT)
                .append(HEADER_QUANTITY)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> map : fruits.entrySet()) {
            stringBuilder.append(map.getKey())
                    .append(" ")
                    .append(map.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
