package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class FruitRecord {
    private final int fruitsAmount;
    private final Type operationType;
    private final Fruit fruit;

    public FruitRecord(int fruitsAmount, Type operationType, Fruit fruit) {
        this.fruit = fruit;
        this.fruitsAmount = fruitsAmount;
        this.operationType = operationType;
    }

    public int getAmount() {
        return fruitsAmount;
    }

    public Type getType() {
        return operationType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + fruitsAmount;
        result = 31 * result + (operationType == null ? 0 : operationType.hashCode());
        result = 31 * result + (fruit == null ? 0 : fruit.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object fruitRecord) {
        if (!(fruitRecord != null && fruitRecord.getClass().equals(FruitRecord.class))) {
            return false;
        }
        FruitRecord castedFruitRecord = (FruitRecord) fruitRecord;
        return (fruitsAmount == castedFruitRecord.fruitsAmount)
                && ((operationType == castedFruitRecord.operationType)
                || (operationType != null
                && operationType.equals(castedFruitRecord.operationType)))
                && ((fruit == castedFruitRecord.fruit)
                || (fruit != null && fruit.equals(castedFruitRecord.fruit)));
    }

    public enum Type {
        BALANCE("b"),
        SUPPLY("s"),
        RETURN("r"),
        PURCHASE("p");

        private static final Map<String, Type> operationTypes = new HashMap<>();

        static {
            for (Type type : values()) {
                operationTypes.put(type.operation, type);
            }
        }

        private final String operation;

        Type(String operation) {
            this.operation = operation;
        }

        public static Type getType(String label) {
            return operationTypes.get(label);
        }
    }
}
