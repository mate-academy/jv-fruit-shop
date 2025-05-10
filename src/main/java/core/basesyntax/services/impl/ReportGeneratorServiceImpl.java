package core.basesyntax.services.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.services.ReportGeneratorService;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private final FruitDao fruitDao;

    public ReportGeneratorServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        fruitDao.getStorage().forEach((fruit, quantity) -> report.append(fruit)
                .append(",")
                .append(quantity)
                .append(System.lineSeparator()));

        return report.toString();
    }
}
