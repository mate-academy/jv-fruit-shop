package core.basesyntax.service;

import core.basesyntax.strategy.ActivitiesStrategy;
import java.util.HashMap;

public class TransactionProcess {
    private static final int OPERATION = 0;
    private static final String COMMA = ",";
    private ActivitiesStrategy activitiesStrategy;

    public TransactionProcess(ActivitiesStrategy activitiesStrategy) {
        this.activitiesStrategy = activitiesStrategy;
    }

    public HashMap<String, Integer> process(String[] data) {
        HashMap<String, Integer> database = new HashMap<>();
        for (String datum : data) {
            String[] check = datum.split(COMMA);
            activitiesStrategy.get(check[OPERATION]).processCommand(database, check);
        }
        return database;
    }
}
