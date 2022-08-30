package core.basesyntax.services.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.services.ReportCreator;

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
                    .append(",").append(fruitsDao.getAmount(fruit));
        }
        return reportBuilder.toString();
    }
}
