package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private static final String COMMA_SEPARATOR = ",";
    private static final String FIRST_LINE = "fruit,quantity";
    private final FruitDao fruitDao;

    public ReportCreatorImpl() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(FIRST_LINE);
        for (Fruit fruit : fruitDao.getFruitsSet()) {
            builder.append(System.lineSeparator())
                    .append(fruit)
                    .append(COMMA_SEPARATOR)
                    .append(fruitDao.getQuantity(fruit));
        }
        return builder.toString().trim();
    }
}
