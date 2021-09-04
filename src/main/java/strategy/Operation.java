package strategy;

import dto.Transaction;

public interface Operation {
    int apply(Transaction transaction);
}
