package core.basesyntax.model;

public enum FruitE {

    BANANA("banana"),
    APPLE("apple");

    private final String fruitTitle;

    FruitE(String operationTitle){
        this.fruitTitle = operationTitle;
    }

    public String getFruitTitle() {
        return fruitTitle;
    }
}
