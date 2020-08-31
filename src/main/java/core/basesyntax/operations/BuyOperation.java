package core.basesyntax.operations;

import core.basesyntax.storage.Storage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class BuyOperation implements Operation {
    private final Map<String, Integer> stockBalance = Storage.getStockBalance();

    @Override
    public void provideOperation(String fruit, int quantity, String date) {
        checkExpirationDate(date);
        if (stockBalance.containsKey(fruit)) {
            int fruitsAmount = stockBalance.get(fruit);
            if (checkQuantity(fruitsAmount, quantity)) {
                stockBalance.merge(fruit, fruitsAmount, (a, b) -> b - quantity);
            } else {
                throw new RuntimeException("Unfortunately, these fruits are sold out. "
                        + "You can buy another.");
            }
        } else {
            throw new RuntimeException("There is no fruit in storage.");
        }
    }

    public boolean checkQuantity(int available, int quantity) {
        return available >= quantity;
    }

    public void checkExpirationDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate expirationDay = LocalDate.parse(date, formatter);
        if (LocalDate.now().minusDays(1) == expirationDay
                || LocalDate.now().isAfter(expirationDay)) {
            throw new RuntimeException("This fruit has expired!");
        }
    }
}
