package strategy;

import model.TransactionDto;

public interface StrategyOperation {
    void apply(TransactionDto transactionDto);
}
