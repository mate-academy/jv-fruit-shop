package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.Reporter;
import java.util.Map;
import java.util.stream.Collectors;

public class ReporterImpl implements Reporter {
    private static final String REPORT_HEAD = "fruit,quantity" + System.lineSeparator();
    private static final String ELEMENTS_SEPARATOR = ",";
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public String createReport(Map<String, Integer> storage) {
        return REPORT_HEAD
                + fruitDao.getStorage().entrySet().stream()
                    .map(e -> e.getKey() + ELEMENTS_SEPARATOR + e.getValue())
                    .collect(Collectors.joining(System.lineSeparator()));
    }
}
