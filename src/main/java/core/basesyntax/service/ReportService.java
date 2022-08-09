package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;

public interface ReportService {
    String createReport(FruitDao fruitDao, OperationStrategy operationStrategy);
}
