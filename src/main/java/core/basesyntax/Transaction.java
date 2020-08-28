package core.basesyntax;

import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Transaction {
    private String fruitType;
    private int quantity;
    private LocalDate date;
    private boolean isEmpty;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        return quantity == transaction.quantity
                && isEmpty == transaction.isEmpty
                && Objects.equals(fruitType, transaction.fruitType)
                && Objects.equals(date, transaction.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitType, quantity, date, isEmpty);
    }
}
