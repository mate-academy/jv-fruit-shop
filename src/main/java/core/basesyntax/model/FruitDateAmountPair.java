package core.basesyntax.model;

import java.time.LocalDate;

public class FruitDateAmountPair {
    private LocalDate date;
    private Integer amount;
    private FruitDateAmountPair next;

    public FruitDateAmountPair(LocalDate date, Integer amount) {
        this.date = date;
        this.amount = amount;
    }

    public FruitDateAmountPair getNext() {
        return next;
    }

    public void setNext(FruitDateAmountPair next) {
        this.next = next;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAllFruitAmountByDate(LocalDate date) {
        Integer sum = 0;
        FruitDateAmountPair fruit = this;
        while (fruit != null) {
            if (date.isBefore(fruit.getDate())) {
                sum += amount;
            }
            fruit = fruit.next;
        }
        return sum;
    }

    public Integer getAllFruitAmount() {
        Integer sum = 0;
        FruitDateAmountPair fruit = this;
        while (fruit.next != null) {
            sum += amount;
            fruit = fruit.next;
        }
        return sum + fruit.amount;
    }
}
