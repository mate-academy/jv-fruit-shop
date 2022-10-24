package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.strategy.ActivityStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final DataReader dataReader;
    private final ReportWriter reportWriter;
    private final ActivityStrategy activityStrategy;

    public FruitServiceImpl(ActivityStrategy activityStrategy,
                            DataReader dataReader,
                            ReportWriter reportWriter) {
        this.dataReader = dataReader;
        this.reportWriter = reportWriter;
        this.activityStrategy = activityStrategy;
    }

    @Override
    public void processData(String dataPath, String reportPath) {
        List<FruitTransaction> fruitTransactions = dataReader.readData(dataPath);
        fruitTransactions.forEach(activityStrategy::doActivity);
        reportWriter.writeReport(reportPath);
    }
}
