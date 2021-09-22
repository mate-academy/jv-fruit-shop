package core.basesyntax.service;

import core.basesyntax.db.FruitRecordsDao;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.operationstrategy.OperationStrategy;
import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";
    private static final int FIRST_ELEMENT_INDEX = 0;
    private final OperationStrategy operationStrategy;
    private final FruitRecordsDao fruitRecordsDao;

    public FruitServiceImpl(OperationStrategy operationStrategy, FruitRecordsDao fruitRecordsDao) {
        this.operationStrategy = operationStrategy;
        this.fruitRecordsDao = fruitRecordsDao;
    }

    @Override
    public void saveFruitRecordsFromFile(List<TransactionDto> fruitRecordsList) {
        fruitRecordsList.forEach(t -> fruitRecordsDao.save(t.getFruit(),
                operationStrategy.get(t.getOperationType())
                        .doOperation(t)));
    }

    @Override
    public List<String> buildReportToList() {
        List<String> reportAsList = getAllAsList();
        reportAsList.add(FIRST_ELEMENT_INDEX, HEADER);
        return reportAsList;
    }

    private List<String> getAllAsList() {
        return fruitRecordsDao.getAll().entrySet()
                .stream()
                .map(e -> e.getKey().getFruitName() + COMMA + e.getValue())
                .collect(Collectors.toList());
    }
}
