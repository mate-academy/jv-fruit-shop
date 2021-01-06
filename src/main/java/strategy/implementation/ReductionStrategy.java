package strategy.implementation;

import db.FruitStorage;
import exception.NegativeBalanceException;
import exception.NoSuchFruitException;
import model.FruitTransactionDto;
import strategy.OperationStrategy;

public class ReductionStrategy implements OperationStrategy {
    @Override
    public void apply(FruitTransactionDto transactionDto) {
        if (!FruitStorage.fruitStorage.containsKey(transactionDto.getFruit())) {
            throw new NoSuchFruitException("There are no '"
                    + transactionDto.getFruit().getName() + "' keys stored");
        }
        Integer oldAmount = FruitStorage.fruitStorage.get(transactionDto.getFruit());
        Integer inputAmount = transactionDto.getAmount();
        if (inputAmount < 0 || inputAmount > oldAmount) {
            throw new NegativeBalanceException("Invalid input: "
                    + inputAmount + ". Balance " + oldAmount);
        } else {
            FruitStorage.fruitStorage.put(transactionDto.getFruit(), oldAmount - inputAmount);
        }
    }
}
