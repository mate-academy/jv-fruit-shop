package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private final FruitsDao fruitsDao;

    public ReportCreatorImpl(FruitsDao fruitsDao) {
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
