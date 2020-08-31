package core.basesyntax.goods;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

public class FruitPack {
    private static final LocalDate TODAY = LocalDate.now();
    private final String type;
    private final LocalDate expDate;
    private final int quantity;

    public FruitPack(String type, LocalDate expDate, int quantity) {
        this.type = type;
        this.expDate = expDate;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public FruitPack setQuantity(int quantity) {
        return new FruitPack(this.type, this.expDate, quantity);
    }

    public static boolean isPresent(FruitPack product) {
        if (product == null) {
            throw new IllegalArgumentException("Invalid input arguments");
        }
        return true;
    }

    public static void checkExpDate(LocalDate expDate) {
        if (expDate == null) {
            throw new DateTimeException("Invalid date input");
        }
        if (!expDate.isAfter(TODAY)) {
            throw new DateTimeException("Product is terminated");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitPack fruitPack = (FruitPack) o;
        return quantity == fruitPack.quantity
                && Objects.equals(type, fruitPack.type)
                && Objects.equals(expDate, fruitPack.expDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, expDate, quantity);
    }
}
