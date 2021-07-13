package core.basesyntax.service;

import core.basesyntax.dao.ReportsDao;
import core.basesyntax.model.Record;
import core.basesyntax.model.RecordsMapper;
import java.util.HashMap;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final ReportsDao reportsDao;
    private final OperationStrategy operationStrategy;
    private final RecordsMapper recordsMapper;
    private final Map<String, Integer> transactionsMap = new HashMap<>();

    public FruitShopServiceImpl(ReportsDao reportsDao, OperationStrategy operationStrategy,
                                RecordsMapper recordsMapper) {
        this.reportsDao = reportsDao;
        this.operationStrategy = operationStrategy;
        this.recordsMapper = recordsMapper;
    }

    @Override
    public void generateDailyReport(String dataSourceFilename, String reportFilename) {
        recordsMapper.map(dataSourceFilename).forEach(this::sortRecord);
        reportsDao.saveReport(transactionsMap, reportFilename);
    }

    private void sortRecord(Record record) {
        String fruit = record.getFruitName();
        Record.OperationType operation = record.getOperation();
        if (transactionsMap.get(fruit) == null) {
            transactionsMap.put(fruit, operationStrategy.get(operation).updateValue(record, 0));
        } else {
            transactionsMap.replace(fruit, operationStrategy.get(operation)
                    .updateValue(record, transactionsMap.get(fruit)));
        }
    }
}
