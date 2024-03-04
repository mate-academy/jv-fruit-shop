package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.quantity.handlers.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ReportServiceImpl implements ReportService {

    private static final String NEGATIVE_QUANTITY_ERROR_MESSAGE = "Quantity cannot be negative!";
    private static final String ARGUMENT_IS_NULL_ERROR_MESSAGE = "Argument must not be null";
    private FruitTransactionDao fruitTransactionDao;
    private OperationStrategy operationStrategy;

    public ReportServiceImpl(FruitTransactionDao fruitTransactionDao,
                             OperationStrategy operationStrategy) {
        Optional.ofNullable(fruitTransactionDao)
                .orElseThrow(()
                        -> new IllegalArgumentException(ARGUMENT_IS_NULL_ERROR_MESSAGE
                        + fruitTransactionDao));
        Optional.ofNullable(operationStrategy)
                .orElseThrow(()
                        -> new IllegalArgumentException(ARGUMENT_IS_NULL_ERROR_MESSAGE
                        + operationStrategy));
        this.fruitTransactionDao = fruitTransactionDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void generateFinalReport() {
        Map<String, Integer> report = prepareDataForReport();
        fruitTransactionDao.fetchTransactionSummaryData(report);
    }

    private Map<String, Integer> prepareDataForReport() {
        Map<String, Integer> fruitMap = new HashMap<>();
        List<FruitTransaction> dailyActivities = fruitTransactionDao.getAllTransactions();
        for (FruitTransaction fruitTransaction : dailyActivities) {
            Optional.ofNullable(fruitTransaction)
                    .orElseThrow(()
                            -> new NoSuchElementException(ARGUMENT_IS_NULL_ERROR_MESSAGE
                            + fruitTransaction));
            if (fruitTransaction.getQuantity() < 0) {
                throw new RuntimeException(NEGATIVE_QUANTITY_ERROR_MESSAGE);
            }
            OperationHandler operationHandler = operationStrategy.operate(
                        fruitTransaction.getOperation());
            operationHandler.handleTransaction(fruitTransaction, fruitMap);
        }
        return fruitMap;
    }
}
