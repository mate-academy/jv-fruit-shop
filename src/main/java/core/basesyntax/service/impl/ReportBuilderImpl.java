package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.service.ReportBuilder;
import java.util.Map;

public class ReportBuilderImpl implements ReportBuilder {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public String buildReport(Map<String, Integer> data) {
        StringBuilder sb = new StringBuilder();
        sb.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitDao.getStock().entrySet()) {
            sb.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
