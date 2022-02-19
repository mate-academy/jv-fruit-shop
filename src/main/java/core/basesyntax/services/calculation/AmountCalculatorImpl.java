package core.basesyntax.services.calculation;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.services.operation.Strategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmountCalculatorImpl implements AmountCalculator {
    private final Strategy strategy;

    public AmountCalculatorImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Map<String, Integer> calculateDataForReport(List<TransactionDto> transactionDtos) {
        Map<String, Integer> fruitsStorage = new HashMap<>();
        for (TransactionDto transactionDto : transactionDtos) {
            int newAmount = strategy.get(transactionDto.getType())
                    .apply(transactionDto, fruitsStorage);
            fruitsStorage.put(transactionDto.getFruit(), newAmount);
        }
        return fruitsStorage;
    }
}
