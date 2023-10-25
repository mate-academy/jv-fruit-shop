package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER);

        for (Fruit fruit : fruitDao.getAll()) {
            report.append("\n")
                    .append(fruit.getName())
                    .append(SEPARATOR)
                    .append(fruit.getQuantity());
        }

        return report.toString();
    }
}
