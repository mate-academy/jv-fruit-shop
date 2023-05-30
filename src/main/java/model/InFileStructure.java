package model;

public class InFileStructure {
    private String type;
    private String fruit;
    private String quantity;

    public InFileStructure() {
        this.type = "type";
        this.fruit = "fruit";
        this.quantity = "quantity";
    }

    public InFileStructure(String type, String fruit, String quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }
}
