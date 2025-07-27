package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] parts = data.get(i).split(",");
            FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(parts[0]);
            transactions.add(new FruitTransaction(operation, parts[1], Integer.parseInt(parts[2])));
        }
        return transactions;
    }
}
