package core.basesyntax.model;

import java.time.LocalDate;

public class FruitBatch {
    private String operation;
    private String fruitName;
    private int amount;
    private LocalDate batchDay;

    public FruitBatch(String operation, String fruitName, int amount, LocalDate batchDay) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.amount = amount;
        this.batchDay = batchDay;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getBatchDay() {
        return batchDay;
    }
}
