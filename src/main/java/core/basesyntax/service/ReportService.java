package core.basesyntax.service;

import core.basesyntax.dao.StoreCsvDao;

public interface ReportService {

    void generateReport(String toFile);
}
