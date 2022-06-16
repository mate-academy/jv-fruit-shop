package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.CreatingReport;
import java.util.stream.Collectors;

public class CreatingReportImpl implements CreatingReport {
    private static final String COMA = ",";
    private static final String HEAD = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public String createReport() {
        String report = fruitDao.getData()
                .entrySet()
                .stream()
                .map(l -> LINE_SEPARATOR
                        + l.getKey()
                        + COMA
                        + l.getValue())
                .collect(Collectors.joining());
        report = HEAD + report;
        return report;
    }
}
