package strategy;

import db.FruitStorage;
import exception.InvalidAmountException;
import model.FruitTransactionDto;

public class AdditionStrategy implements OperationStrategy {
    @Override
    public void apply(FruitTransactionDto transactionDto) {
        if (!FruitStorage.fruitStorage.containsKey(transactionDto.getFruit())) {
            FruitStorage.fruitStorage.put(transactionDto.getFruit(), transactionDto.getAmount());
        } else {
            Integer inputAmount = transactionDto.getAmount();
            if (inputAmount < 0) {
                throw new InvalidAmountException("Can not perform " +
                        transactionDto.getOperation().toString() +
                        " with " + transactionDto.getAmount());
            } else {
                Integer oldAmount = FruitStorage.fruitStorage.get(transactionDto.getFruit());
                FruitStorage.fruitStorage.put(transactionDto.getFruit(), oldAmount + inputAmount);
            }
        }
    }
}
