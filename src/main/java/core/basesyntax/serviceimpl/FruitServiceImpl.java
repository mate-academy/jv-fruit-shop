package core.basesyntax.serviceimpl;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, String> calculateBalance(List<FruitTransaction> transaction) {
        return transaction.stream()
                .collect(groupingBy(FruitTransaction::getFruit, collectingAndThen(toList(),
                        list -> {
                        Integer quantityTotal = list.stream()
                                .map(c -> operationStrategy.get(c.getOperation())
                                .getOperationAction(c.getQuantity()))
                                .reduce(0, Integer::sum);
                        return quantityTotal.toString();
                        })));
    }
}
