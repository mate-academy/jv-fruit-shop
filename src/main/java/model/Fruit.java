package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Fruit implements Comparable<Fruit> {
    private OperationType operationType;
    private String fruitName;
    private int value;

    public Fruit(OperationType typeOperation, String fruitName, int value) {
        this.operationType = typeOperation;
        this.fruitName = fruitName;
        this.value = value;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public enum OperationType {
        BALANCE("b"),
        SUPPLY("s"),
        RETURN("r"),
        PURCHASE("p");

        private static final Map<String, OperationType> mapTypes = new HashMap<>();
        static {
            for (OperationType type : OperationType.values()) {
                mapTypes.put(type.getNameType(), type);
            }
        }

        private String nameType;

        OperationType(String nameType) {
            this.nameType = nameType;
        }

        public String getNameType() {
            return nameType;
        }

        public void setNameType(String nameType) {
            this.nameType = nameType;
        }

        public static OperationType get(String nameType) {
            return mapTypes.get(nameType);
        }
    }

    public static boolean contains(String values) {
        for (OperationType operationFruit : OperationType.values()) {
            if (operationFruit.toString().equalsIgnoreCase(values)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Fruit operationFruit) {
        if (fruitName == null) {
            throw new RuntimeException("Fruit not found, value: " + fruitName);
        }
        return fruitName.compareTo(operationFruit.getFruitName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit that = (Fruit) o;
        return Objects.equals(fruitName, that.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName);
    }
}


