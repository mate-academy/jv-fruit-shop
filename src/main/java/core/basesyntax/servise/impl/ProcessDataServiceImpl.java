package core.basesyntax.servise.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.ProcessDataService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessDataServiceImpl implements ProcessDataService {
    private final OperationStrategy operationStrategy;

    public ProcessDataServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public String processData(List<FruitTransaction> fruitTransactions) {
        int amount = 0;
        StringBuilder reportBuilder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (String uniqueFruits : getUniqueFruitsName(fruitTransactions)) {
            for (FruitTransaction transaction : fruitTransactions) {
                if (transaction.getFruit().equals(uniqueFruits)) {
                    amount += operationStrategy.get(transaction.getOperation())
                            .doOperation(transaction.getQuantity());
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
