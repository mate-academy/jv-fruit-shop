package core.basesyntax.strategy;

import core.basesyntax.model.Record;
import core.basesyntax.model.Transaction;
import core.basesyntax.model.transactionimpl.Balance;
import core.basesyntax.model.transactionimpl.Purchase;
import core.basesyntax.model.transactionimpl.Return;
import core.basesyntax.model.transactionimpl.Supply;

public class TransactionSupplier {
    public static Transaction get(Record record) {
        switch (record.getTransactionAbbr()) {
            case "s": return new Supply(record.getFruitName(), record.getAmount());
            case "p": return new Purchase(record.getFruitName(), record.getAmount());
            case "r": return new Return(record.getFruitName(), record.getAmount());
            case "b": return new Balance(record.getFruitName(), record.getAmount());
            default: throw new RuntimeException("Invalid operation type");
        }
    }
}
