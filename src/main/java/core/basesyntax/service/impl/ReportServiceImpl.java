package core.basesyntax.service.impl;

import core.basesyntax.dao.StoreCsvDao;
import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.quantity.handlers.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ReportServiceImpl implements ReportService {

    private static final String NEGATIVE_QUANTITY_ERROR_MESSAGE = "Quantity cannot be negative!";
    private static final String ARGUMENT_IS_NULL_ERROR_MESSAGE = "Argument must not be null";
    private static final int MINUS_ONE = -1;
    private StoreCsvDao storeCsvDao;
    private OperationStrategy operationStrategy;

    public ReportServiceImpl(StoreCsvDao storeCsvDao, OperationStrategy operationStrategy) {
        Optional.ofNullable(storeCsvDao)
                .orElseThrow(()
                        -> new IllegalArgumentException(ARGUMENT_IS_NULL_ERROR_MESSAGE
                        + storeCsvDao));
        Optional.ofNullable(operationStrategy)
                .orElseThrow(()
                        -> new IllegalArgumentException(ARGUMENT_IS_NULL_ERROR_MESSAGE
                        + operationStrategy));
        this.storeCsvDao = storeCsvDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void generateReport() {
        Map<String, Integer> report = prepareDataForReport();
        storeCsvDao.saveReportToFile(report);
    }

    private Map<String, Integer> prepareDataForReport() {
        Map<String, Integer> fruitMap = new HashMap<>();
        List<FruitTransaction> dailyActivities = storeCsvDao.getAll();
        for (FruitTransaction fruitTransaction : dailyActivities) {
            Optional.ofNullable(fruitTransaction)
                    .orElseThrow(()
                            -> new RuntimeException(ARGUMENT_IS_NULL_ERROR_MESSAGE
                            + fruitTransaction));
            if (fruitTransaction.getQuantity() > MINUS_ONE) {
                OperationHandler operationHandler = operationStrategy.operate(
                        fruitTransaction.getOperation());
                operationHandler.handleTransaction(fruitTransaction, fruitMap);
            } else {
                throw new RuntimeException(NEGATIVE_QUANTITY_ERROR_MESSAGE);
            }
        }
        return fruitMap;
    }
}
