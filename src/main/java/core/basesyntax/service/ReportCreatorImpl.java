package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.FruitStorage;
import core.basesyntax.service.amount.AmountHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final Map<String, Integer> FRUIT_COUNT = FruitStorage.FRUIT_COUNT;
    private static final String DATA_SEPARATOR = ",";
    private final OperationStrategy operationStrategy;

    public ReportCreatorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<String> createReport() {
        FruitDao fruitDao = new FruitDaoImpl();
        List<FruitRecord> records = fruitDao.getRecords();
        for (FruitRecord record : records) {
            AmountHandler amountHandler = operationStrategy.get(record.getType());
            amountHandler.apply(record);
        }
        return FRUIT_COUNT.entrySet().stream()
                .map(row -> row.getKey() + DATA_SEPARATOR + row.getValue())
                .collect(Collectors.toList());
    }
}
