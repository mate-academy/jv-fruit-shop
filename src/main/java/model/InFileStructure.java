package model;

//this is a class for hold the structure of the input file
//we don't use it in this case, but it would be useful in real life
//in my implementation I take the structure from the input file.
public class InFileStructure {
    private String column1;
    private String column2;
    private String column3;

    public InFileStructure() {
        this.column1 = "";
        this.column2 = "";
        this.column3 = "";
    }

    public InFileStructure(String column1, String column2, String column3) {
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
    }
}
