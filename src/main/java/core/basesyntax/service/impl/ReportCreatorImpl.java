package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private final FruitDao fruitsDao;

    public ReportCreatorImpl(FruitDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder();
        for (String fruit: fruitsDao.getFruitsNames()) {
            reportBuilder.append(System.lineSeparator()).append(fruit)
                    .append(",").append(fruitsDao.get(fruit));
        }
        return reportBuilder.toString();
    }
}
