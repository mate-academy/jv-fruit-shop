package strategy;

import model.FruitTransactionDto;

public interface OperationStrategy {
    void apply(FruitTransactionDto transactionDto);
}
