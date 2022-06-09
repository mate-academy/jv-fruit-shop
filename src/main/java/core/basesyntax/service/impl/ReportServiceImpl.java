package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.handler.LeftoversHandler;

public class ReportServiceImpl implements ReportService {
    private FruitTransactionDao fruitTransactionDao;
    private LeftoversHandler leftoversHandler;

    public ReportServiceImpl(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public String getReport(String leftovers) {
        StringBuilder report = fruitTransactionDao.isEmpty()
                ? new StringBuilder()
                : new StringBuilder("fruit,quantity")
                .append(System.lineSeparator())
                .append(leftovers);
        return report.toString();
    }
}
