package service.impl;

import db.FruitShopDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import service.ReportGenerationService;

public class ReportGenerationServiceImpl implements ReportGenerationService {
    private static final String REPORT_FIRST_LINE = "fruit,quantity";
    private FruitShopDao fruitShopDao;

    public ReportGenerationServiceImpl(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public List<String> generateReport() {
        List<String> createReport = new ArrayList<>();
        createReport.add(REPORT_FIRST_LINE);
        Map<String, Integer> allFruitsAndQuantities = fruitShopDao.getAllFruitsAndQuantities();
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, Integer> entry : allFruitsAndQuantities.entrySet()) {
            builder.append(entry.getKey()).append(",").append(entry.getValue());
            createReport.add(builder.toString());
            builder.setLength(0);
        }
        return createReport;
    }
}
