package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;

public interface GenerateReportService {

    String generateReport(FruitDao fruitDao);
}
