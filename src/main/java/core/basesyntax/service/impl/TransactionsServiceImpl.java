package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionsService;
import java.util.ArrayList;
import java.util.List;

public class TransactionsServiceImpl implements TransactionsService {
    private final List<String> lines;

    public TransactionsServiceImpl(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public List<FruitTransaction> getFruitTransactions() {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] split = lines.get(i).split(",");
            transactions.add(new FruitTransaction(split[0], split[1], Integer.parseInt(split[2])));
        }
        return transactions;
    }
}
