package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DayReportCalculatorService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayReportCalculatorServiceImpl implements DayReportCalculatorService {
    private final OperationStrategy operationStrategy;

    public DayReportCalculatorServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> reportCalculator(List<FruitTransaction> fruinTransactionList) {
        Map<String, Integer> dayReport = new HashMap<>();

        for (FruitTransaction transaction : fruinTransactionList) {
            OperationHandler operationHandlerForTransaction =
                    operationStrategy.get(transaction.getOperation());
            Integer quantityIncludingTransaction = operationHandlerForTransaction
                    .getQuantity(transaction.getQuantity(), transaction.getFruitName(), dayReport);

            dayReport.put(transaction.getFruitName(), quantityIncludingTransaction);
        }

        return dayReport;
    }
}
