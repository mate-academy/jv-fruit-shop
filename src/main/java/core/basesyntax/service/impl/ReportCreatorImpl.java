package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportCreator;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final String SPLITERATOR = ",";
    private static final String HEADING = "fruit,quantity";
    private static final String SEPARATOR = System.lineSeparator();
    private final FruitDao fruitDao;

    public ReportCreatorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String createReport() {
        return HEADING + fruitDao.extract()
                .entrySet()
                .stream()
                .map(entry -> SEPARATOR
                        + entry.getKey()
                        + SPLITERATOR
                        + entry.getValue())
                .collect(Collectors.joining());
    }
}
