package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import java.util.Map;

public class ReportService {
    private static final String ANNOTATION = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private final FruitDao fruitDao = new FruitDaoImpl();

    public String generateReport() {
        StringBuilder result = new StringBuilder();
        result.append(ANNOTATION).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitDao.getEntrySet()) {
            result.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}
