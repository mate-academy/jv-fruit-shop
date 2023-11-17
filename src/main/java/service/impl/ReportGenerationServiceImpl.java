package service.impl;

import db.FruitShopDao;
import service.ReportGenerationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGenerationServiceImpl implements ReportGenerationService {
    private static final String FIRST_REPORT_LINE = "fruit,quantity";
    private FruitShopDao fruitShopDao;

    public ReportGenerationServiceImpl(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public List<String> generateReport() {
        List<String> report = new ArrayList<>();
        report.add(FIRST_REPORT_LINE);
        Map<String, Integer> allFruitsAndQuantities = fruitShopDao.getAllFruitsAndQuantities();
        StringBuilder builder = new StringBuilder();

        for(Map.Entry<String, Integer> entry : allFruitsAndQuantities.entrySet()) {
            builder.append(entry.getKey()).append(",").append(entry.getValue());
            report.add(builder.toString());
            builder.setLength(0);
        }
        return report;
    }
}
