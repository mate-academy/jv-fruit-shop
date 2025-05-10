package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataConverter {
    public List<FruitTransaction> convert(List<String> rawData) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : rawData) {
            String[] parts = line.split(",");
            transactions.add(new FruitTransaction(parts[0], parts[1], Integer.parseInt(parts[2])));
        }
        return transactions;
    }
}

