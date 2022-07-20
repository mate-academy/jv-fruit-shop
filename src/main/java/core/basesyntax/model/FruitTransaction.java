package core.basesyntax.model;

import core.basesyntax.dao.DbReaderImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitTransaction {
    private final List<String> dataFromDb;

    public FruitTransaction() {
        this.dataFromDb = new DbReaderImpl().read();
    }

    public Map<String, Integer> getDailyTurnover() {
        Map<String, Integer> map = new HashMap<>();
        for (String s : dataFromDb) {
            if (s.startsWith(Operation.BALANCE.getOperation())) {
                map.put(s.substring(2, s.indexOf(",", 2)),
                        Integer.parseInt(s.substring(s.lastIndexOf(",") + 1)));
            }
            if (s.startsWith(Operation.SUPPLY.getOperation())) {
                map.replace(s.substring(2, s.indexOf(",", 2)),
                        map.get(s.substring(2, s.indexOf(",", 2)))
                                + Integer.parseInt(s.substring(s.lastIndexOf(",") + 1)));

            }
            if (s.startsWith(Operation.PURCHASE.getOperation())) {
                map.replace(s.substring(2, s.indexOf(",", 2)),
                        map.get(s.substring(2, s.indexOf(",", 2)))
                                - Integer.parseInt(s.substring(s.lastIndexOf(",") + 1)));

            }
            if (s.startsWith(Operation.RETURN.getOperation())) {
                map.replace(s.substring(2, s.indexOf(",", 2)),
                        map.get(s.substring(2, s.indexOf(",", 2)))
                                + Integer.parseInt(s.substring(s.lastIndexOf(",") + 1)));

            }
        }
        return map;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

    }
}
