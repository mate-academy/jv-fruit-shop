package model;

//this is a class for hold the structure of the input file
//we don't use it in this case, but it would be useful in real life
//in my implementation I take the structure from the input file.
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
