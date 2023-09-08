package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;

public class GeneratorImpl implements Generator {
    private static final String SEPARATOR = ",";
    private static final String TITLE = "fruit,quantity";
    private FruitDao fruitDao;

    public GeneratorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(TITLE).append(System.lineSeparator());
        fruitDao.getAll().forEach((key, value) -> report.append(key).append(SEPARATOR)
                .append(value).append(System.lineSeparator()));
        report.setLength(report.length() - 1);
        return report.toString();
    }
}
