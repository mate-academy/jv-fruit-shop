package core.basesyntax.fruitshop.impl;

import core.basesyntax.fruitshop.model.FruitTransaction;
import core.basesyntax.fruitshop.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String CSV_HEADER = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            if (line.equals(CSV_HEADER)) {
                continue;
            }
            String[] parts = line.split(",");
            FruitTransaction transaction = new FruitTransaction(
                    FruitTransaction.Operation.fromString(parts[0]),
                    parts[1],
                    Integer.parseInt(parts[2])
            );
            transactions.add(transaction);
        }
        return transactions;
    }
}
