package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity";
    private final FruitDao fruitsDao;

    public ReportCreatorImpl(FruitDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(HEADER);
        for (Map.Entry<String, Integer> fruit: fruitsDao.getAll().entrySet()) {
            reportBuilder.append(System.lineSeparator()).append(fruit.getKey())
                    .append(",").append(fruit.getValue());
        }
        return reportBuilder.toString();
    }
}
