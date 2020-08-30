package core.basesyntax.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Fruit {
    private static Map<String, Fruit> fruitStorage = new HashMap<>();
    private LocalDate date;
    private Integer amount;
    private Fruit next;

    public Fruit(LocalDate date, Integer amount) {
        this.date = date;
        this.amount = amount;
    }

    public Fruit getNext() {
        return next;
    }

    public void setNext(Fruit next) {
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

    public static Map<String, Fruit> getFruitStorage() {
        return fruitStorage;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAllFruitAmountByDate(LocalDate date) {
        Integer sum = 0;
        Fruit pair = this;
        while (pair != null) {
            if (date.isBefore(pair.getDate())) {
                sum += amount;
            }
            pair = pair.next;
        }
        return sum;
    }

    public Integer getAllFruitAmount() {
        Integer sum = 0;
        Fruit pair = this;
        while (pair.next != null) {
            sum += amount;
            pair = pair.next;
        }
        return sum + pair.amount;
    }
}
