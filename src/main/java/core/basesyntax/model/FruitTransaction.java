package core.basesyntax.model;

import com.opencsv.bean.CsvBindByPosition;

public class FruitTransaction {
    @CsvBindByPosition(position = 0)
    private String operation;
    @CsvBindByPosition(position = 1)
    private String fruit;
    @CsvBindByPosition(position = 2)
    private int quantity;

//    public Operation getOperation() {
//        return operation;
//    }
//
//    public void setOperation(Operation operation) {
//        this.operation = operation;
//    }
//
//    public String getFruit() {
//        return fruit;
//    }
//
//    public void setFruit(String fruit) {
//        this.fruit = fruit;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
}
