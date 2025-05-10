package service.implementation;

import lombok.AllArgsConstructor;
import model.FruitTransaction;
import service.FruitService;
import strategy.OperationStrategy;

import java.util.List;

@AllArgsConstructor
public class FruitServiceImpl implements FruitService {

    private final OperationStrategy operationStrategy;

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactions) {
        fruitTransactions
                .forEach(line ->
                        operationStrategy.get(line.getOperation()).processTransaction(line));
    }
}
