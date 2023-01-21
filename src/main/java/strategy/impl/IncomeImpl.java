package strategy.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.FruitTransaction;
import strategy.Income;

public class IncomeImpl implements Income {
    @Override
    public Map<String, Integer> getIncome(List<FruitTransaction> fruitsTransactionData) {
        return Stream.of(new Balance().getInterimSettlement(fruitsTransactionData).entrySet(),
                        new Supply().getInterimSettlement(fruitsTransactionData).entrySet(),
                        new Returns().getInterimSettlement(fruitsTransactionData).entrySet())
                .flatMap(Set::stream)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));
    }
}
