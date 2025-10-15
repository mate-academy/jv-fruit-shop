package core.basesyntax.report;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class ReportGeneratorImpl implements ReportGenerator {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public String getReport() {
        return fruitDao.getFruits().entrySet()
                .stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .reduce("fruit,quantity", (result, str) -> result + System.lineSeparator() + str);
    }
}
