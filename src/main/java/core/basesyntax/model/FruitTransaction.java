package core.basesyntax.model;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FruitTransaction {
    private final OperationType operation;
    private final String name;
    private final int amount;

    public FruitTransaction(String operation, String fruit, int amount) {
        this.operation = OperationType.get(operation);
        this.name = fruit;
        this.amount = amount;
    }

    public String getFruitName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public OperationType getOperation() {
        return operation;
    }

    public enum OperationType {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;
        private static final Map<String, OperationType> ENUM_MAP;

        OperationType(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        static {
            Map<String, OperationType> map = new ConcurrentHashMap<>();
            for (OperationType instance : OperationType.values()) {
                map.put(instance.getCode().toLowerCase(), instance);
            }
            ENUM_MAP = Collections.unmodifiableMap(map);
        }

        public static OperationType get(String name) {
            return ENUM_MAP.get(name.toLowerCase());
        }
    }
}
