package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;

public interface ReportCreator {
    String createReport(FruitsDao fruitsDao);
}
