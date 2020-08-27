package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class BuyOperation<T, M, M1> implements Operational<T, M, M1> {
    private static final DateTimeFormatter FORMATTER_DATE = DateTimeFormatter
            .ofPattern("yyyy-MM-dd");

    @Override
    public void operation(Transaction transaction, Map<String, Integer> store,
                          Map<String, LocalDate> expiration) {
        LocalDate expirationDate = LocalDate.parse(transaction.getDate(), FORMATTER_DATE);

        if (store.get(transaction.getFruit()) == null) {
            throw new RuntimeException("Store is empty yet");
        }
        if (store.get(transaction.getFruit()) < Integer.parseInt(transaction.getQuantity())) {
            throw new RuntimeException("Not enough fruits!");
        }
        if (expiration.get(transaction.getFruit()).isBefore(expirationDate)) {
            throw new RuntimeException("There is no fresh fruits anymore!");
        }
        Integer quantity = store.get(transaction.getFruit())
                - Integer.parseInt(transaction.getQuantity());
        store.put(transaction.getFruit(), quantity);
    }
}
