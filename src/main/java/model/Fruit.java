package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Fruit implements Comparable<Fruit> {
    private TypeOperation typeOperation;
    private String fruitName;
    private int value;

    public Fruit(TypeOperation typeOperation, String fruitName, int value) {
        this.typeOperation = typeOperation;
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

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public enum TypeOperation {
        BALANCE("b"),
        SUPPLY("s"),
        RETURN("r"),
        PURCHASE("p");

        private static final Map<String, TypeOperation> mapTypes = new HashMap<>();
        static {
            for (TypeOperation type : TypeOperation.values()) {
                mapTypes.put(type.getNameType(), type);
            }
        }

        private String nameType;

        TypeOperation(String nameType) {
            this.nameType = nameType;
        }

        public String getNameType() {
            return nameType;
        }

        public void setNameType(String nameType) {
            this.nameType = nameType;
        }

        public static TypeOperation get(String nameType) {
            return mapTypes.get(nameType);
        }
    }

    public static boolean contains(String values) {
        for (Fruit.TypeOperation operationFruit : Fruit.TypeOperation.values()) {
            if (operationFruit.toString().equalsIgnoreCase(values)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Fruit operationFruit) {
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


