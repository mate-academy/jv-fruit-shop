package core.basesyntax.service.impl;

import core.basesyntax.db.FruitShopDao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import core.basesyntax.service.ReportGenerationService;

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
        createReport.addAll(fruitShopDao.getAllFruitsAndQuantities()
                .entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList()));
        return createReport;
    }
}
