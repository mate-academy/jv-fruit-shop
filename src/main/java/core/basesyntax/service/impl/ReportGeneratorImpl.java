package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private FruitDao fruitDao;

    public ReportGeneratorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String generateReport() {
        return fruitDao.getAll()
                .entrySet()
                .stream()
                .map(m -> new StringBuilder()
                        .append(m.getKey())
                        .append(SEPARATOR)
                        .append(m.getValue()))
                                .collect(Collectors.joining(System.lineSeparator()));
    }
}
