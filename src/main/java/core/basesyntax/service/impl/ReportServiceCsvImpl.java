package core.basesyntax.service.impl;

import static java.util.stream.Collectors.joining;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ReportService;

public class ReportServiceCsvImpl implements ReportService {
    private static final String HEADERS = "fruit,quantity";
    private static final String DELIMITER = ",";
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public String createReport() {
        return HEADERS + System.lineSeparator()
                + fruitDao.getAll().entrySet()
                .stream()
                .map(entry -> entry.getKey() + DELIMITER + entry.getValue())
                .collect(joining(System.lineSeparator()));
    }
}
