package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ReportCreateService;
import java.util.Set;

public class FruitReportCreateService implements ReportCreateService {
    public static final String HEADER = "fruit,quantity";
    public static final String COMMA_SEPARATOR = ",";
    private final FruitDao fruitDao;

    public FruitReportCreateService() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public String createReport() {
        Set<String> fruits = fruitDao.getFruits();
        StringBuilder report = new StringBuilder(HEADER);
        for (String fruit : fruits) {
            report.append(System.lineSeparator())
                    .append(fruit)
                    .append(COMMA_SEPARATOR)
                    .append(fruitDao.getFruitQuantity(fruit));
        }
        return report.toString();
    }
}
