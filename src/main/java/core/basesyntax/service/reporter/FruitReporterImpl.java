package core.basesyntax.service.reporter;

import core.basesyntax.dao.FruitQuantityDao;

public class FruitReporterImpl implements Reporter {
    private static final String DATA_SEPARATOR = ",";
    private static final String REPORT_HEADER = "fruit,quantity";
    private final FruitQuantityDao fruitQuantityDao;

    public FruitReporterImpl(FruitQuantityDao fruitQuantityDao) {
        this.fruitQuantityDao = fruitQuantityDao;
    }

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(REPORT_HEADER);
        for (String fruit : fruitQuantityDao.getAll().keySet()) {
            builder.append(System.lineSeparator())
                    .append(fruit)
                    .append(DATA_SEPARATOR)
                    .append(fruitQuantityDao.get(fruit));
        }
        return builder.toString();
    }
}
