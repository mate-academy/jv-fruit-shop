package strategy;

import transaction.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler get(String operation);
}
