package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.fruit.Fruit;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private final FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(REPORT_HEADER)
                .append(System.lineSeparator());
        for (Fruit fruit : fruitDao.getAll()) {
            report.append(fruit.getName())
                    .append(SEPARATOR)
                    .append(fruit.getQuantity())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
