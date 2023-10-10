package service.impl;

import db.FruitShopStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    @Override
    public List<String> createReport() {
        Map<String, Integer> collectFruit = FruitShopStorage.fruitShop;
        List<String> reportLines = new ArrayList<>();
        reportLines.add("fruit,quantity");
        for (Map.Entry<String, Integer> entry : collectFruit.entrySet()) {
            reportLines.add(entry.getKey() + "," + entry.getValue());
        }
        return reportLines;
    }
}
