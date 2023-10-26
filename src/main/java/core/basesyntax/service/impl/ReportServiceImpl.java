package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportService;
import java.util.Map;

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

        for (Map.Entry<String, Integer> fruit : fruitDao.getAll()) {
            report.append("\n")
                    .append(fruit.getKey())
                    .append(SEPARATOR)
                    .append(fruit.getValue());
        }

        return report.toString();
    }
}
