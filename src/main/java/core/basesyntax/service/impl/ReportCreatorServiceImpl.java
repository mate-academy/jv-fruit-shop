package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreatorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String FILE_HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public List<String> createReport(Map<String, Integer> products) {
        List<String> productsInfo = new ArrayList<>();
        productsInfo.add(FILE_HEADER);
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            String productInfo = entry.getKey() + COMMA + entry.getValue();
            productsInfo.add(productInfo);
        }
        return productsInfo;
    }
}
