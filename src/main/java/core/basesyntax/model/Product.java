package core.basesyntax.model;

public class Product {
    private String nameOfProduct;
    private int number;

    public Product(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
