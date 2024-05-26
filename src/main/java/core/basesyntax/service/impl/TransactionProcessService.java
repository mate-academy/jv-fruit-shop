package core.basesyntax.service.impl;

import core.basesyntax.service.TransactService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;

public class TransactionProcessService implements TransactService {
    private static final int OPERATION = 0;
    private static final String COMMA = ",";
    private OperationStrategy activitiesStrategy;

    public TransactionProcessService(OperationStrategy activitiesStrategy) {
        this.activitiesStrategy = activitiesStrategy;
    }

    @Override
    public HashMap<String, Integer> process(String[] data) {
        HashMap<String, Integer> database = new HashMap<>();
        for (String datum : data) {
            String[] check = datum.split(COMMA);
            activitiesStrategy.get(check[OPERATION]).processCommand(database, check);
        }
        return database;
    }
}
