package core.basesyntax.service.impl;

import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationStrategy;

public class TransactionProcessService implements TransactionService {
    private static final int OPERATION = 0;
    private static final String COMMA = ",";
    private OperationStrategy activitiesStrategy;

    public TransactionProcessService(OperationStrategy activitiesStrategy) {
        this.activitiesStrategy = activitiesStrategy;
    }

    @Override
    public void process(String[] data) {
        for (String datum : data) {
            String[] check = datum.split(COMMA);
            activitiesStrategy.get(check[OPERATION]).processCommand(check);
        }
    }
}
