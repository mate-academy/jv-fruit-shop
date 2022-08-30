package model;

public class FruitDto {
    private String typeOfOperation;
    private String fruitName;
    private int value;

    public FruitDto() {
    }

    public FruitDto(String typeOfOperation, String fruitName, int value) {
        this.typeOfOperation = typeOfOperation;
        this.fruitName = fruitName;
        this.value = value;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "FruitDto{"
                + "typeOfOperation ='" + typeOfOperation
                + ", fruit ='" + fruitName
                + ", value =" + value
                + '}';
    }
}
