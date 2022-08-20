package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import java.util.stream.Collectors;

public class CsvReportCreationImpl implements ReportCreation {
    private static final String HEADER = "fruit,quantity";
    private final FruitDao fruitDao;

    public CsvReportCreationImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String create() {
        return HEADER + fruitDao.getAll().entrySet().stream()
                .map(f -> System.lineSeparator()
                        + f.getKey()
                        + ","
                        + f.getValue())
                .collect(Collectors.joining());
    }
}
