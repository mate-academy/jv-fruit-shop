package strategy.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.FruitTransaction;
import strategy.Residue;

public class ResidueImpl implements Residue {
    @Override
    public Map<String, Integer> getResidue(List<FruitTransaction> fruitsTransactionData) {
        return Stream.of(new IncomeImpl().getIncome(fruitsTransactionData).entrySet(),
                        new ConsumptionImpl().getConsumption(fruitsTransactionData).entrySet())
                .flatMap(Set::stream)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (q1, q2) -> q1 - q2));
    }
}
