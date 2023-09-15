package core.basesyntax.service.impl;

import core.basesyntax.model.FruitDto;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.strategy.OperationsHandler;
import core.basesyntax.strategy.OperationsStrategy;
import java.util.List;

public class DataProcessingServiceImpl implements DataProcessingService {
    private static final int NUMBER_OF_TITLE_LINES = 1;
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_SORT = 1;
    private static final int INDEX_OF_OPERATIONS_AMOUNT = 2;
    private static final String TRANSACTION_SEPARATOR = ",";
    private static final OperationsStrategy strategy = new OperationsStrategy();

    @Override
    public void processing(List<String> transactionsList) {
        OperationsHandler operationsHandler;

        for (String action : transactionsList.stream().skip(NUMBER_OF_TITLE_LINES).toList()) {
            String[] transaction = transactionParser(action);
            operationsHandler = strategy.getOperationsHandler(transaction[INDEX_OF_OPERATION_TYPE]);
            operationsHandler.operation(new FruitDto(transaction[INDEX_OF_FRUIT_SORT],
                    Integer.parseInt(transaction[INDEX_OF_OPERATIONS_AMOUNT])));
        }
    }

    private String[] transactionParser(String transactionsLine) {
        return transactionsLine.trim().split(TRANSACTION_SEPARATOR);
    }
}
