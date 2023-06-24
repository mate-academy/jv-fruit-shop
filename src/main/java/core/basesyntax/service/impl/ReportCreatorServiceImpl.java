package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String FILE_HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String createReport(Map<String, Integer> products) {
        StringBuilder productsInfo = new StringBuilder();
        productsInfo.append(FILE_HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            String productInfo = entry.getKey() + COMMA + entry.getValue();
            productsInfo.append(productInfo).append(System.lineSeparator());
        }
        return productsInfo.toString();
    }
}
