package core.basesyntax.servise.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.FruitTransactionProcessorService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionProcessorServiceImpl implements FruitTransactionProcessorService {
    private final OperationStrategy operationStrategy;

    public FruitTransactionProcessorServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public String process(List<FruitTransaction> fruitTransactions) {
        int amount = 0;
        StringBuilder reportBuilder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (java.lang.String uniqueFruits : getUniqueFruitsName(fruitTransactions)) {
            for (FruitTransaction transaction : fruitTransactions) {
                if (transaction.getFruit().equals(uniqueFruits)) {
                    amount += operationStrategy.get(transaction.getOperation())
                            .handle(transaction.getQuantity());
                }
            }
            reportBuilder.append(uniqueFruits)
                    .append(",")
                    .append(amount)
                    .append(System.lineSeparator());
            amount = 0;
        }
        return reportBuilder.toString();
    }

    private List<String> getUniqueFruitsName(List<FruitTransaction> fruitTransactions) {
        return fruitTransactions.stream()
                .map(FruitTransaction::getFruit)
                .distinct()
                .collect(Collectors.toList());
    }
}
