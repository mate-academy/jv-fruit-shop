package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.handler.LeftoversHandler;

public class ReportServiceImpl implements ReportService {
    private FruitTransactionDao fruitTransactionDao;
    private LeftoversHandler leftoversHandler;

    public ReportServiceImpl(FruitTransactionDao fruitTransactionDao,
                             LeftoversHandler leftoversHandler) {
        this.fruitTransactionDao = fruitTransactionDao;
        this.leftoversHandler = leftoversHandler;
    }

    @Override
    public String getReport() {
        String leftovers = leftoversHandler.getLeftovers(fruitTransactionDao.get());
        StringBuilder report = fruitTransactionDao.isEmpty()
                ? new StringBuilder()
                : new StringBuilder("fruit,quantity")
                .append(System.lineSeparator())
                .append(leftovers);
        return report.toString();
    }
}
