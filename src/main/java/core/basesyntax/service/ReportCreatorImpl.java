package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.Report;
import core.basesyntax.service.amount.AmountHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final Map<String, Integer> REPORT_RAW_DATA = Report.REPORT_RAW_DATA;
    private static final String DATA_SEPARATOR = ",";
    private final OperationStrategy operationStrategy;

    public ReportCreatorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<String> createReport() {
        FruitsDao fruitsDao = new FruitsDaoImpl();
        List<FruitRecord> records = fruitsDao.getRecords();
        for (FruitRecord record : records) {
            AmountHandler amountHandler = operationStrategy.get(record.getType());
            amountHandler.apply(record);
        }
        return REPORT_RAW_DATA.entrySet().stream()
                .map(row -> row.getKey() + DATA_SEPARATOR + row.getValue())
                .collect(Collectors.toList());
    }
}
