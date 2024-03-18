package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.CreateReportService;

import java.util.ArrayList;
import java.util.List;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String FRUIT_HEADER = "fruit";
    private static final String QUANTITY_HEADER = "quantity";
    private final FruitDao fruitDao = new FruitDao();

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add(FRUIT_HEADER);
        report.add(QUANTITY_HEADER);

        fruitDao.getBalance()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + ", " + entry.getValue().toString())
                .forEach(report::add);

        return report;
    }
}
