package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String ELEMENT_SEPARATOR = ",";
    private FruitDao fruitDao;
    private StringBuilder builder;

    {
        fruitDao = new FruitDaoImpl();
        builder = new StringBuilder(REPORT_TITLE);
    }

    @Override
    public String generate() {
        for (Map.Entry<String, Integer> entry : fruitDao.getMapEntry()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(ELEMENT_SEPARATOR)
                    .append(entry.getValue());
        }
        return builder.toString();
    }
}
