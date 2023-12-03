package core.basesyntax;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataProcessor {
    public static List<FruitTransaction> processTransactions(List<FruitTransaction> transactions) {
        Map<String, Integer> fruitQuantities = transactions.stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit,
                        Collectors.summingInt(FruitTransaction::getQuantity)));

        return transactions;
    }
}
