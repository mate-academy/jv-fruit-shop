package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class FruitRecord {
    private String fruitName;
    private int fruitsAmount;
    private Type operationType;

    public FruitRecord(int fruitsAmount, String fruitName, Type operationType) {
        this.fruitName = fruitName;
        this.fruitsAmount = fruitsAmount;
        this.operationType = operationType;
    }

    public String getName() {
        return fruitName;
    }

    public int getAmount() {
        return fruitsAmount;
    }

    public Type getType() {
        return operationType;
    }

    public enum Type {
        BALANCE("b"),
        SUPPLY("s"),
        RETURN("r"),
        PURCHASE("p");

        private static final Map<String, Type> operationTypes = new HashMap<>();

        static {
            for (Type type: values()) {
                operationTypes.put(type.operation, type);
            }
        }

        private String operation;

        Type(String operation) {
            this.operation = operation;
        }

        public static Type getType(String label) {
            return operationTypes.get(label);
        }
    }
}
