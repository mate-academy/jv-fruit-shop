package core.basesyntax.service;

import core.basesyntax.AbstractTransaction;
import core.basesyntax.BuyTransaction;
import core.basesyntax.ReturnTransaction;
import core.basesyntax.SupplyTransaction;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionLogService {
    public static final String SUPPLY = "s";
    public static final String BUY = "b";
    public static final String RETURN = "r";

    public List<AbstractTransaction> logTransactions(List<String[]> lines) {
        List<AbstractTransaction> transactions = new ArrayList<>();
        for (String[] line : lines) {
            AbstractTransaction transaction = null;
            if (line[0].equals(SUPPLY)) {
                transaction = new SupplyTransaction();
            }
            if (line[0].equals(BUY)) {
                transaction = new BuyTransaction();
            }
            if (line[0].equals(RETURN)) {
                transaction = new ReturnTransaction();
            }
            if (transaction != null) {
                transaction.setFruitType(line[1]);
                transaction.setQuantity(Integer.parseInt(line[2]));
                transaction.setDate(LocalDate.parse(line[3],
                        DateTimeFormatter.ISO_LOCAL_DATE));
                transactions.add(transaction);
            }
        }
        return transactions;
    }
}
