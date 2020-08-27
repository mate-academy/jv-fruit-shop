package core.basesyntax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static Map<String, DateAndQuantityPair> storage = new HashMap<>();

    public static class DateAndQuantityPair {
        private LocalDate date;
        private Integer quantity;
        private DateAndQuantityPair next = null;

        public DateAndQuantityPair(LocalDate date, Integer quantity) {
            this.date = date;
            this.quantity = quantity;
        }

        public DateAndQuantityPair getNext() {
            return next;
        }

        public void setNext(DateAndQuantityPair next) {
            this.next = next;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public Integer getQuantity() {
            Integer sum = 0;
            DateAndQuantityPair pair = this;
            while (pair.next != null) {
                sum += quantity;
                pair = pair.next;
            }
            return sum + pair.quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
