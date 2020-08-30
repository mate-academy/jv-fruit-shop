package core.basesyntax.goods;

import java.time.DateTimeException;
import java.time.LocalDate;

public class FruitPack {
    private static final LocalDate TODAY = LocalDate.now();
    private String type;
    private LocalDate expDate;
    private int quantity;

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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static void checkExpDate(LocalDate expDate) {
        if (expDate == null) {
            throw new DateTimeException("Invalid date input");
        }
        if (!expDate.isAfter(TODAY)) {
            throw new DateTimeException("Product is terminated");
        }
    }
}
