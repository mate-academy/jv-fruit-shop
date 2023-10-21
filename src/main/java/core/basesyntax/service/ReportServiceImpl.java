package core.basesyntax.service;

import core.basesyntax.dao.FruitDaoImpl;
import java.util.TreeSet;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";
    private FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder(HEADER);
        for (String key : new TreeSet<>(fruitDao.getFruits().keySet())) {
            stringBuilder.append(System.lineSeparator())
                    .append(key)
                    .append(SEPARATOR).append(fruitDao.getFruits().get(key));
        }
        return stringBuilder.toString();
    }
}
