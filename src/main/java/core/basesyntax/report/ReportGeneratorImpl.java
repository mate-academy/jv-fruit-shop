package core.basesyntax.report;

import core.basesyntax.dao.FruitDao;

public class ReportGeneratorImpl implements ReportGenerator {
    private final FruitDao fruitDao;

    public ReportGeneratorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        return fruitDao.getFruits().entrySet()
                .stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .reduce("fruit,quantity", (result, str) -> result + System.lineSeparator() + str);
    }
}
