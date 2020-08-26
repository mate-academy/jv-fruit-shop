package core.basesyntax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static Map<String, DateAndQuantityPair> storage = new HashMap<>();

    public static class DateAndQuantityPair {
        public LocalDate date;
        public Integer quantity;

        public DateAndQuantityPair(LocalDate date, Integer quantity) {
            this.date = date;
            this.quantity = quantity;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
