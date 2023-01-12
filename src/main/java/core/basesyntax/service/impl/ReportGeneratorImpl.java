package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitAccountingDao;
import core.basesyntax.dao.FruitAccountingDaoImpl;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_TITLE = "fruit,quantity" + System.lineSeparator();
    private static final String ELEMENT_SEPARATOR = ",";

    private FruitAccountingDao fruitAccountingDao;
    private StringBuilder builder;

    @Override
    public String generate() {
        fruitAccountingDao = new FruitAccountingDaoImpl();
        builder = new StringBuilder(REPORT_TITLE);
        for (Map.Entry<String, Integer> entry : fruitAccountingDao.getMapEntry()) {
            builder.append(entry.getKey())
                    .append(ELEMENT_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();

        /*return fruitAccountingDao.getMapEntry().stream()
                .map(m -> builder.append(m.getKey())
                        .append(",")
                        .append(m.getValue())
                        .append(System.lineSeparator()))
                .collect(Collectors.joining());*/
    }
}
