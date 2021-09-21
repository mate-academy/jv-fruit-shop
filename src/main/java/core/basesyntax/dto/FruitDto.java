package core.basesyntax.dto;

public class FruitDto {
    private String typeOfOperation;
    private String nameOfFruit;
    private int amountOfFruit;

    public FruitDto(String typeOfOperation, String nameOfFruit, int amountOfFruit) {
        this.typeOfOperation = typeOfOperation;
        this.nameOfFruit = nameOfFruit;
        this.amountOfFruit = amountOfFruit;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public String getNameOfFruit() {
        return nameOfFruit;
    }

    public int getAmountOfFruit() {
        return amountOfFruit;
    }

}
