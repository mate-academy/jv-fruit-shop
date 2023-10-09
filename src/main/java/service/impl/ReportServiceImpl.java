package service.impl;

import db.FruitShopStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import service.FruitShopService;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private FruitShopService fruitShopService;

    public ReportServiceImpl(FruitShopService fruitShopService) {
        this.fruitShopService = fruitShopService;
    }

    @Override
    public List<String> createReport() {
        //стоворюємо репорт
        Map<String, Integer> collectFruit = FruitShopStorage.fruitShop;
        List<String> reportLines = new ArrayList<>();
        reportLines.add("fruit,quantity");
        for (Map.Entry<String, Integer> entry : collectFruit.entrySet()) {
            reportLines.add(entry.getKey() + "," + entry.getValue());
        }
        return reportLines;
    }
}
