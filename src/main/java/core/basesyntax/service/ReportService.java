package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class ReportService {
    private static final String ANNOTATION = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private final FruitDao fruitDao = new FruitDaoImpl();

    public String generateReport() {
        StringBuilder result = new StringBuilder();
        result.append(ANNOTATION).append(System.lineSeparator());
        for (FruitDao.FruitDto fruit : fruitDao.getFruits()) {
            result.append(fruit.getFruit())
                    .append(SEPARATOR)
                    .append(fruit.getAmount())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}
