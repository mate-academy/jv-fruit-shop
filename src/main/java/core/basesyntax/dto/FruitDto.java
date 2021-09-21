package core.basesyntax.dto;

public class FruitDto {
    private String typeOfOperation;
    private String nameOfFruit;
    private Integer amountOfFruit;

    public FruitDto(String typeOfOperation, String nameOfFruit, Integer amountOfFruit) {
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

    public Integer getAmountOfFruit() {
        return amountOfFruit;
    }
}
