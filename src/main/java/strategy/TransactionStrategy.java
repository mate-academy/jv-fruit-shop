package strategy;

import servise.transaction.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler get(String operation);
}
