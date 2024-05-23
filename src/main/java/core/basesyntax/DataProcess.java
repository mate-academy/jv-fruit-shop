package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class DataProcess {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int NUMBER = 2;
    private static final String COMMA = ",";
    private static final char ADD = '+';
    private static final char SUBTRACT = '-';

    public HashMap<String, Integer> process(String[] data) {
        HashMap<String, Integer> database = new HashMap<>();
        for (String datum : data) {
            String[] check = datum.split(COMMA);
            if (check[OPERATION].equals(Operation.BALANCE.getOperation())) {
                database.put(check[FRUIT], Integer.valueOf(check[NUMBER]));
            }
            if (check[OPERATION].equals(Operation.SUPPLY.getOperation())
                    || check[OPERATION].equals(Operation.RETURN.getOperation())) {
                mapIterator(database, ADD, check);
            }
            if (check[OPERATION].equals(Operation.PURCHASE.getOperation())) {
                mapIterator(database, SUBTRACT, check);
            }
        }
        return database;
    }

    private enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        private String getOperation() {
            return operation;
        }
    }

    private void mapIterator(HashMap<String, Integer> map, char action, String[] data) {
        switch (action) {
            case '+' -> {
                for (Map.Entry<String, Integer> set :
                        map.entrySet()) {
                    String key = set.getKey();
                    Integer value = set.getValue();
                    if (key.equals(data[FRUIT])) {
                        value += Integer.parseInt(data[NUMBER]);
                    }
                    map.replace(key, value);
                }
            }
            case '-' -> {
                for (Map.Entry<String, Integer> set :
                        map.entrySet()) {
                    String key = set.getKey();
                    Integer value = set.getValue();
                    if (key.equals(data[FRUIT])) {
                        value -= Integer.parseInt(data[NUMBER]);
                    }
                    map.replace(key, value);
                }
            }
            default -> {
            }
        }
    }
}
